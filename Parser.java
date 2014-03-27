/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyprogrammer132;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Tatu
 */
public class Parser {

    private final HashMap _OpcodeList = new HashMap();
    private List<String> _Input = new ArrayList<>();

    public Parser() {
        //Read from file
        Input in = new Input();
        _Input = in.getInput();
        initOpcodes();
        parseToHex();
    }

    private void parseToHex() {
        for (int i = 0; i < _Input.size(); ++i) {
            String[] segments = _Input.get(i).split("\\s+");
            parseByLength(segments.length, segments);
            System.out.println();
        }
    }

    /* 
     TODO: Parse string to opcode + segments
     MOV a b ->> MOV, a, b
     Parse brackets [ and ]
     */
    private void parseByLength(int l, String[] segments) {
        switch (l) {
            case 1:
                System.out.println("0x" + getOpcodeHexString(segments[0]));
                break;
            case 2:
                parseFourBytes(segments);
                break;
            case 3:
                parseThreeBytes(segments);
                break;
            case 4:
                parseFourBytes(segments);
                break;
            default:
                System.out.println("DEFAULT");
                break;
        }
    }
    
    private void parseThreeBytes(String[] segments){
        int opcode = 0;
        byte b = 0; // 111 110 011 010
        for (int i = 1; i < segments.length; ++i) {
            if (segments[i].contains("[")) {
                b = (byte) (b | (1 << i - 1));
            }
        }
        if(b == 1) opcode++;
        System.out.print("0x" + Integer.toHexString(getOpcodeInt(segments[0]) + opcode) + " ");
         for(int i = 1; i < segments.length; ++i){
             System.out.print("0x" + Integer.toHexString(Integer.parseInt(segments[i].replaceAll("\\[|\\]", ""))) + " ");
         }
        
    }
    
    private void parseFourBytes(String[] segments) {
        int opcode = 0;
        byte b = 0; // 111 110 011 010
        for (int i = 1; i < segments.length; ++i) {
            if (segments[i].contains("[")) {
                b = (byte) (b | (1 << i - 1));
            }
        }

        switch (b) {
            case 6:
                opcode += 1;
                break;
            case 3:
                opcode += 2;
                break;
            case 2:
                opcode += 3;
                break;
            default:
                break;
        }
        
        for(int i = 0; i < segments.length; ++i){
            if(i == 0){
                System.out.print("0x" + Integer.toHexString(getOpcodeInt(segments[0]) + opcode) + " ");
                continue;
            }
            System.out.print("0x" + Integer.toHexString(Integer.parseInt(segments[i].replaceAll("\\[|\\]", ""))) + " ");
        }
    }

    private String getOpcodeHexString(String index) {
        return Integer.toHexString((int) _OpcodeList.get(index));
    }
    
    private int getOpcodeInt(String index) {
        return (int) _OpcodeList.get(index);
    }

    private void initOpcodes() {
        //Logic
        _OpcodeList.put("AND", 0x00);
        _OpcodeList.put("OR", 0x02);
        _OpcodeList.put("XOR", 0x04);
        _OpcodeList.put("NOT", 0x06);

        //Memory
        _OpcodeList.put("MOV", 0x7);

        //Math
        _OpcodeList.put("RANDOM", 0x09);
        _OpcodeList.put("ADD", 0x0a);
        _OpcodeList.put("SUB", 0x0c);

        //Control
        _OpcodeList.put("JMP", 0x0e);
        _OpcodeList.put("JZ", 0x10);
        _OpcodeList.put("JEQ", 0x14);
        _OpcodeList.put("JLS", 0x18);
        _OpcodeList.put("JGT", 0x1c);
        _OpcodeList.put("HALT", 0xff);

        //Utilities
        _OpcodeList.put("APRINT", 0x20);
        _OpcodeList.put("DPRINT", 0x22);
    }
}

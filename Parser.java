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
    
    private void parseToHex(){
        for(int i = 0; i < _Input.size(); ++i){
            String[] segments = _Input.get(i).split("\\s+");
            for(int j = 0; j < segments.length; ++j){
                if(j == 0){
                    System.out.print("0x" + Integer.toHexString(getOpcode(segments[j])).toUpperCase() + " ");
                } else {
                    System.out.print("0x" + segments[j].toUpperCase() + " ");
                }
            }
            System.out.println();
        }
    }
    
    /* 
    TODO: Parse string to opcode + segments
    MOV a b ->> MOV, a, b
    Parse brackets [ and ]
    */
    
    private int getOpcode(String index){
        return (int)_OpcodeList.get(index);
    }
    
    private void initOpcodes() {
        //Logic
        _OpcodeList.put("AND", 0x00);
        _OpcodeList.put("OR", 0x02);
        _OpcodeList.put("XOR", 0x04);
        _OpcodeList.put("NOT", 0x06);

        //Memory
        _OpcodeList.put("MOV", 0x0);

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

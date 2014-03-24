/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyprogrammer132;

import java.util.HashMap;

/**
 *
 * @author Tatu
 */
public class Parser {

    private final HashMap _Opcode = new HashMap();

    public Parser() {
        initOpcodes();
        int x = (int) _Opcode.get("OR");
    }

    public void initOpcodes() {
        //Logic
        _Opcode.put("AND", 0x00);
        _Opcode.put("OR", 0x02);
        _Opcode.put("XOR", 0x04);
        _Opcode.put("NOT", 0x06);

        //Memory
        _Opcode.put("MOV", 0x0);

        //Math
        _Opcode.put("RANDOM", 0x09);
        _Opcode.put("ADD", 0x0a);
        _Opcode.put("SUB", 0x0c);

        //Control
        _Opcode.put("JMP", 0x0e);
        _Opcode.put("JZ", 0x10);
        _Opcode.put("JEQ", 0x14);
        _Opcode.put("JLS", 0x18);
        _Opcode.put("JGT", 0x1c);
        _Opcode.put("HALT", 0xff);

        //Utilities
        _Opcode.put("APRINT", 0x20);
        _Opcode.put("DPRINT", 0x22);
    }
}

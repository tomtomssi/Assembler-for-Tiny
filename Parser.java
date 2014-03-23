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
        initOPCODE();
        int x = (int)_Opcode.get("OR");
    }
    
    public void initOPCODE(){
        _Opcode.put("AND", 1);
        _Opcode.put("OR", 0x02);
        _Opcode.put("XOR", "0x04");
        _Opcode.put("NOT", "0x06");
    }
}

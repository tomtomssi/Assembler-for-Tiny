/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyprogrammer132;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tatu
 */
public class Input {

    private List<String> _Input;
    private static final String FILE_LOCATION = "D:\\Programming\\Netbeans\\DailyProgrammer132\\src\\dailyprogrammer132\\code.txt";

    public Input() {
        _Input = new ArrayList<>();
        findWords();
    }

    private void findWords() {
        BufferedReader br = null;
        try {
            String sLine;
            int count = 0;
            br = new BufferedReader(new FileReader(FILE_LOCATION));
            while ((sLine = br.readLine()) != null) {
                _Input.add(sLine);
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addresswithlambdas.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FileIO {
        public void writeArray(String filename, ArrayList<String> adds) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter(filename));

            for (String element : adds) {
                output.println(element);
                element = "";
            }
            output.flush();
            output.close();
        } catch (IOException e) {
            System.out.println("File Write failed: " + e.getMessage());
        }
    }

    //@Override
    public ArrayList<String> readArray(String filename) {
        ArrayList<String> adds = new ArrayList<>();
        try {
            Scanner file = new Scanner(new BufferedReader(new FileReader(filename)));
            String line;
            String element;
            while (file.hasNextLine()) {
                line = file.nextLine();
                adds.add(line);
            }
            file.close();
        } catch (FileNotFoundException e) {

        }
        return adds;
    }

}

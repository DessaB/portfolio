package DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author * @author Dessa && Anthony
 */
public class FileIO {

    public ArrayList readFile(String fileName) throws FileNotFoundException {
        ArrayList<String[]> fileInfo = new ArrayList<>();
        try (Scanner file = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            String line;
            String[] splitLine;
            while (file.hasNextLine()) {
                line = file.nextLine();
                splitLine = line.split(",");
                fileInfo.add(splitLine);
            }
        }
        return fileInfo;
    }
   
    /////////////production/test mode
    public String readConfig(String fileName){
        String configStatus = "";
        try(Scanner cf = new Scanner(new BufferedReader(new FileReader(fileName)))){
            configStatus = cf.next();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return configStatus;
    }

//    public void writeFile(ArrayList<String[]> line, String fileName) throws IOException {
//        PrintWriter output = new PrintWriter(new FileWriter(fileName));
//        for (int i = 0; i < line.size() - 1; i++) {
//            output.print(line.get(i) + ",");
//        }
//        output.println(line.get(line.size() - 1));
//    }
//    public static void main(String[] args) {
//        FileIO fio = new FileIO();
//        HashMap<String, ArrayList<String []>> testy = new HashMap<>();
//        ArrayList<String[]> arraything = new ArrayList<>();
//        String [] things = {"Things", "whatever", "blah"};
//        String [] thingsw = {"Thixngs", "wxhatever", "blxah"};
//        arraything.add(things);
//        arraything.add(thingsw);
//        ArrayList<String[]> arraything2 = new ArrayList<>();
//        String [] things2 = {"Things", "whatever", "blah"};
//        String [] thingsw2 = {"Thixngs", "wxhatever", "blxah"};
//        arraything2.add(things2);
//        arraything2.add(thingsw2);
//        
//        testy.put("file1", arraything);
//        testy.put("file2", arraything2);
//        
//        try{fio.parseFile(testy);} catch (Exception e) {}
//        
//    }
    public void writeToFile(HashMap<String, ArrayList<String[]>> hashy) {
        PrintWriter output;
        Set<String> keys = hashy.keySet();
        ArrayList<String[]> dummy;
        String [] dummy2;
        try {
            String out = "";
            for (String k : keys) {
                output = new PrintWriter(new FileWriter(k));
                dummy = hashy.get(k);
                for (int j = 0; j < dummy.size() ; j++) {
                    out = "";
                    dummy2 = dummy.get(j);
                    for (int l = 0; l < dummy2.length  -1; l++) {
                        out += dummy2[l] + ",";
                    }
                    out += dummy2[dummy2.length -1];
                    output.println(out);
                }
                output.flush();
                output.close();
            }
        } catch (Exception e) {}
    }
}



//
// Set<String> keys = library.keySet();
//        String allDVDs = "";
//        for (String k : keys) {
//            allDVDs += library.get(k).saveString() + "\n";
//        }
//        return allDVDs;

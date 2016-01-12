

package DAO;
import UI.ConsoleIO;
import java.io.*;
import java.util.Scanner;
import operations.DVDLibrary;
/**
 *
 * @author Suzanne Ludwig && Dessa
 */
public class FileAccess {
    static String fileName = "dvds.txt";
    static ConsoleIO cio = new ConsoleIO();
    static DVDLibrary lib = new DVDLibrary();
    
 
    
    public void saveFile(DVDLibrary editedLib) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileName));
            out.print(editedLib.saveAllDVDs());
            out.flush();
            out.close();
        } catch (IOException e) {
            cio.write("IOException found: " + e.getMessage());
        }
    }
    
    public DVDLibrary importFile() {
        try {
            Scanner file = new Scanner(new BufferedReader(new FileReader(fileName)));
            String line;
            String[] splitLine;
            while (file.hasNextLine()) {
                line = file.nextLine();
                splitLine = line.split("::");
                
                lib.addDVD( splitLine[0], splitLine[1], splitLine[2], 
                        splitLine[3], splitLine[4], splitLine[5]);
                
            }
            file.close();
        } catch (FileNotFoundException e) {
            cio.write("File not found: " + e.getMessage());
        }
        return lib;
    }
}

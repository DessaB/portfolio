

package DTO;

import DAO.FileAccess;
import UI.ConsoleIO;
import UI.MenuGenerator;
import operations.DVDLibrary;
import DAO.FileAccess;

/**
 *
 * @author Suzanne Ludwig && Dessa
 */
public class DVDcontroller {
    static ConsoleIO cio = new ConsoleIO();
    static FileAccess fa = new FileAccess();
    static DVDLibrary lib = fa.importFile();
    
    public static void main(String[] args) {


        MenuGenerator menu = new MenuGenerator();
        ConsoleIO cio = new ConsoleIO();
        FileAccess fa = new FileAccess();

        int numItems;
        int choice;
        
        do {
            numItems = menu.makeMenu("Add a DVD", "Remove a DVD", "Search DVDs by title", "Edit a DVD's entry", "List All DVDs", "List By year", "Quit program");
            choice = cio.readInteger("> ", 1, numItems);

            switch(choice) {
                case 1:
                    addDVDInfo();
                    break;
                case 2:
                    remDVD();
                    break;
                case 3:
                    findDVD();
                    break;
                case 4:
                    editDVDEntry();
                    break;
                case 5:
                    listDVDS();
                    break;
                case 6:
                    fa.saveFile(lib);
                    break;
            }
        } while (choice != numItems);
    
        cio.write("So sad to see you go.");
        
    } //main
    
    
    
    static private void addDVDInfo () {
        String title = cio.readString("Please enter a title > ");
        String date = cio.readString("Please enter a date > ");
        String rating = cio.readString("Please enter a rating > ");
        String director = cio.readString("Please enter a director > ");
        String studio = cio.readString("Please enter a studio > ");
        String note = cio.readString("Please enter a note > ");
        lib.addDVD(title, date, rating, director, studio, note);
        cio.write("\nDVD " + title + " added.\n\n");
        cio.write("*************************\n\n");
    }
    
    
    
    static private void remDVD() {
        String title = cio.readString("Which title would you like to remove? > ");
        boolean dvdExists = lib.removeDVD(title);
        if(dvdExists) {
            cio.write(title + " successfully removed.\n\n");
            cio.write("*************************\n\n");
        }
        else {
            cio.write(title + " not found.\n\n");
            cio.write("*************************\n\n");
        }
    }
    
    static private void findDVD() {
        String title = cio.readString("Search by title: ");
        String response = lib.searchDVDs(title);
        cio.write("\n" + response + "\n\n");
        cio.write("*************************\n\n");
    }
    
    private static void editDVDEntry() {
        String titleKey = cio.readString("Edit which title: ");
        String title = cio.readString("New title > ");
        String date = cio.readString("New date > ");
        String rating = cio.readString("New rating > ");
        String director = cio.readString("New director > ");
        String studio = cio.readString("New studio > ");
        String note = cio.readString("New note > ");
        lib.removeDVD(titleKey);
        lib.addDVD(title, date, rating, director, studio, note);
    }
    private static void listDVDS() {
        cio.write(lib.getAllDVDs());
        cio.write("\n\n*************************\n\n");
    }
}

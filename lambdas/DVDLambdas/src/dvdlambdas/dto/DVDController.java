/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlambdas.dto;

import dvdlambdas.dao.FileIO;
import dvdlambdas.operations.DVD;
import dvdlambdas.operations.DVDLibrary;
import dvdlambdas.ui.ConsoleIO;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DVDController {

    public static DVD newDVD;
    public static ArrayList<DVD> dvdArray = new ArrayList<>();
    public static DVDLibrary newLib = new DVDLibrary(dvdArray);
    public static ConsoleIO c = new ConsoleIO();
    public static FileIO fio = new FileIO();

    public void Initiate() throws FileNotFoundException {
        boolean playAgain = true;
        int menuChoice;

        try {
            loadOnStart();
        } catch (Exception ex) {
            Logger.getLogger(DVDController.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Welcome to the DVD library!\n");
        do {
            System.out.println("1. Add an DVD\n"
                    + "2. Remove a DVD\n"
                    + "3. List the DVD's\n"
                    + "4. Find number of DVD's with a Title\n"
                    + "5. Find DVD by Title\n"
                    + "6. Find by year back\n"
                    + "7. Find by MPAA\n"
                    + "8. Find by Director\n"
                    + "9. Find by Studio\n"
                    + "10. Find average year of all movies in the collection\n"
                    + "11. Find the newest movie\n"
                    + "12. Find the oldest movies\n"
                    + "13. End");
            menuChoice = c.readInteger("Enter the number of your choice:", 1, 13);

            switch (menuChoice) {
                case 1:
                    addDVD();

                    break;
                case 2:
                    removeDVD();

                    break;
                case 3:
                    viewAll();

                    break;
                case 4:
                    numberOfTitles();

                    break;
                case 5:
                    findDVD();

                    break;
                    
                case 6:
                    newLib.findByYear();
                    break;
                    
                case 7:
                    newLib.findByMpaa();
                    break;
                    
                case 8:
                    newLib.findByDirector();
                    break;
                    
                case 9:
                    newLib.findByStudio();
                    break;
                    
                case 10:
                    newLib.averageAge();
                    break;
                    
                case 11:
                    newLib.newestMovie();
                    break;
                    
                case 12:
                    newLib.oldestMovie();
                    break;
                    
                case 13:
                    playAgain = false;
                    saveOnEnd();
                    break;
                    
                default:
                    playAgain = false;
                    saveOnEnd();

                    break;
            }
        } while (playAgain);

    }

    public static void addDVD() {
        String title,
                year,
                rating,
                dirName,
                runtime,
                userNote,
                studio,
                mpaa;
        title = c.readString("Title: ");
        year = c.readString("Year: ");
        rating = c.readString("Rating: ");
        dirName = c.readString("Director Name: ");
        runtime = c.readString("Runtime: ");
        userNote = c.readString("Note: ");
        studio = c.readString("Studio: ");
        mpaa = c.readString("MPAA: ");

        newDVD = new DVD(title, year, rating, dirName, userNote, runtime,studio,mpaa);
        newLib.add(newDVD);
    }

    public static void viewAll() {
        dvdArray = newLib.getAll();
        for (DVD a : dvdArray) {
            int num = dvdArray.indexOf(a);
            System.out.println("\nEntry #: " + (num + 1));
            printDVD(a);
        }

    }

    public static void printDVD(DVD a) {
        System.out.println("");
        System.out.println("Title: " + a.getTitle() + " ");
        System.out.println("Year: " + a.getYear() + " ");
        System.out.println("Rating: " + a.getRating() + " ");
        System.out.println("Director: " + a.getDirName() + ", ");
        System.out.println("Runtime: " + a.getRuntime());
        System.out.println("Note: " + a.getUserNote());
        System.out.println("Studio: " + a.getStudio());
        System.out.println("MPAA: " + a.getMpaa());
        System.out.println("\n");
    }

    public static void removeDVD() {
        viewAll();
        String str = c.readString("Enter Title of DVD to remove: ");
        newDVD = newLib.find(str);
        if (newDVD == null) {
            System.out.println("We could not find that Title");
        } else {
            newLib.remove(newDVD);
            System.out.println("\nDVD Removed.\n");
        }
    }

    public static void numberOfTitles() {
        String str = c.readString("Enter Title of DVD to search: ");
        newLib.findTitleNum(str);
    }

    public static void findDVD() {
        String str = c.readString("Enter the title of the DVD you are trying to find: ");
        newDVD = newLib.find(str);
        if (newDVD == null) {
            System.out.println("We could not find that Title");
        } else {
            printDVD(newDVD);
        }
    }

    public static void loadOnStart() {

        ArrayList<String> tempLib = new ArrayList<>();
        String[] splitLine;
        tempLib = fio.readArray("dvdlist.txt");
        for (String str : tempLib) {
            splitLine = str.split("::");
            DVD temp = new DVD(splitLine[0],
                    splitLine[1], splitLine[2], splitLine[3],
                    splitLine[4], splitLine[5],splitLine[6],splitLine[7]);
            newLib.add(temp);
        }
    }

    public static void saveOnEnd(){

        String outString;
        ArrayList<String> arrDVD = new ArrayList<>();
        dvdArray.clear();
        dvdArray = newLib.getAll();
        DVD current;
        Iterator<DVD> iter = dvdArray.iterator();
        while (iter.hasNext()) {
            current = iter.next();
            outString = current.getTitle() + "::"
                    + current.getYear() + "::"
                    + current.getRating() + "::"
                    + current.getDirName() + "::"
                    + current.getUserNote() + "::"
                    + current.getRuntime() + "::"
                    + current.getStudio() + "::"
                    + current.getMpaa();
            arrDVD.add(outString);

        }
        fio.writeArray("dvdlist.txt", arrDVD);
    }
}
    
    
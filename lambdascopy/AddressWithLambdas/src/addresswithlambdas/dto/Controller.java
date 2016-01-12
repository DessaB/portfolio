/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addresswithlambdas.dto;

import addresswithlambdas.dao.FileIO;
import java.util.ArrayList;
import addresswithlambdas.operations.Address;
import addresswithlambdas.operations.AddressBook;
import addresswithlambdas.ui.ConsoleIO;

/**
 *
 * @author apprentice
 */
public class Controller {

    public static Address newAddress;
    public static ArrayList<Address> addressArray = new ArrayList<>();
    public static AddressBook newBook = new AddressBook(addressArray);
    public static ConsoleIO c = new ConsoleIO();
    public static ArrayList<Address> lastNameArray = new ArrayList<>();
    public static FileIO fio = new FileIO();

    public void initiate() {

        boolean playAgain = true;
        int menuChoice = 0;
        String str = "";

        loadOnStart();

        c.write("Welcome to Tai, Dessa and Chet's Address Book!\n\n");
        do {
            c.write("1. Add an Address\n"
                    + "2. Remove an address in Address book\n"
                    + "3. Returns the number of addresses in Address book\n"
                    + "4. List all addresses in Address book\n"
                    + "5. Find address by last name\n"
                    + "6. Find address by City\n"
                    + "7. Find address by Zip code \n"
                    + "8. Find address by State\n"
                    + "9. End\n");

            menuChoice = c.readInteger("Enter your choice: ", 1, 9);
            c.write("\n");

            switch (menuChoice) {
                case 1:                         //Add address
                    addAddress();
                    break;

                case 2:                         //Remove address
                    removeAddress();
                    break;

                case 3:                         //Count addresses
                    countAddresses();
                    break;

                case 4:                         //View all
                    viewAll();
                    break;

                case 5:                         //Find address
                    findByLast();
                    break;

                case 6:
                    findByCity();
                    break;

                case 7:
                    findByZip();
                    break;

                case 8:
                    findByState();
                    break;

                case 9:                         //End program
                    playAgain = false;
                    saveOnEnd();
                    break;

            }

        } while (playAgain);

    }

    public static void viewAll() {
        addressArray = newBook.getAll();
        for (Address a : addressArray) {
            int num = addressArray.indexOf(a);
            c.write("\nEntry #: " + (num + 1) + "\n");
            printAddress(a);
        }
        c.write("\n\n");
    }

    public static void printAddress(Address a) {

        c.write("\n");
        c.write(a.getfName() + " ");
        c.write(a.getlName() + "\n");
        c.write(a.getStreet() + " \n");
        c.write(a.getCity() + ", ");
        c.write(a.getState() + ", ");
        c.write(a.getZip());
        c.write("\n\n");
    }

    public static void addAddress() {
        String fName,
                lName,
                street,
                city,
                state,
                zip;
        fName = c.readString("First Name: ");
        lName = c.readString("Last Name: ");
        street = c.readString("Street: ");
        city = c.readString("City: ");
        state = c.readString("State: ");
        zip = c.readString("ZIP: ");

        newAddress = new Address(fName, lName, street, city, state, zip);
        newBook.add(newAddress);
    }

    public static void removeAddress() {

        viewAll();
        String str = c.readString("Enter last name of record to remove: ");
        newAddress = newBook.find(str);
        newBook.remove(newAddress);
        c.write("\nRecord Removed.\n");

    }

    public static void countAddresses() {
        c.write("\nThere are " + newBook.count() + " addresses in the Address Book.\n\n");
    }

    public static void findAddresses() {
        String str = c.readString("Enter the last name you are trying to find: ");
        newAddress = newBook.find(str);
        printAddress(newAddress);
    }

    public static void saveOnEnd() {
        addressArray = newBook.getAll();
        ArrayList<String> newFile = new ArrayList<>();
        String outString = "", fileName = "savefile.txt";
        for (Address addr : addressArray) {
            outString = addr.getfName() + ","
                    + addr.getlName() + ","
                    + addr.getStreet() + ","
                    + addr.getCity() + ","
                    + addr.getState() + ","
                    + addr.getZip();
            newFile.add(outString);
        }
        fio.writeArray(fileName, newFile);

    }

    public static void loadOnStart() {
        String[] splitLine;
        ArrayList<String> newFile = fio.readArray("savefile.txt");
        for (String s : newFile) {
            splitLine = s.split(",");
            Address temp = new Address(splitLine[0],
                    splitLine[1], splitLine[2], splitLine[3],
                    splitLine[4], splitLine[5]);
            newBook.add(temp);
        }
        addressArray = newBook.getAll();

    }

    public static void findByLast() {
        String stc = c.readString("Please enter the last name you are trying to find: ");
        ArrayList<Address> tempArray = new ArrayList<>();
        tempArray = newBook.findWithLast(stc);
        for (Address add : tempArray) {
            printAddress(add);
        }
    }

    public static void findByCity() {
        String city = c.readString("Please enter the city you are trying to find: ");
  ArrayList<Address> tempArray = new ArrayList<>();
        tempArray = newBook.findWithCity(city);
        for (Address add : tempArray) {
            printAddress(add);
        }
    }

    public static void findByZip() {
        String zip = c.readString("Please enter the Zip code you are trying to find: ");
  ArrayList<Address> tempArray = new ArrayList<>();
        tempArray = newBook.findWithZip(zip);
        for (Address add : tempArray) {
            printAddress(add);
        }
    }

    public static void findByState() {
        String state = c.readString("Please enter the state you are trying to find: ");
  ArrayList<Address> tempArray = new ArrayList<>();
        tempArray = newBook.findWithState(state);
        for (Address add : tempArray) {
            printAddress(add);
        }
    }

}


// @author Dessa && Anthony
//TODO: implement prod mode
package DTO;

import DAO.FileIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import operations.Order;
import operations.OrderBook;
import ui.ConsoleIO;

public class Controller {

    static String dateToday;
    static ConsoleIO cio = new ConsoleIO();
    static FileIO fio = new FileIO();
    static OrderBook todaysBook = new OrderBook();
    static HashMap<String, double[]> productFile = new HashMap<>();
    static HashMap<String, Double> taxFile = new HashMap<>();
    static HashMap<String, OrderBook> allDates = new HashMap<>(); /*Holds all orderbooks loaded 
     in to working memory*/


    //arraylist books (is static). put new new hashmap

    public static void main(String[] args) {
        initialize();

        int numOptions;
        int choice;

        cio.write("Flooring Program\n\n");
        do {
            numOptions = cio.makeMenu("Display Orders", "Add an order", "Edit an order", "Remove an order", "Save current work", "Quit");

            cio.write("\n");
            choice = cio.readInteger("> ", 1, numOptions);

            switch (choice) {
                case 1:
                    showOrder();
                    break;
                case 2:
                    newOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    remOrder();
                    break;
                case 5: saveFile();//save order
                    break;
                case 6: quitOrders();//quit
                    break;
            }

        } while (choice != numOptions);

    } //main

    static private void newOrder() {
        String name, state, product, dateKey;
        double area, costPerSqFt, laborCostPerSqFt, taxRate;
        //May need to verify if today has a file associated.
        todaysBook = allDates.get(dateToday);
        name = cio.readString("Please enter the customer's last name. >");

        do {
            state = cio.readStringToCaps("Please enter a state. >");
        } while (!verifyStateEntry(state));

        do {
            product = cio.readStringToSentenceCase("Please enter a product type. Available options:\n" + listProducts()); //TODO: Product menu
        } while (!verifyProductEntry(product));

        taxRate = taxFile.get(state);
        area = cio.readDouble("How large of an area are you covering with " + product + " ?");
        costPerSqFt = productFile.get(product)[1];
        laborCostPerSqFt = productFile.get(product)[2];

        todaysBook.addOrder(name, state, product, area, taxRate, costPerSqFt, laborCostPerSqFt);
    }

    static private void showOrder() {
        OrderBook bookToShow;
        String dateEntered = cio.readString("Please enter a date (format: MMDDYYYY)>");//TODO validate date entry
        String fileName = "orders_" + dateEntered + ".txt";

        if (allDates.containsKey(dateEntered)) {
            bookToShow = allDates.get(dateEntered);
            cio.write(bookToShow.displayOrdersByDate(dateEntered));
        } else if (fileExists(dateEntered)) {
            try {
                populateOrderBook(fio.readFile(fileName), dateEntered);
                bookToShow = allDates.get(dateEntered);
                cio.write(bookToShow.displayOrdersByDate(dateEntered));
            } catch (FileNotFoundException e) {
                cio.write("File not found: " + e.getMessage() + "\n\n");
            }
        } else {
            cio.write("No file exists for that date");
        }
    }

    static private void editOrder() {
        String name, state, product, area;
        String fileName, orderKey;
        OrderBook bookToEdit;
        Order orderToEdit;

        String dateEntered = cio.readString("Please enter a date (format: MMDDYYYY>");
        String orderNum = cio.readString("Please enter an order number:");
        fileName = "orders_" + dateEntered + ".txt";
        orderKey = dateEntered + orderNum;

        if (allDates.containsKey(dateEntered)) {
            bookToEdit = allDates.get(dateEntered);
            orderToEdit = bookToEdit.getOrder(orderKey);
            editEntry(orderToEdit);
        } else if (fileExists(fileName)) {
            //TODO: populate an orderbook from file
            orderToEdit = null;
            editEntry(orderToEdit);
        } else {
            cio.write("No file exists for that date");
        }
    } //editOrder

    static private void editEntry(Order ord) {
        String name, state, product, area;

        //Name Entry
        name = cio.readString("Enter customer name (" + ord.getCustomerName() + "):");
        if (name.equals("")) {
            // continue on no entry to next step
        } else {
            ord.setCustomerName(name);
        }

        //State Entry
        state = cio.readString("Enter State (" + ord.getState() + "):");
        if (state.equals("")) {
            // continue on no entry to next step
        } else {
            ord.setState(state);
        }

        //productEntry
        boolean bool;
        do {
            product = cio.readString("Enter product.  Available options:\n " + listProducts() + "(Current product:" + ord.getProductType() + "):");
            if (product.equals("")) {
                // continue on no entry to next step
                bool = false;
            } else if (verifyProductEntry(product)) {
                ord.setProductType(product);
                bool = false;
            } else {
                bool = true;
            }
        } while (bool);

        //Area entry
        area = cio.readString("Enter area (" + ord.getArea() + "):");
        if (area.equals("")) {
            // continue on no entry to next step
        } else {
            ord.setArea(Double.parseDouble(area));//TODO verify numeric entry
        }
    }

    static private void remOrder() {
        String dateEntered, orderNum;
        String keyDate;
        OrderBook bookToRemoveFrom;

        //TODO: Is this supposed to repeat until valid entry, or return ro main
        //menu on invalid entry??
        do { //while(true)
            dateEntered = cio.readString("Please enter a date (format: MMDDYYYY: ");
            orderNum = cio.readString("Please enter an order number: ");
            //TODO: Test for an empty orderbook, display message to indicate if empty and break loop
            //TODO: Allow user to break this loop if they change their mind
            keyDate = dateEntered + orderNum;
            String fileName = "orders_" + dateEntered + ".txt";

            if (allDates.containsKey(dateEntered)) {
                bookToRemoveFrom = allDates.get(dateEntered);
                cio.write(bookToRemoveFrom.displaySingleOrder(keyDate));
                int choice = cio.readInteger("Delete this order? 1 = yes, 2 = no: ", 1, 2);
                if (choice == 1) {
                    bookToRemoveFrom.removeOrder(keyDate);
                    break;
                } else if (choice == 2) {
                    cio.write("Delete operation cancelled. \n");
                    break;
                }
            } else if (fileExists(fileName)) {
                //Populate bookToRemoveFrom from file, put in allDates, remove Order

                /*try {popByDate(fio.readFile(fileName), dateEntered);}
                 catch (FileNotFoundException e) {
                 cio.write("File not found: " + e.getMessage() + "\n\n");
                 }        */
                break;
            } else {
                cio.write("There are no orders with that number & date\n");
                break;
            }
        } while (true);

    }

    static private void populateOrderBook(ArrayList<String[]> file, String date) {
        OrderBook bookToPopulate = new OrderBook();
        Order ord[] = new Order[file.size()]; //Temp. array to hold data from file
        String keyDate;

        for (int i = 0; i < file.size(); i++) {
            //dimensions index array to hold the number of entries in file at line i
            String index[] = new String[file.get(i).length];
            //Copies entries in file to array index[], line by line
            for (int j = 0; j < file.get(i).length; j++) {
                index[j] = file.get(i)[j];
            }

        //copies values from index arrays to new Orders    
            //od values at [i] = orderNumber, date, customerName, state, productType, area, taxRate, costPerSqFt, laborCostPerSqFt);
            ord[i] = new Order(Integer.parseInt(index[0]), date, index[1], index[2], index[4], Double.parseDouble(index[5]),
                    Double.parseDouble(index[3]), Double.parseDouble(index[6]), Double.parseDouble(index[7]));
            keyDate = date + file.get(i)[0]; //get(i)[0] == order number
            bookToPopulate.addOrder(keyDate, ord[i]);
        }
        allDates.put(date, bookToPopulate);
    }

    static private void initialize() {
        String config;
        config = fio.readConfig("config.txt");
        System.out.println(config);
        //this sets a hashmap for product reference from product.txt
        try {
            ArrayList<String[]> file;
            file = fio.readFile("product.txt");
            String key;
            double[][] index = new double[file.size()][file.get(0).length];
            for (int i = 0; i < file.size(); i++) {
                for (int j = 1; j < file.get(i).length; j++) {
                    index[i][j] = Double.parseDouble(file.get(i)[j]);
                }
                key = file.get(i)[0];
                productFile.put(key, index[i]);
            }
        } catch (FileNotFoundException e) {
            cio.write("File not found: " + e.getMessage() + "\n\n");
        }

        //this sets a reference hashmap from tax.txt
        try {
            ArrayList<String[]> file;
            file = fio.readFile("tax.txt");
            String key;
            double value;
            for (int i = 0; i < file.size(); i++) {
                key = file.get(i)[0];
                value = Double.parseDouble(file.get(i)[1]);
                taxFile.put(key, value);
            }
        } catch (FileNotFoundException e) {
            cio.write("File not found: " + e.getMessage() + "\n\n");
        }

        //Generates and sets the current date.
        //OrderBook todaysBook;// = new OrderBook();
        Date today = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("MMddyyyy");
        dateToday = formatter.format(today);
        allDates.put(dateToday, todaysBook);

        String fileName = "orders_" + dateToday + ".txt";
        //File fileToCheck = new File(fileName);
        //todaysDate.setDate(dateToday);

        //loads today's file if it exists, populates the today's orderBook, then 
        //grabs today's highest orderNumber from and sets a static orderNum
        //in OrderBook to highest (this is to ensure a unique hashcode for every order --
        //An order's hashcode is concat date + ordernum.
        if (fileExists(dateToday)) {

            try {
                ArrayList<String[]> file;
                Order copy;

                file = fio.readFile(fileName);
                populateOrderBook(file, dateToday);
                todaysBook = allDates.get(dateToday);
                int high = 0;

                for (int i = 1; i < todaysBook.size() + 1; i++) {
                    copy = todaysBook.getOrder("" + dateToday + i);

                    if (copy.getOrderNumber() > high) {
                        high = copy.getOrderNumber();
                    }
                    todaysBook.setOrderNum(high);
                    allDates.put(dateToday, todaysBook);
                }
            } catch (FileNotFoundException e) {
                cio.write("File not found: " + e.getMessage() + "\n\n");
            }

        }
    }

    static private String listProducts() {
        String list = "";
        for (String key : productFile.keySet()) {
            list += key + "\n";
        }

        return list;
    }

    static private boolean verifyProductEntry(String product) {
        for (String key : productFile.keySet()) {
            if (key.equals(product)) {
                return true;
            }
        }
        return false;
    }

    static private boolean verifyStateEntry(String state) {
        for (String key : taxFile.keySet()) {
            if (key.equals(state)) {
                return true;
            }
        }
        return false;
    }

    static boolean fileExists(String date) {
        String fileName = "orders_" + date + ".txt";
        File fileToCheck = new File(fileName);
        return fileToCheck.exists();
    }
    
  
    
    static void saveFile() {
        ////////////////////////////////////////////toggles production/test mode
        String config;
        config = fio.readConfig("config.txt");
        if("production".equals(config)){
       ////////////////////////////////////////////////////     
        HashMap<String, ArrayList<String[]>> hashy = new HashMap<>();
        ArrayList<String []> [] al = new ArrayList[allDates.size()];
        OrderBook [] ob = new OrderBook[allDates.size()];
        String [] obKey = new String[allDates.size()];
        String toSend; 
        int i = 0;
        for(String k : allDates.keySet()) {
                obKey[i] = k;
                ob[i] = allDates.get(k);
                al[i] = new ArrayList<>();
                for(String l : ob[i].getOrders())
                //Order temp = ob[i].getOrder(obKey[i]);
                //String[] temp2 = temp.toString().split("::");
                    al[i].add(ob[i].getOrder(l).toString().split("::")); //break  into a few lines
                i++;
        }
        for (int j = 0; j < allDates.size(); j++)
            hashy.put("orders_" + obKey[j] + ".txt", al[j]);
        fio.writeToFile(hashy);
    
    }
            
    }
    static void quitOrders(){
        saveFile();
        System.exit(0);
    }
}
        
        
//        
//        Set<String> keys = allDates.keySet();
//        HashMap<String, ArrayList<String []>> toSend = new HashMap<>();
//        OrderBook ob = new OrderBook();
//        String keyDate = "";
//        String [] line = new String[keys.size()];
//        String fileName = "";
//        Collection<Order> co;
//        
//        for (String k : allDates.keySet())  { //for each date
//            fileName = "orders_" + k + ".txt";
//            ob.getOrders();
//            co = allDates.get(k).getOrders();
//            for (Order o : co) {}
//            for (int j = 0; j < allDates.get(k).size(); j++) { //for each line in a date
//                line[j] = allDates.get(k).toString();
//                
//            }
//        }

 //public static void main(String[] args) {
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
//package DTO;
////@authors Dessa and Anthony
//
//import static DTO.Controller.cio;
//import operations.OrderBook;
//
//
//public class ControllerRedux {
//     public static void main(String[] args) {
//
//        int numOptions;
//        int choice;
//
//        cio.write("Flooring Program\n\n");
//        initialize();
//        do {
//            numOptions = cio.makeMenu("Display Orders", "Add an order", "Edit an order", "Remove an order", "Save current work", "Quit");
//
//            cio.write("\n");
//            choice = cio.readInteger("> ", 1, numOptions);
//
//            switch (choice) {
//                case 1:
//                    showOrder();
//                    break;
//                case 2:
//                    newOrder();
//                    break;
//                case 3:
//                    editOrder();
//                    break;
//                case 4:
//                    remOrder();
//                    break;
//                case 5: //save order
//                    break;
//                case 6: //quit
//                    break;
//            }
//
//        } while (choice != numOptions);
//
//    } //main
//     static private void newOrder() {
//        String name, state, product, dateKey;
//        double area, costPerSqFt, laborCostPerSqFt, taxRate;
//        
//        name = cio.readString("Please enter the customer's last name. >");
//        
//        do {
//            state = cio.readStringToCaps("Please enter a state. >");
//        } while (!verifyStateEntry(state));
//        
//        do {
//            product = cio.readStringToSentenceCase("Please enter a product type. Available options:\n" + listProducts()); //TODO: Product menu
//        } while (!verifyProductEntry(product));
//        
//        taxRate = taxFile.get(state);
//        area = cio.readDouble("How large of an area are you covering with " + product + " ?");
//        costPerSqFt = productFile.get(product)[0];
//        laborCostPerSqFt = productFile.get(product)[1];
///////////////////////////////////////
//        todaysDate.addOrder(name, state, product, area, taxRate, costPerSqFt, laborCostPerSqFt);
//        OrderBook temp;
//        temp = allDates.get(date);
//        
//    }
//}
//

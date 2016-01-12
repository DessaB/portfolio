 // @author Dessa && Anthony

package operations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;


public class OrderBook {
    //HashMap<String, Order> book;
    HashMap<String, Order> ob; //Working HashMap for date subsets.
    
    static String date = "01012000";  //Dummy date.  TODO: assign date from system date.
    static int orderNum = 0; //For use in hashcode which is current MMddyyyy + ordernumber (concat, don't add) 
   
    
    public OrderBook() {
        //book = new HashMap<>();
        ob = new HashMap<>();
    }
    
    public String displayOrdersByDate(String date) {  
        Set<String> keys = ob.keySet();
        String allOrders = "";
        
        for (String k : keys) {
            allOrders += ob.get(k).toString() + "\n";
        }
        return allOrders;
    }
    
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
    
    public void setDate (String date) {
        this.date = date;
    }
    
    public Order getOrder(String key){
        return ob.get(key);        
    }
    
    public Set<String> getOrders() {
        
        return ob.keySet();
    }
    
    public void addOrder(String name, String state, String product, double area, double taxRate, double costPerSqFt, double laborCostPerSqFt) {
        orderNum++; 
        String hashKey = date + orderNum;
        
        Order o = new Order(orderNum, date, name, state, product, area, taxRate, costPerSqFt, laborCostPerSqFt);
        ob.put(hashKey, o);
        
    }
    
    public void addOrder (String key, Order ord) {
       ob.put(key, ord);
    }
    
    public HashMap getBook() {
        return ob;
    }
    
    public Order editOrder(String key) {
        return null;
    }
    
    public void removeOrder(String key) {
            ob.remove(key);
           
    }
    
    public void clearAllOrders() {
        ob.clear();
    }
    
    public boolean exists(String key) {
        return ob.containsKey(key);
    }
    
    public String displaySingleOrder(String key){
        // Set<String> keys = book.keySet();
         return ob.get(key).toString() + "\n";
    }
    
    public int size() {
        return ob.size();
    }
    
    @Override
    public String toString() {
        Set<String> keys = ob.keySet();
        String line = "";
        for (int i = 0; i < ob.size(); i++) {
            for (String k : keys) {
                line += ob.get(k).toString() + "\n";
            }
        }
        return line;
    }
    
   
}   

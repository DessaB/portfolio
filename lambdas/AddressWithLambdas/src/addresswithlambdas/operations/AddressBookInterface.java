/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addresswithlambdas.operations;

import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public interface AddressBookInterface {
    
    public abstract void add(Address address);
    
    public abstract void remove(Address b);
    
    public abstract Address find(String lName);
    
    public abstract ArrayList<Address> getAll();

    public abstract int count();
    
    public abstract ArrayList<Address> findWithCity(String city);
    
    public abstract ArrayList<Address> findWithZip(String zip);
    
    public abstract ArrayList<Address> findWithLast(String stc);
    
    public abstract ArrayList<Address> findWithState(String state);
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addresswithlambdas.operations;

import static addresswithlambdas.dto.Controller.addressArray;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class AddressBook implements AddressBookInterface {

    private final ArrayList<Address> addressBook;

    public AddressBook(ArrayList<Address> addressBook) {
        this.addressBook = addressBook;

    }

    @Override
    public void add(Address address) {
        addressBook.add(address);

    }

    @Override
    public void remove(Address b) {
        addressBook.remove(b);
    }

    @Override
    public Address find(String lName) {
        for (Address a : addressBook) {
            if (a.getlName().compareTo(lName) == 0) {
                return a;
            }

        }
        System.out.println("No name matched.");
        // Need to address error handling
        return null;
    }

    @Override
    public ArrayList<Address> getAll() {
        ArrayList<Address> returnAddress = new ArrayList<>();
        returnAddress.addAll(addressBook);
        return returnAddress;
    }

    @Override
    public int count() {
        return addressBook.size();
    }

    @Override
    public ArrayList<Address> findWithCity(String city) {
        ArrayList<Address> tempArray = new ArrayList<>();
        tempArray = (ArrayList<Address>) addressArray
                .stream()
                .filter(s -> s.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
        return tempArray;
    }

    @Override
    public ArrayList<Address> findWithZip(String zip) {
        ArrayList<Address> tempArray = new ArrayList<>();
        tempArray = (ArrayList<Address>) addressArray
                .stream()
                .filter(s -> s.getZip().equalsIgnoreCase(zip))
                .collect(Collectors.toList());
        return tempArray;
    }

    @Override
    public ArrayList<Address> findWithLast(String stc) {
        ArrayList<Address> tempArray = new ArrayList<>();
        tempArray = (ArrayList<Address>) addressArray
                .stream()
                .filter(s -> s.getlName().equalsIgnoreCase(stc))
                .collect(Collectors.toList());
        return tempArray;
    }

    @Override
    public ArrayList<Address> findWithState(String state) {
        ArrayList<Address> stateList = (ArrayList<Address>) addressArray
                .stream()
                .filter(s -> s.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());

        // String compare="";
        boolean find = false;
        ArrayList<Address> tempArray = new ArrayList<>();
        ArrayList<String> cityString = new ArrayList();
        for (Address k1 : stateList) {
            if (cityString.size() == 0) {
                cityString.add(k1.getCity());

            } else {
                for (int i = 0; i < cityString.size(); i++) {
                    if (!k1.getCity().equalsIgnoreCase(cityString.get(i))) {
                        find = true;

                    } else {
                        find = false;
                    }
                }
                if (find == true) {
                    cityString.add(k1.getCity());
                }
            }
        }
        for (String k : cityString) {
            ArrayList<Address> insideArray = new ArrayList<>();
            insideArray = (ArrayList<Address>) stateList
                    .stream()
                    .filter(s -> s.getCity().equalsIgnoreCase(k))
                    .collect(Collectors.toList());
            for (Address a : insideArray) {
                tempArray.add(a);
            }

        }
        return tempArray;
    }
}

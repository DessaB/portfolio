/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlambdas.operations;

import static dvdlambdas.dto.DVDController.c;
import static dvdlambdas.dto.DVDController.dvdArray;
import static dvdlambdas.dto.DVDController.newLib;
import static dvdlambdas.dto.DVDController.printDVD;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DVDLibrary implements DVDLibraryInterface {

    private ArrayList<DVD> library;

    public DVDLibrary(ArrayList library) {
        this.library = library;
    }

    @Override
    public void add(DVD a) {
        library.add(a);
    }

    @Override
    public void remove(DVD a) {
        library.remove(a);
    }

    @Override
    public DVD find(String a) {
        for (DVD d : library) {
            if (d.getTitle().equalsIgnoreCase(a)) {
                return d;
            }
        }
        return null;
    }

    @Override
    public int findTitleNum(String a) {
        int count = 0;
        for (DVD d : library) {
            if (d.getTitle().equalsIgnoreCase(a)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public ArrayList<DVD> getAll() {
        ArrayList<DVD> newList = new ArrayList<>();
        newList.addAll(library);
        return newList;
    }
    
    @Override
    public  void findByYear(){
        dvdArray = newLib.getAll();
        int year = c.readInteger("Please enter the year you want to search back to: ");
        dvdArray
                .stream()
                .filter(s -> Integer.parseInt(s.getYear())> year)
                .forEach(s -> System.out.println(s.toString() + "\n"));
        
    }
    
    @Override
    public  void findByMpaa(){
        dvdArray = newLib.getAll();
        String mpaa = c.readString("Please enter the MPAA rating you want to search for: ");
        dvdArray
                .stream()
                .filter(s -> s.getMpaa().equalsIgnoreCase(mpaa))
                .forEach(s-> printDVD(s));
    }
    
    @Override
    public  void findByDirector(){
        dvdArray = newLib.getAll();
        String dir = c.readString("Please enter the director you want to search for: ");
        ArrayList<DVD> dirList = (ArrayList<DVD>)dvdArray
                .stream()
                .filter(s-> s.getDirName().equalsIgnoreCase(dir))
                .collect(Collectors.toList());
        Set<String> setList = new HashSet<>();
        for (DVD k: dirList){
            setList.add(k.getMpaa());
        }
        
        for (String k1 : setList){
            System.out.println("MPAA: " + k1.toUpperCase() + "\n");
            dirList
                    .stream()
                    .filter(s->s.getMpaa().equalsIgnoreCase(k1))
                    .forEach(s-> System.out.println(s.toString() +"\n"));
                  
        }
        
    }
    
    @Override
    public  void findByStudio(){
        dvdArray = newLib.getAll();
        String studio = c.readString("Please enter the studio you want to search for: ");
        dvdArray
                .stream()
                .filter(s-> s.getStudio().equalsIgnoreCase(studio))
                .forEach(s->System.out.println(s.toString() + "\n"));
    }
    
    @Override
    public  void averageAge(){
        LocalDate today = LocalDate.now();
        double time = today.getYear();
        
        double average = dvdArray
                .stream()
                .mapToDouble(s->time - Double.parseDouble(s.getYear()))
                .average()
                .getAsDouble();
        
        System.out.format("The average year of all your movies is:  %.2f \n", average);
        
    }
    
    @Override
    public  void newestMovie(){
      double newestDVD =  dvdArray
                .stream()
                .mapToDouble(s-> Double.parseDouble(s.getYear()))
                .max()
                .getAsDouble();
      
      dvdArray
              .stream()
              .filter(s->Double.parseDouble(s.getYear())==newestDVD)
              .forEach(s-> System.out.println(s.toString() + "\n"));
                
    }
    
    @Override
    public  void oldestMovie(){
      double oldestDVD =  dvdArray
                .stream()
                .mapToDouble(s-> Double.parseDouble(s.getYear()))
                .min()
                .getAsDouble();
      
      dvdArray
              .stream()
              .filter(s->Double.parseDouble(s.getYear())==oldestDVD)
              .forEach(s-> System.out.println(s.toString() + "\n"));
                
    }
}




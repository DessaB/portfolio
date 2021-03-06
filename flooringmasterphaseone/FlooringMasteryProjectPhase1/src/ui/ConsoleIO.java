/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIO {
    Scanner kb = new Scanner(System.in);
    public int readInteger(String p) {
        boolean failed;
        int ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextInt();
                kb.nextLine();
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be an integer."); 
               failed = true;
               kb.nextLine();
            }
        }while (failed);
        return ret;
    }
    
    public int readInteger(String p, int min, int max) {
        boolean failed;
        int ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextInt();
                kb.nextLine();
                if(ret < min || ret > max) {
                    System.out.println("Value must be between " + min 
                            + " and " + max + ".");
                }
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be an integer."); 
               failed = true;
               kb.nextLine();
            }
        }while (failed || ret < min || ret > max);
        
        return ret;

    }
    
    public String readString(String p) {
        System.out.print(p);
        return kb.nextLine();
    }
    
    public String readStringToCaps(String p) {
        System.out.print(p);
        String str = kb.nextLine();
        str = str.toUpperCase();
        return str;
    }
    
    public String readStringToSentenceCase (String p) {
        System.out.print(p);
        String str = kb.nextLine();
        str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        return str;
        
    }
    
    public float readFloat(String p) {
        boolean failed;
        float ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextFloat();
                kb.nextLine();
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be a number."); 
               failed = true;
               kb.nextLine();
            }
        }while (failed);
        return ret;
    }  
    
    public float readFloat(String p, float min, float max) {
        boolean failed;
        float ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextFloat();
                kb.nextLine();
                if(ret < min || ret > max) {
                    System.out.println("Value must be between " + min 
                            + " and " + max + ".");
                }
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be a number."); 
               failed = true;
               kb.nextLine();
            }
        }while (failed || ret < min || ret > max);
        
        return ret;
    }
    
    public double readDouble(String p) {
        boolean failed;
        double ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextDouble();
                kb.nextLine();
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be a number."); 
               failed = true;
               kb.nextLine();
            }
        }while (failed);
        return ret;
    }
    
    public double readDouble(String p, double min, double max) {
        boolean failed;
        double ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextDouble();
                kb.nextLine();
                if(ret < min || ret > max) {
                    System.out.println("Value must be between " + min 
                            + " and " + max + ".");
                }
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be a number."); 
               failed = true;
               kb.nextLine();
            }
        }while (failed || ret < min || ret > max);
        
        return ret;
    }
    
    public void write(String p) {
        System.out.print(p);
    }
    
     public int makeMenu(String... options) {
        for(int i = 0; i < options.length; i++)
            System.out.print((i + 1) + ". " + options[i] + "\n");
            
        return options.length;
    }

}
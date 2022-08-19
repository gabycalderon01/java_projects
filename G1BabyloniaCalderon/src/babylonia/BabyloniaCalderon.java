/** CPS201
 * Spring 2021
 * Gabriela Calderon
 * 
 * Copyright 2021 Gabriela Calderon
 */

package babylonia;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * File name:     BabyloniaCalderon.java
 * <p>
 * Description:   Program that estimates the square root of several inputs
 *                given by the user. Solves programming project 1, Walter
 *                Savitch, <i>Absolute Java, 6th ed.</i>, Chapter 3, page 168.  
 * <p>
 * @author Gabriela Calderon gcaldero@heidelberg.edu
 * @version 25-Jan-2021
 */
public class BabyloniaCalderon
{
    public static double obtainValidRadicand()
    {
        Scanner keyboard = new Scanner(System.in);
        String radicandString = "";
        
        System.out.print("Enter the radicand: ");
        radicandString = keyboard.nextLine();
        while (!isValidNumber(radicandString,"")
            || radicandString.contains("-"))
        {
            System.out.print("Enter the radicand: ");
            radicandString = keyboard.nextLine();
        }
        return Double.parseDouble(radicandString);
    } // end public static double obtainValidRadicand
    
    public static double estimateSquareRoot(double radicand)
    {
        int guessCounter = 1;
        double oldEstimate = radicand;
        double newEstimate = radicand / 2;
        // loop
        while (((oldEstimate - newEstimate) / oldEstimate) > 0.001)
        {
            oldEstimate = newEstimate;
            newEstimate = (oldEstimate + (radicand / oldEstimate)) / 2;
            System.out.print(String.format("Guess %d = %,-7.4f \n", guessCounter, newEstimate));
            guessCounter += 1;         
        }
        return newEstimate;        
    }           
    
    public static boolean isValidNumber(String numberString, String type)
    {
        String regex;
        
        if (type.equalsIgnoreCase("natural"))
            regex = "[0-9]+";               //Match unsigned ints only
        else
            regex = "^[-+]?"                //Match opt. sign in the set
                    + "[0-9]"               //Match digits
                    + ".?[0-9]+"            //Match opt. dot and digits
                    + "([eE][-+]?[0-9]+)?$"; //Match scientific
        
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(numberString);
        
        boolean isValid = m.matches();
        
        return isValid;
    }
   
    public static void main(String[] args)
    {
        double radicand = 0.0;
        double squareRoot = 0.0;
        
        // program header
        System.out.println("\n\t\tCOMPUTE A SQUARE ROOT\n\n"
                            + "Gabriela Calderon\n"
                            + "January 25, 2021\n");
        System.out.println("This program estimates square roots using"
                            + " the Babylonian algorithm.\n");
        // prompt users for input
        radicand = obtainValidRadicand();
        if (radicand == 0)
            squareRoot = 0;
        else if (radicand == 1)
            squareRoot = 1;
        else
            squareRoot = estimateSquareRoot(radicand);
        
        //display root
        
        System.out.print(String.format("The estimated square root of %,.2f is %,.4f", radicand, squareRoot));  
        System.out.println();
    }           
}        

      

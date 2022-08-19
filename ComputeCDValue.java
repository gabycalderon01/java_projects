/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 *
 * Copyright © 2021 Daryl Close This work is licensed under the Creative Commons 
 * Attribution-Noncommercial-NoDerivatives 4.0 International Public License. 
 * To view a copy of this license, visit 
 * https://creativecommons.org/licenses/by-nc-nd/4.0/ or send a letter to 
 * Creative Commons, 171 Second Street, Suite 300, San Francisco, California, 
 * 94105, USA. 
 */

package computecdvalue;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * File name:     ComputeCDValue.java
 * <p>
 * Description:   Non-OO program that computes CD values by month based on user 
 *                inputs. Solves Programming Exercise 5.33, Y. Daniel Liang,
                  <i>Introduction to Programming Using Python</i>, pp. 164-165.
 * <p>
 * Illustrates/reviews the following:
 * <ol>
 * <li>basic separation of concerns with division of labor in separate methods.
 *     N. B. the data model and delegate are combined in this "pile of mud"
 *     program.
 * <li>bullet-proofing user input via regex in the input validation loops,
 * <li>while, do-while, and for loops
 * <li>simple table layout using format()
 * <li>optional currency formatting using locale import
 * <li>Javadoc comments
 * </ol>          
 * @author Daryl Close dclose@heidelberg.edu 
 * @version 17-Jan-2021 
 */
public class ComputeCDValue
{ 
    //-------static methods-------
    
    /**
     * Prompts the user to enter the CD deposit amount.  Keyboard entry is
     * fully bullet-proofed to allow only positive integers.
     * <p>
     * @return a valid deposit amount
     */
    public static int obtainValidDepositAmount()
    {
        Scanner keyboard = new Scanner(System.in);
        String depositString = "";
        
        System.out.print("Enter the initial deposit amount (whole number):  ");
        depositString = keyboard.nextLine();
        while (!isValidNumber(depositString, "natural"))
        {
            System.out.print("Enter the initial deposit amount (whole number):  ");
            depositString = keyboard.nextLine();            
        }
        
        return Integer.parseInt(depositString);
        
    }//End public static int obtainValidDepositAmount() 
    
    /**
     * Prompts the user to enter the CD annual percentage yield.  Keyboard 
     * entry is fully bullet-proofed to allow only positive doubles.
     * <p>
     * @return a valid annual percentage yield
     */
    public static double obtainValidAnnualPercentageYield()
    {
        Scanner keyboard = new Scanner(System.in);
        String annualYieldString = "";
        
        System.out.print("Enter annual yield as percent (4.0, etc.):        ");
        annualYieldString = keyboard.nextLine();
        while (!isValidNumber(annualYieldString,"") 
               || annualYieldString.contains("-"))
        {
            System.out.print("Enter annual yield as percent (4.0, etc.):        ");
            annualYieldString = keyboard.nextLine();            
        }
        
        return Double.parseDouble(annualYieldString);
                
    }//End public static double obtainValidAnnualPercentageYield()
    
    /**
     * Prompts the user to enter the number of months in the CD maturity
     * period.  Keyboard entry is fully bullet-proofed to allow only positive 
     * integers.
     * <p>
     * @return the number of months in CD maturity period
     */
    public static int obtainValidNumberOfMonths()
    {
        Scanner keyboard = new Scanner(System.in);
        String monthString = "";
        
        System.out.print("Enter the number of months (whole number > 0):     ");
        monthString = keyboard.nextLine();
        while (!isValidNumber(monthString, "natural"))
        {
            System.out.print("Enter the number of months (whole number > 0):     ");
            monthString = keyboard.nextLine();            
        }
        
        return Integer.parseInt(monthString);
        
    }//End public static double obtainValidNumberOfMonths()
    
   
    /** 
     * Validates a string as a number using regular expression pattern matching.
     * <p>
     * @author Daryl Close dclose@heidelberg.edu
     * @return             true if string is a valid number, false otherwise.
     * @param numberString string to be converted to a number
     * @param type         "natural" invokes check for natural number
     *                     otherwise a real
     */ 
    public static boolean isValidNumber(String numberString, String type)
    {   
        String regex;
        
        if (type.equalsIgnoreCase("natural"))
            regex = "[0-9]+";                //Match unsigned ints only        
        else
            regex = "^[-+]?"                 //Match opt. sign in the set
                    + "[0-9]"                //Match digits 
                    + ".?[0-9]+"             //Match opt. dot and digits
                    + "([eE][-+]?[0-9]+)?$"; //Match scientific   
               
        Pattern p = Pattern.compile(regex);        
        Matcher m = p.matcher(numberString);
        
        boolean isValid = m.matches();
      
        //Convenience form:
        /*
        isValid = Pattern.matches("^[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?$", 
                                  numberString);
        */
        
        return isValid;
       
    }//End public static boolean isValidNumber(String) 
    
    /**
     * Main method to compute and display a table of CD values..
     * <p>
     * Validate user inputs of CD deposit amount, annual percentage rate
     * of return, and number of months to maturity.  Display a table of
     * CD values formatted as U.S. dollars by month for each month of
     * the CD.  Use either the locale module and/or the format function
     * for table layout and currency formatting.
     * <p>
     * @param args String array for command line arguments
     */
    public static void main(String[] args)
    {  
        double currentValue = 0.0;
        int deposit = 0;
        int numberOfMonths = 0;
        double annualPercentageYield = 0.0;
        double monthlyInterestRate = 0.0;
        
        //Set locale for currency formatting        
        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        
        //Display program header
        System.out.println("\n\t\tCOMPUTE CD VALUE\n");
        
        //Prompt user for inputs
        deposit = obtainValidDepositAmount();
        annualPercentageYield = obtainValidAnnualPercentageYield();
        numberOfMonths = (int) obtainValidNumberOfMonths();
        
        //Print table header
        System.out.printf("%s %20s", "\nMonth", "CD Value\n\n");
        
        //Calculate and print table rows
        monthlyInterestRate = annualPercentageYield / 1200;
        currentValue = (double) deposit;        
        for (int i = 1; i < numberOfMonths + 1; i++)
        {
            //Calculate value of CD for this month
            currentValue = currentValue * (1 + monthlyInterestRate);

            //Print table row for current month i
            //System.out.printf("%-15d $%,.2f\n", i, currentValue);
            System.out.print(String.format("%-15d $%,.2f\n", i, currentValue));
           // System.out.println(moneyFormatter.format(currentValue));
        }
        
        System.out.println();
            
    }//End public static void main(String[])
    
}//End class ComputeCDValue
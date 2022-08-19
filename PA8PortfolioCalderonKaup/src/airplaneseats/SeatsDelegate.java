package airplaneseats;

import java.util.Scanner;        
        
/*
 * CPS 202
 * Spring 2021
 * Gabriela Calderon and Spencer Kaup
 * 
 * Copyright © 2021 
 */

/**
 * File name:   SeatsDelegate.java
 * <p>
 * Description: Console-based Delegate (View/Controller) class for the airplane 
 *              seat assignments problem.
 * <p>
 *              This class is designed to support the Model-Delegate pattern.
 * @author Gabriela Calderon and Spencer Kaup
 * @version 12-Feb-2021
 */
public class SeatsDelegate
{
    //-------instance fields------- 
    
    private String seatSelection;
    SeatsModel seatsTable = new SeatsModel();
   
    //-------constructors-------  
    
    /**
     * No-arg constructor
     */
    public SeatsDelegate()
    {
        seatsTable = new SeatsModel();
        seatSelection = "";
        displayHeader();
        assignSeats();
       
    }//End no-arg SeatsDelegate() constructor
    
    /*
    This constructor is used to import getSeatsLeft() form the SeatsModel
    class.
    */
    public void getSeatsLeft()
    {
        SeatsModel seatsLeft = new SeatsModel();
        int seatsRemaining = seatsLeft.getSeatsLeft();
    } //End of getSeatsLeft() constructor
    
    /*
    This is the assignSeats() method. It is used to receive the input from
    the user to choose a seat and to say if they wish to continue or not. It
    also tells the user if there are seats remaining or if they're all
    assigned.
    */
    public void assignSeats()
    {
        Scanner keyboard = new Scanner(System.in);
        String runAgain = "Y";
        
        //loop to assign multiple seats
        while (seatsTable.getSeatsLeft() > 0 && runAgain.equalsIgnoreCase("Y"))
        {
            // loop to assign one seatLetter
            do
            {
                // loop to get a valid seatLetter number
                do
                {
                    System.out.print("\nChoose a seat: ");
                    seatSelection = keyboard.nextLine();                    
                }
                while (seatSelection.length() != 2 || !isValidSeat(seatSelection));
                
                //ask model to assign seatLetter
                if (requestSeatAssignment(seatSelection.toUpperCase()))
                {
                    System.out.println("\nSeat " + seatSelection.toUpperCase()
                            + " is now assigned.");
                    System.out.println("Seats remaining = " + seatsTable.getSeatsLeft());
                }                
                else if(seatsTable.getSeatsLeft() == 0)
                    System.out.println("No seats remaining.");
                else
                    System.out.println("Seat is already assigned.");
                    
                displaySeats();
                    
                //Loops to ask user to assign another seatLetter
                if (seatsTable.getSeatsLeft() > 0)
                    do
                    {
                        System.out.print("\nAssign another seat (Y/N): ");
                        runAgain = keyboard.nextLine();                        
                    }
                    while (!runAgain.equalsIgnoreCase("Y") && !runAgain.equalsIgnoreCase("N"));           
            }
            while (runAgain.equalsIgnoreCase("Y") && seatsTable.getSeatsLeft() > 0);
    
        } //end main while loop
        
        if (seatsTable.getSeatsLeft() == 0)
            System.out.println("All seats assigned.");
                           
        displaySeats();
                
    } //end public void assignSeats() method
                     
    
    //-------instance methods-------  
    
    public boolean requestSeatAssignment(String seatSelection)
    {
        return seatsTable.validateSeatRequest(seatSelection);
    } // End of requestSeatAssignment() method
    
    /*
    This method is used to display the header of the code, showing the title,
    name of authors, date, and short description of the code.
    */
    public void displayHeader()
    {
        System.out.println("\n\t\tTEST OF AIRPLANE SEAT ASSIGNMENTS\n\n"
                + "Gabriela Calderon and Spencer Kaup\n"
                + "12-Feb-2021\n\n");
        System.out.println("You will be selecting seats for this airplane "
                + "floor plan:\n");
        
        displaySeats();
        
        System.out.println("You will input the seat selection with the row\n"
                + "number followed by the seat letter (ex. 3B)");
        
    } //End of displayHeader() method
    
    /*
    This method is used to actually print the seatsTable, showing the full
    outline of the plane to the user.
    */
    public void displaySeats()
    {
        System.out.println(seatsTable.toString());
        
    }   //End of displaySeats() method
    
    /*
    This method is used to validate whether or not the seat chosen is valid.
    */
    private boolean isValidSeat (String selection)
    {
        String row = selection.substring(0,1); //charAt (0)
        String seatLetter = String.valueOf(selection.charAt(1)).toUpperCase();
        
        boolean validRow = false;
        boolean validSeat = false;
        boolean isValid = false;
        
        //Check for valid row number      
        for (int i = 1; i < seatsTable.getNumberOfSeatRows() + 1; i++)
            if (row.equals(String.valueOf(i)))
                //String.valueof returns string representation of int argument.
                validRow = true;
            
        //Check for valid seatLetter letter
        if (seatLetter.equalsIgnoreCase("A") || seatLetter.equalsIgnoreCase("B")
                || seatLetter.equalsIgnoreCase("C") || seatLetter.equalsIgnoreCase("D"))
            validSeat = true;
   
        return validRow && validSeat;
        
    }   //End of private boolean isValidSeat(String selection)         
    
} //End public class SeatsDelegate
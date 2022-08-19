/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplaneseats;
/**
 *
 * @author Gabriela Calderon and Spencer Kaup
 */
public class SeatsModel 
{

    //-------static fields-------
    private static final int NUMBER_OF_TABLE_ROWS = 1;
    private static final int NUMBER_OF_TABLE_COLUMNS = 5;
    private static final int TOTAL_SEATS = NUMBER_OF_TABLE_ROWS
                                        * (NUMBER_OF_TABLE_COLUMNS - 1);

    //-------instance fields--------
    private String[][] seatsTable;
    private int seatsLeft;   
    
    //-------constructors-----------
    
    /*
    This constructor is used to build a 2D array used as a table to show the
    outline of the airplane.
    */
    public SeatsModel()
    {
        
    
        seatsTable = new String[NUMBER_OF_TABLE_ROWS][NUMBER_OF_TABLE_COLUMNS];
        seatsLeft = TOTAL_SEATS;
        
        //Populate seatsTable column of airplane row numbers
        for (int i = 0; i < NUMBER_OF_TABLE_ROWS; i++)
            seatsTable[i][0] = String.valueOf(i + 1);
        
        //pupulate seatsTable rows with seat letters
        for (int i = 0; i < seatsTable.length; i++)
        {
            for (int j = 1; j < seatsTable[0].length; j++)
            {
                if (j == 1)
                    seatsTable[i][j] = "A";
                if (j == 2)
                    seatsTable[i][j] = "B";
                if (j == 3)
                    seatsTable[i][j] = "C";
                if (j == 4)
                    seatsTable[i][j] = "D";               
            }
        }    
    } // End of no-arg SeatsModel() constructor
    
    //---------Getters------------------
    public int getSeatsLeft()
    {
        return seatsLeft;
    }
    
    public int getNumberOfSeatRows()
    {
        return NUMBER_OF_TABLE_ROWS;
    }            
    
    public int getSeatsPerRow()
    {
        return NUMBER_OF_TABLE_COLUMNS - 1;
    }
    
    public String[][] getSeatsTable()
    {
        return seatsTable.clone();
    }
    //------------End of Getters----------------
  
    /*
    This method is used to represent the seatsTable as a string in the other
    classes.
    */
    @Override
    public String toString()
    {
        String seatDisplay = "";
        
        for (int i = 0; i < seatsTable.length; i++)
        {
            for (int j = 0; j < seatsTable[0].length; j++)
                if ((j > 0 && j < 2) || (j > 2))
                    seatDisplay += seatsTable[i][j];
                else if (j == 2)
                    seatDisplay += seatsTable[i][j] + " ";
                else
                    seatDisplay += seatsTable[i][j] + " ";
            
            seatDisplay += "\n";
        }
        return seatDisplay;
        
        
    }//End of public string toString()
        
    
    /**
     * 
     * @param request
     * @return 
     */
    public boolean validateSeatRequest(String request)
    {
        int row = Integer.parseInt(request.substring(0,1)) - 1;
        
        int column;
        String temp = request.substring(1,2).toUpperCase();
        if(temp.equals("A"))
        {
            column = 1;
        }
        else if(temp.equals("B"))
        {
            column = 2;
        }
        else if(temp.equals("C"))
        {
            column = 3; 
        }
        else
        {
            column = 4; 
        }
        
        if(seatsTable[row][column].equals("X"))
        {
            return false;
        }
        else
        {
            seatsTable[row][column] = "X";
            seatsLeft--;
            return true;
        }
    } //End of validateSeatRequest method

}//End public class SeatsModel  

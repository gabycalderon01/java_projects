/*
 * CPS 202
 * Gabriela Calderon
 * April 7, 2021
 */
package PA7TicTacToe;

/**
 * File name:   TicTacToeModel.java
 * Description: The model must represent the board as a 2D array of String.
 * @author      Gabriela Calderon
 * @revision    April 7, 2021
 */

public class TicTacToeModel 
{    
    //------------CONSTANT FIELDS------------
    public static final int size = 4;
    
    //------------INSTANCE FIELDS-------------
    public String[][] boardArray;   
    
    //-----------------CONSTRUCTORS----------------
    
    //No-arg constructor
    TicTacToeModel()
    {        
        boardArray = new String [][] { {"", "", "", ""} , {"", "", "", ""},
                                    {"", "", "", ""}, {"", "", "", ""} };        
    } //End of no-arg constructor
    
    //--------------METHODS---------------        
    
    /**
     * Changes the value of a specific cell.
     * @param row
     * @param column
     * @param value 
     */
    public void setCell(int row, int column, String value)
    {
        for (int r = 0; r < size; r++)
        {    
            for (int c = 0; c < size; c++)
            {                
                if ((r == row) && (c == column))
                    boardArray[r][c] = value;
            }
        }
    } //End of setCell method
      
    /**
     * Method that checks if a player won by checking if a winner was found
     * horizontally, vertically, or diagonally.
     * @return      Winner string (X or O) or null if no winner was found.
     */
    public String getWin()
    {           
        if (winHorizontal() != null)
        {
            return winHorizontal();
        }        
        else if (winVertical() != null)
        {
            return winVertical();
        }
        else if (winDiagonal() != null)
        {
            return winDiagonal();
        }
        return null;
                    
    } //End of getWin method        
    
    /**
     * Parent method that loops child method through the array's rows to 
     * find a winner.
     * @return      Winner string (X or O) if a winner is found, or null if not.
     */
    public String winHorizontal()
    {
        String winnerCharacter = null;
        
        for (int r = 0; r < size; r++){
            
            // Evaluate a winner horizontally
            winnerCharacter = winHorizontal(r);
            
            if(winnerCharacter != null){
                return winnerCharacter;
            }
        }        
        return null;                
    } //End of winHorizontal parent method
    
    /**
     * Child method (overloaded) that takes the row index sent by the parent 
     * method and uses it to find a winner through all the columns. It does so 
     * by keeping a count of all Xs and Os found in the same row.
     * @param rowIndex  Row index sent by the parent.
     * @return          Winner string (X or O) if a winner is found, null if not.
     */
    public String winHorizontal(int rowIndex)
    {
        int counterO = 0;
        int counterX = 0;
    
        // Go through all columns and count which character is found
        for (int j = 0; j < size; j++)
        {
            if (boardArray[rowIndex][j].equals("O"))
            {
                counterO++;                
            }
            if(boardArray[rowIndex][j].equals("X"))
            {
                counterX++;                    
            }        
        }        
        
// Based on the values on each counter, return the corrresponding winner, if any
        if(counterO == size)
        {
            return "O";            
        }
        else if( counterX == size ){
            return "X";
        }
        else{
            return null;
        }        
    } //End of winHorizontal child method.

    /**
     * Parent method that loops child method through the array's columns to 
     * find a winner.
     * @return      Winner string (X or O) if a winner is found, null if not.
     */
    public String winVertical()
    {
        String winnerCharacter = null;
        
        for (int c = 0; c < size; c++){
            
            // Evaluate a winner horizontally
            winnerCharacter = winVertical(c);
            
            if(winnerCharacter != null){
                return winnerCharacter;
            }
        }        
        return null;          
    } //End of winVertical parent method
    
    /**
     * Child method (overloaded) that takes the column index sent by the parent 
     * method and uses it to find a winner through all the rows. It does so by
     * keeping a count of all Xs and Os found in the same column.
     * @param columnIndex   Column index sent by the parent.
     * @return              Winner string (X or O) if a winner is found, null 
     *                      if not.
     */
    public String winVertical(int columnIndex)
    {
        int counterO = 0;
        int counterX = 0;
    
        // Go through all rows and count which character is found
        for (int j = 0; j < size; j++)
        {
            if (boardArray[j][columnIndex].equals("O"))
            {
                counterO++;                
            }
            if(boardArray[j][columnIndex].equals("X"))
            {
                counterX++;                    
            }        
        } 
        
// Based on the values on each counter, return the corrresponding winner, if any
        if(counterO == size)
        {
            return "O";            
        }
        else if( counterX == size ){
            return "X";
        }
        else{
            return null;
        }
    } //End of winVertical child method
    
    /**
     * Method used to find diagonal winners. It does so by looping through the
     * array's length, from left to right (diagonal) and then from right to
     * left (anti-diagonal). It knows if there is a winner because it keeps
     * a count of all the consecutive Xs and Os found in the diagonals.
     * @return      Winner string (X or O) if a winner is found, null if not.
     */
    public String winDiagonal()
    {
        int counterODiagonal = 0;
        int counterXDiagonal = 0;
        int counterOAntiDiagonal = 0;
        int counterXAntiDiagonal = 0;
        
        // Get diagonals from left to right
        for (int i = 0; i < size ; i++)
        {
            if (boardArray[i][i].equals("O"))
            {
                counterODiagonal++;                
            }
            else if(boardArray[i][i].equals("X"))
            {
                counterXDiagonal++;                    
            }
        }
        //Get diagonals from right to left
        for (int i = 0; i < size ; i++)
        {
            if (boardArray[i][size -1 - i].equals("O"))
            {
                counterOAntiDiagonal++;
            }
            else if (boardArray[i][size -1 - i].equals("X"))
            {
                counterXAntiDiagonal++;
            }
        }
        
// Based on the values on each counter, return the corrresponding winner, if any              
        if (counterOAntiDiagonal == size)
        {
            return "O";            
        }
        else if (counterXAntiDiagonal == size)
        {
            return "X";
        }
        else if (counterODiagonal == size)
        {
            return "O";
        }
        else if (counterXDiagonal == size)
        {
            return "X";
        }
        else
        {
            return null;
        }
    } //End of winDiagonal method
    
    /**
     * Method that checks if there are empty spaces left in the array. If there
     * are none, it means the game is over and there is a tie.
     * @return      True if there is a tie and false if there isn't.
     */
    public boolean getTie()
    {
        boolean tie = true;
        for (int r = 0; r < size; r++)
        {
            for (int c = 0; c < size; c++)
            {
                if (boardArray[r][c].equals(""))
                {
                    tie = false;
                }
            }
        }
        return tie;   
    } //End of getTie method
    
} //End of model class
/*
 * CPS 202
 * Spencer Kaup &
 * Ethan Campbell
 * April 6th 2021
 */

package pa7tictactoekaupcampbell;

import java.util.ArrayList;

/**
 * File name:     TicTacToeModel.java 
 * <p>
 * Description: Model class for the PA7 Tic-Tac-Toe assignment problem. 
 *<p>
 * This class is designed to support the Model View Controller pattern.
 *<p>
 * Finished version.
 *<p>
 * @author Ethan Campbell ecampbe1@heidelberg.edu
 * @author Spencer Kaup skaup@heidelberg.edu
 * @version 6-April-2021 
 */
public class TicTacToeModel {
    
    private ArrayList<String> board;
    private int[][] winStates;
    
    /**
     * No-arg constructor.
     */
    public TicTacToeModel()
    {
        board = new ArrayList<>();

        // This array has the 10 valid win states of tic-tac-toe in index form.
        this.winStates = new int[][]{{0, 1, 2, 3}, 
                                    {4,5,6,7}, {8,9,10,11}, 
                                    {12,13,14,15}, {0,4,8,12}, 
                                    {1,5,9,13}, {2,6,10,14}, 
                                    {3,7,11,15}, {0,5,10,15}, 
                                    {3,6,9,12}};
        
        
        for (int i = 0; i < 16; i++)
        {
            board.add("");
        }
    } //End no-arg constructor
    
    /**
     * Gets the value of a cell.
     * @param index the index of the cell to access.
     * @return the cell's value.
     */
    public String getCell(int index)
    {
        return board.get(index);
    } //end public String getCell
    
    /**
     * Sets the value of a cell.
     * @param index the index of the cell to set.
     * @param value the cell's new value.
     */
    public void setCell(int index, String value)
    {
        board.set(index, value);
    } //end public void setCell
    
    /**
     * Checks if a board is in a win state.
     * @return whether or not a game has been won.
     */
    public boolean checkWin()
    {
        for (int[] state : winStates)
        {
            if (!board.get(state[0]).equals("") &&
                board.get(state[0]).equals(board.get(state[1])) &&
                board.get(state[0]).equals(board.get(state[2])) &&
                board.get(state[0]).equals(board.get(state[3])))

            {
                return true;

            }
        }
        return false;
    } //end public boolean checkWin()
    
    /**
     * Checks if the board is fully populated, and therefore tied.
     * @return whether or not the board is full.
     */
    public boolean checkTie()
    {
        boolean tie = true;
        for (String cell : board) 
        {
            if (cell.equals(""))
            {
                tie = false;
            }
        }
        return tie;
    } //end public boolean checkTie()
    
} //end public class TicTacToeModel()

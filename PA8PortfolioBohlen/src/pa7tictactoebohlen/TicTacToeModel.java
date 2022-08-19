/*
 * CPS 202
 * Will Bohlen
 * 13-Apr-2020
 */
package pa7tictactoebohlen;

import java.util.ArrayList;

/**
 * File name:     TicTacToeModel.java <p>
 * Description:   Programming Project 2, Savitch 6e, Ch. 17, p. 1022.
 *                <p>
 *                This model contains the board data, and checks if a game
 *                is won or tied.
 * 
 * <p>
 * Savitch, Walter. 2016. Absolute Java, 6th Edition. Essex: Pearson Education 
 *    Limited.
 * 
 * @author Will Bohlen wbohlen@heidelberg.edu
 * @revision 13-Apr-2020
 */
public class TicTacToeModel {
    
    ArrayList<String> board = new ArrayList<String>();
    // This array contains the 8 valid win states of tic-tac-toe in index form.
    int[][] winStates = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
        {0, 4, 8}, {2, 4, 6}};
    
    /**
     * No-arg constructor populates the board model.
     */
    public TicTacToeModel()
    {
        for (int i = 0; i < 9; i++)
        {
            board.add("");
        }
    }
    
    /**
     * Gets the value of a cell.
     * @param index the index of the cell to access.
     * @return the cell's value.
     */
    public String getCell(int index)
    {
        return board.get(index);
    }
    
    /**
     * Sets the value of a cell.
     * @param index the index of the cell to set.
     * @param value the cell's new value.
     */
    public void setCell(int index, String value)
    {
        board.set(index, value);
    }
    
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
                board.get(state[0]).equals(board.get(state[2])))
            {
                return true;
            }
        }
        return false;
    }
    
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
    }
}

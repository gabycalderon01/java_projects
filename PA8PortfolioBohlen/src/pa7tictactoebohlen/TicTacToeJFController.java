/*
 * CPS 202
 * Will Bohlen
 * 13-Apr-2020
 */
package pa7tictactoebohlen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * File name:     TicTacToeJFController.java <p>
 * Description:   Programming Project 2, Savitch 6e, Ch. 17, p. 1022.
 *                <p>
 *                This class controls the main game logic.
 * 
 * <p>
 * Savitch, Walter. 2016. Absolute Java, 6th Edition. Essex: Pearson Education 
 *    Limited.
 * 
 * @author Will Bohlen wbohlen@heidelberg.edu
 * @revision 13-Apr-2020
 */
public class TicTacToeJFController implements ActionListener
{
    TicTacToeJFView view;
    TicTacToeModel model;
    
    String currentTurn = "X";
    
    /**
     * No-arg constructor instantiates the model and view variables, and
     * displays the board.
     */
    public TicTacToeJFController()
    {
        model = new TicTacToeModel();
        view = new TicTacToeJFView();
        view.displayBoard(this);
        view.setTitle(currentTurn + "'s turn");
    }
    
    /**
     * Checks if a game has ended, and if it hasn't, moves to the next turn.
     */
    private void nextTurn()
    {
        if (!gameOver())
        {
            if (currentTurn.equals("X"))
                currentTurn = "O";
            else
                currentTurn = "X";
            
            view.setTitle(currentTurn + "'s turn");
        }
    }
    
    /**
     * Checks if a game has ended.
     * @return whether or not the game is over.
     */
    private boolean gameOver()
    {
        if (model.checkWin())
        {
            view.setTitle(currentTurn + " wins!");
            return true;
        }
        else if (model.checkTie())
        {
            view.setTitle("Tie!");
            return true;
        }
        
        return false;
    }
    
    /**
     * Updates the view and the model when a button is clicked.
     * @param e the ActionEvent tied to the button press event.
     */
    public void actionPerformed(ActionEvent e)
    {
        String buttonString = e.getActionCommand();
        JButton sourceButton = (JButton) (e.getSource());
        
        if (sourceButton.getText().equals("")) 
        {
            sourceButton.setText(currentTurn);
            model.setCell(Integer.parseInt(buttonString), currentTurn);
            
            nextTurn();
        }
    }
}

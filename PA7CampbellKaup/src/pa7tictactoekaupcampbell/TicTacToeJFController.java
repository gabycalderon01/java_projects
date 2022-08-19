/*
 * CPS 202
 * Spencer Kaup &
 * Ethan Campbell
 * April 6th 2021
 */

package pa7tictactoekaupcampbell;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File name:     TicTacToeJFController.java 
 * <p>
 * Description: Controller class for the PA7 Tic-Tac-Toe assignment problem. 
 *<p>
 * This class is designed to support the Model View Controller pattern.
 *<p>
 * Finished version.
 *<p>
 * @author Ethan Campbell ecampbe1@heidelberg.edu
 * @author Spencer Kaup skaup@heidelberg.edu
 * @version 6-April-2021 
 */
public class TicTacToeJFController implements ActionListener
{
    //-------instance fields-------
    
    private TicTacToeJFView view;
    private TicTacToeModel model;
    private String currentTurn;
    
    //-------constructors-------
    
    /**
     * No-arg constructor.
     */
    public TicTacToeJFController()
    {
        currentTurn = "X";
        model = new TicTacToeModel();
        view = new TicTacToeJFView();
        view.displayBoard(this);
        
    } //End no-arg constructor
    
    /**
     * Checks if a game has ended, and if it hasn't, moves to the next turn.
     */
    private void nextTurn()
    {
        if (!gameOver())
        {
            if (currentTurn.equals("X"))
            {
                currentTurn = "O";
                view.setTurnStatus(currentTurn);
            }
            else
            {
                currentTurn = "X";
                view.setTurnStatus(currentTurn);
            }
            
            
        }
    } //end private void nextTurn()
    
    /**
     * Checks with the model if game has ended.
     * @return whether or not the game is over in the form of boolean.
     */
    private boolean gameOver()
    {
        if (model.checkWin())
        {
            view.setWinner(currentTurn);
            view.setResettoPlayAgain();
            return true;
            
        }
        
        else if (model.checkTie())
        {
            view.tieWins();
            view.setResettoPlayAgain();
            return true;
            
        }
        
        return false;
        
    } //end private boolean gameOver()
    
    /**
     * Updates the view and the model when a button is clicked.
     * @param e the ActionEvent tied to the button press event.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String buttonString = e.getActionCommand();
    
        if (buttonString.equals("reset"))
        {
            view.resetGameBoard();
           TicTacToeJFController controller = new TicTacToeJFController();
        }
        
        else if (model.getCell(Integer.parseInt(buttonString)).equals("")) 
        {
            view.setText(currentTurn, e.getSource());
            
            model.setCell(Integer.parseInt(buttonString), currentTurn);
            
            nextTurn();
        }
        
    } //end public void actionPerformed(ActionEvent e)
    
} //end public class TicTacToeJFController implements ActionListener

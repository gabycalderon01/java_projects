/*
 * CPS 202
 * Spencer Kaup &
 * Ethan Campbell
 * April 6th 2021
 */

package pa7tictactoekaupcampbell;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * File name:     TicTacToeJFView.java 
 * <p>
 * Description: View class for the PA7 Tic-Tac-Toe assignment problem. 
 *<p>
 * This class is designed to support the Model View Controller pattern.
 *<p>
 * Finished version.
 *<p>
 * @author Ethan Campbell ecampbe1@heidelberg.edu
 * @author Spencer Kaup skaup@heidelberg.edu
 * @version 6-April-2021 
 */
public class TicTacToeJFView
{   
    
    //-------instance fields-------
    
    private JFrame frame;
    private JLabel welcomeTitle;
    private JButton gameButton;
    private JButton reset;
    private JPanel game;
    
    //-------constructors-------
    
    /**
     * No-arg constructor.
     */
    public TicTacToeJFView()
    {
        frame = new JFrame("Tic-Tac-Toe!");
        welcomeTitle = new JLabel("Welcome to Tic-Tac-Toe!      X's Turn");
        gameButton = new JButton("");
        reset = new JButton("Reset board");
        game = new JPanel(new GridLayout(4,4));
        
    } //End no-arg constructor

    /**
     * Populates the board with buttons, then displays it.
     * Configured to display in North, Center, and South board areas.
     * @param action the method to be run when a button is clicked.
     */

    public void displayBoard(ActionListener action)
    {
        
        for (int i = 0; i < 16; i++)
        {
            gameButton = new JButton("");
            gameButton.addActionListener(action);
            gameButton.setActionCommand(Integer.toString(i));
            game.add(gameButton);
        }
        
        reset.addActionListener(action);
        reset.setActionCommand("reset");
        
        frame.add(welcomeTitle, BorderLayout.NORTH);
        frame.add(game, BorderLayout.CENTER);
        frame.add(reset, BorderLayout.SOUTH);
   
        frame.setSize(800, 800);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    } //end public void displayBoard
    
    /**
     * Displays the current turn taker.
     * @param northBoard the new game status
     */
    public void setTurnStatus(String northBoard)
    {
       welcomeTitle.setText(northBoard + "'s turn!"); 
    } //end public void setTurnStatus
    
    /**
     * Displays the winner of the game.
     * @param northBoard the winner status.
     */
    public void setWinner(String northBoard)
    {
        welcomeTitle.setText(northBoard + " wins!");
    } //end public void setWinner
    
    /**
     * displays that there is a tie.
     */
    public void tieWins()
    {
       welcomeTitle.setText("It's a tie!");   
    } //end public void tieWins
    
    /**
     * This sets the text of the button that was pressed to the proper
     * X or O that was placed there.
     * @param currentTurn represents if it is X or O's turn
     * @param source is the button that was pressed
     */
    public void setText(String currentTurn, Object source) 
    {
        JButton sourceButton = (JButton) (source);
        sourceButton.setText(currentTurn);
        
    } //end public void setText
    
    /**
     * Sets the reset button to read Play Again? instead of reset.
     */
    public void setResettoPlayAgain()
    {
        reset.setText("Play Again?");
        
    } //end public void setResettoPlayAgain
    
    /**
     * This simply turns the Visibility of the frame to "false" or off
     */
    public void resetGameBoard()
    {
        frame.setVisible(false);
        
    } //end public void resetGameBoard
    
} //end public class TicTacToeJFView

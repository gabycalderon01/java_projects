/*
 * CPS 202
 * Spring 2020
 * Will Bohlen
 */
package pa2feb5bohlen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * File name:    GameController.java <p>
 * Description:  Programming Project 2, Savitch 6e, Ch. 6, p. 419.
 *               <p>
 *               This program handles the memory game logic as well as JFrame
 *               output.
 * 
 * @author Will Bohlen
 * @version 06-Apr-2020
 */
public class GameController 
{
    private JFrame frame;
    private MemoryBoard memoryBoard = new MemoryBoard();
    private boolean victory = false; // Controls the main loop.
    private JButton buttonOne; 
    private JButton buttonTwo;
    private Card cardOne; 
    private Card cardTwo;
    private boolean match; // True if the current pair is a match.
    private int gameState; // The game's current position in the logic.
    
    /**
     * No-arg constructor creates a new GameController and starts the memory game.
     */
    public GameController()
    {
        frame = new JFrame();
        gameState = 0;
        displayBoard();
        runGame();
    }
    
    /**
     * The main logic for the memory game.
     */
    private void runGame() 
    {
        if (gameState == 0) // State 0: Wait for first card input
        {
            frame.setTitle("Select first card:");
        }
        
        else if (gameState == 1) // State 1: Wait for second card input
        {
            frame.setTitle("Select second card:");
        }
        
        else if (gameState == 2) // State 2: Compare cards and output result
        {
            match = cardOne.equals(cardTwo);
            if (match) 
            {
                if (memoryBoard.checkWin()) 
                {
                    frame.setTitle("Victory! Press any button to quit.");
                    gameState = 4;
                }
                else
                {
                    frame.setTitle("Match found! "
                            + "Select first card:");
                    gameState = 0; // Allow next card to be input
                }
            }
            else
            {
                frame.setTitle("Not a match! "
                            + "Press any button to continue.");
                gameState = 3;
            }
        }   

        else if (gameState == 3) // State 3: Flip cards back over, then go back to state 0.
        {
            cardOne.setVisible(false);
            cardTwo.setVisible(false);
            buttonOne.setText("");
            buttonTwo.setText("");
            gameState = 0;
            runGame();
        }
        
        else if (gameState == 4) // State 4: Game is won and ended.
        {
            // Deliberatly empty.     
        }
        
        else
        {
            System.out.println("Invalid game state!");
            gameState = 0;
        }
    }
    
    /**
     * Populates the board with buttons, then displays it.
     */
    public void displayBoard()
    {
        frame.setLayout(new GridLayout(4, 4));
        
        for (int i = 0; i < 16; i++)
        {
            JButton button = new JButton("");
            button.addActionListener(new MemoryListener());
            button.setActionCommand(Integer.toString(i));
            frame.add(button);
        }
        
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
 
    private class MemoryListener implements ActionListener
    {
    /**
     * Updates the view and the model when a button is clicked.
     * @param e the ActionEvent tied to the button press event.
     */
        public void actionPerformed(ActionEvent e)
        {
            String buttonString = e.getActionCommand();
            JButton sourceButton = (JButton) (e.getSource());
            
            if (gameState == 0 || gameState == 1)
            {
                if (sourceButton.getText().equals("")) 
                {
                    Card selectedCard = memoryBoard.getCard(Integer.parseInt(buttonString));

                    if (!selectedCard.getVisible())
                    {
                        selectedCard.setVisible(true);
                        sourceButton.setText(Integer.toString(selectedCard.getValue()));
                        if (gameState == 0)
                        {
                            buttonOne = sourceButton;
                            cardOne = selectedCard;
                        }
                        else // gameState must equal 1 in this case
                        {
                            buttonTwo = sourceButton;
                            cardTwo = selectedCard;
                        }
                        // Increment game state
                        gameState++;
                        runGame();
                    }
                }
            }
            else if (gameState == 2)
            {
                gameState = 0;
                runGame();
            }
            else if (gameState == 3)
            {
                runGame();
            }
            else if (gameState == 4)
            {
                // Close window if game is won
                frame.dispose();
            }
        }
    }
}
 
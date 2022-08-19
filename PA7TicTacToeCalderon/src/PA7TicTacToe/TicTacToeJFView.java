/*
 * CPS 202
 * Gabriela Calderon
 * April 7, 2021
 */
package PA7TicTacToe;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

/**
 * File name:   TicTacToeJFView.java
 * Description: The view must represent the game layout as 2D array of
 *              JButton. *Cannot inherit from JFrame*
 * @author      Gabriela Calderon
 * @revision    April 7, 2021
 */

public class TicTacToeJFView 
{
    //----------------CONSTANT FIELDS-----------------
    
    public static final int height = 300;
    public static final int width = 300;
    public static final int boardsize = 4;
    
    //------------INSTANCE FIELDS-------------
    
    private JButton[][] gameButtonArray;
    private JFrame frame;
    private JLabel messageLabel;
    private JPanel squareButtonPanel;
    private JButton squareButton;
    private JPanel resetButtonPanel;
    private JButton resetButton;
    
    //-----------------CONSTRUCTORS----------------
    
    //No-arg constructor
    TicTacToeJFView()
    {
        gameButtonArray = new JButton[boardsize][boardsize];
        createAndShowGUI();
    } //End of no-arg constructor
    
    //--------------METHODS---------------
    /**
     * Creates and displays the GUI.
     */
    public void createAndShowGUI()
    {
        //First set up the JFrame        
        frame = new JFrame("Tic-Tac-Toe");
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
        //Create the message area
        messageLabel = new JLabel("I want to play a game...");
        
        //Create the panel to store the game board buttons
        squareButtonPanel = new JPanel();
        squareButtonPanel.setLayout(new GridLayout(boardsize, boardsize));
        
        //Create buttons and add them to the squareButton panel
        for (int r = 0; r < boardsize; r++)
            for (int c = 0; c < boardsize; c++)
            {
                squareButton = new JButton(" ");
                squareButtonPanel.add(squareButton);
                gameButtonArray[r][c] = squareButton;
            }
        
        //Create the panel for the reset button
        resetButtonPanel = new JPanel();
        resetButtonPanel.setLayout(new BorderLayout());
        
        //Create reset button and add it to the resetButton panel
        resetButton = new JButton("Reset the board");
        resetButtonPanel.add(resetButton);
        
        //Add message area, and square and reset button panels to the frame
        frame.add(messageLabel, BorderLayout.NORTH); //Message on the top
        frame.add(squareButtonPanel, BorderLayout.CENTER); //Button in center        
        frame.add(resetButtonPanel, BorderLayout.SOUTH); //reset button in south
        
        //Display the frame
        frame.setVisible(true);
        
    } //End of createAndShowGUI() method
    
    /**
     * Adds a listener to the reset button.
     * @param listener
     */
    public void addListenerToResetButton(ActionListener listener)
    {
        resetButton.addActionListener(listener);
    } //End of addListenerToResetButton method
    
    /**
     * Adds a listener to square buttons
     * @param row
     * @param column
     * @param listener 
     */
    public void addListenersToSquareButtons(int row, int column, 
                        ActionListener listener)
    {
        gameButtonArray[row][column].addActionListener(listener);
    } //End of addListenersToSquareButtons method
    
    /**
     * Getter for the button array
     * @return  the game button array
     */
    public JButton[][] getGameButtonArray()
    {
        return gameButtonArray;
    } //End of getGameButtonArray method
    
    /**
     * Setter for the message label
     * @param tempLabel 
     */
    public void setMessageLabel(String tempLabel)
    {
        messageLabel.setText(tempLabel);
    } //End of setMessageLabel method
    
    /**
     * Getter for the message label
     * @return 
     */
    public String getMessageLabel()
    {
        return messageLabel.getText();
    } //End of getMessageLabel method
    
    /**
     * Setter for the square button
     * @param r
     * @param c
     * @param tempButton 
     */
    public void setSquareButton(int r, int c, JButton tempButton)
    {
        gameButtonArray[r][c] = tempButton;
    } //End of setSquareButton method
    
    /**
     * Getter for the square button
     * @param r
     * @param c
     * @return 
     */
    public JButton getSquareButton(int row, int col)
    {
        return gameButtonArray[row][col];
    } //End of getSquareButton method
    
    /**
     * Setter for the reset button
     * @param tempButton 
     */
    public void setResetButton(JButton tempButton)
    {
        resetButton = tempButton;
    } //End of setResetButton method
    
    /**
     * Getter for the reset button
     * @return 
     */
    public JButton getResetButton()
    {
        return resetButton;
    } //End of getResetButton method
    
    /**
     * When called disposes the frame to start a new game.
     */
    public void gameOver()
    {
        frame.dispose();
        createAndShowGUI();
    } //End of gameOver method
    
    /**
     * Displays whose turn it is.
     * @param t 
     */
    public void displayTurn(String t)
    {
        messageLabel.setText("It's " + t + "'s turn.");
    } //End of displayTurn method
    
    /**
     * Displays who won the game.
     * @param w 
     */
    public void setWinner(String w)
    {
        messageLabel.setText("Congratulations! " + w + " is the winner!");
    } //End of setWinner method
    
    /**
     * Changes the text in the messageLabel to display that there was a tie.
     */
    public void setTie()
    {
        messageLabel.setText("There is a tie!");
    } //End of setTie method
    
    /**
     * Changes the text in the resetButton to invite the player to play again.
     */
    public void setPlayAgain()
    {
        resetButton.setText("Let's play again!");
    } //End of setPlayAgain method
} //End of TicTacToeJFView class
    
    

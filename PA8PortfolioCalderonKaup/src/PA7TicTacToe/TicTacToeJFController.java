/*
 * CPS 202
 * Gabriela Calderon
 * April 7, 2021
 */
package PA7TicTacToe;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 * File name:   TicTacToeJFController.java
 * Description: The controller must implement the MVC design.
 * @author      Gabriela Calderon
 * @revision    April 7, 2021
 */

public class TicTacToeJFController 
{
    //-------------------INSTANCE FIELDS-------------
    private TicTacToeModel model; //instance field of model class
    private TicTacToeJFView view; //instance field of view class
    private String turn;
    private JButton[][] gameArray;
    
    //--------------------CONSTRUCTORS---------------------
    /**
     * No-arg constructor.
     */
    public TicTacToeJFController()
    {                
        model = new TicTacToeModel();
        view = new TicTacToeJFView();
        turn = "O";
        gameArray = view.getGameButtonArray();
        runApplication();        
    } //End no-arg constructor
            
    //----------------------METHODS------------------------
    /**
     * runApplication method runs the game.
     */
    public void runApplication()
    {
        
        for (int r = 0; r < TicTacToeJFView.boardsize; r++)
            for (int c = 0; c < TicTacToeJFView.boardsize; c++)
            {
                view.addListenersToSquareButtons(r, c, new ButtonListener(r, c, 
                        gameArray[r][c]));
            }    
        view.addListenerToResetButton(new ButtonListener
                                                (view.getResetButton()));
                
    } //End of runApplication() method
    
    /**
     * Checks if the game is over by checking if there is a winner or if
     * there is a tie.
     * @return  whether or not the game is over
     */
    public boolean finishGame()
    {                
        if (model.getWin() != null)
        {
            view.setWinner(model.getWin());
            view.setPlayAgain();
            return true;
        }
        else if (model.getTie())
        {
            view.setTie();
            view.setPlayAgain();            
            return true;
        }        
        return false;
        
    } //End of finishGame method
        
    /**
     * nextTurn() method moves to the next turn if the game is not over yet.
     */
    public void nextTurn()
    {        
        if (!finishGame())
            if (turn.equals("X"))
            {
                turn = "O";
                view.displayTurn(turn);
            }
        
            else if (turn.equals("O"))
            {
                turn = "X";
                view.displayTurn(turn);
            }                
    } //End of nextTurn method
    
    //--------------------INNER CLASS-----------------------      
    
    /**
     * ButtonListener inner class is used to implement the ActionListener 
     * interface in the program.
     */
   
    private class ButtonListener implements ActionListener    
    {                
        /**
         * Inner class 3-arg constructor handles the square button listeners.
         * @param row               Row of the array containing the buttons.
         * @param col               Column of the array containing the buttons.
         * @param buttonClicked     The specific button clicked.
         */
        public ButtonListener(int row, int col, JButton buttonClicked)
        {            
            view.addListenersToSquareButtons(row, col, this);
        
        } //End of the ButtonListener 3-arg constructor.
        
        /**
         * Inner class 1-arg constructor that handles the reset button listener.
         * @param buttonReset       The reset button.
         */
        public ButtonListener(JButton buttonReset)
        {
            view.addListenerToResetButton(this);
        } //End of the ButtonListener 1-arg constructor.
        
        //----------INNER INSTANCE METHODS-----------
        /**
         * ActionPerformed method acts depending on the button pressed.
         * @param e     The ActionEvent related to the button pressed.
         */
        @Override
        public void actionPerformed(ActionEvent e) 
        {            
            JButton buttonClicked = (JButton)e.getSource();
            String buttonText = buttonClicked.getActionCommand();
            
            /**
             * Check whether the button clicked was the reset/play again button
             * or one of the array buttons.
             */
            
            if (buttonText.equals(("Reset the board")) || 
                    (buttonText.equals("Let's play again!")))
            {
                view.gameOver();
                TicTacToeJFController controller = 
                                        new TicTacToeJFController();
            }            
            else if (buttonText.equals(" "))
            {
                if (turn.equals("X"))
                {
                    buttonClicked.setText(turn);
                    buttonClicked.setBackground(Color.cyan);
                    buttonClicked.setForeground(Color.black);
                    buttonClicked.setOpaque(true);                        
                    model.setCell(findButtonRow(buttonClicked), 
                        findButtonColumn(buttonClicked), turn);
                }    
                else if (turn.equals("O"))
                {
                    buttonClicked.setText(turn);
                    buttonClicked.setBackground(Color.green);
                    buttonClicked.setForeground(Color.black);
                    buttonClicked.setOpaque(true);                        
                    model.setCell(findButtonRow(buttonClicked), 
                        findButtonColumn(buttonClicked), turn);
                }                                 
            nextTurn();
            
            }
        } //End of actionPerformed method
    
        /**
         * findButtonRow is used to find the row of the button clicked in the
         * game array.
         * @param button    Specific button clicked.
         * @return          The row of the button.
         */
        public int findButtonRow(Object button)
        {
            int row = 0;
            for (int r = 0; r < gameArray.length; r++)
            {
                for (int c = 0; c < gameArray[0].length; c++)
                {
                    if (button.equals(gameArray[r][c])) 
                    {
                        //column = c;
                        row = r;
                    }
                }
            }
            return row;
        } //End of the findButtonRow method.
        
        /**
         * findButtonColumn is used to find the column of the button clicked
         * in the game array.
         * @param button    Specific button clicked.
         * @return          The column of the button.
         */
        public int findButtonColumn(Object button)
        {
            int column = 0;
            for (int r = 0; r < gameArray.length; r++) 
            {
                for (int c = 0; c < gameArray[0].length; c++) 
                {
                    if (button.equals(gameArray[r][c])) {                    
                        column = c;
                    }
                }
            }
            return column;
        } //End of findButtonColumn method
        
    } //End of inner class ButtonListener
    
} //End of Controller class


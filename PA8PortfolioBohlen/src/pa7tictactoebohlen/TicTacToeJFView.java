/*
 * CPS 202
 * Will Bohlen
 * 13-Apr-2020
 */
package pa7tictactoebohlen;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * File name:     TicTacToeJFView.java <p>
 * Description:   Programming Project 2, Savitch 6e, Ch. 17, p. 1022.
 *                <p>
 *                This class handles the GUI output.
 * 
 * <p>
 * Savitch, Walter. 2016. Absolute Java, 6th Edition. Essex: Pearson Education 
 *    Limited.
 * 
 * @author Will Bohlen wbohlen@heidelberg.edu
 * @revision 13-Apr-2020
 */
public class TicTacToeJFView
{    
    
    private JFrame frame;
    
    /**
     * No-arg constructor instantiates the JFrame.
     */
    public TicTacToeJFView()
    {
        frame = new JFrame();
    }

    /**
     * Populates the board with buttons, then displays it.
     * @param action the method to be run when a button is clicked.
     */
    public void displayBoard(ActionListener action)
    {
        frame.setLayout(new GridLayout(3, 3));
        
        for (int i = 0; i < 9; i++)
        {
            JButton button = new JButton("");
            button.addActionListener(action);
            button.setActionCommand(Integer.toString(i));
            frame.add(button);
        }
        
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    /**
     * Sets the title of the window.
     * @param boardTitle the new window title.
     */
    public void setTitle(String boardTitle)
    {
        frame.setTitle(boardTitle);
    }
    
}

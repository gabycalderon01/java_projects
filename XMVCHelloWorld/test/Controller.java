/*
 * CPS 202
 * Fall 2016
 * Dr. Close
 *
 * Copyright © 2016 Daryl Close 
 * This work is licensed under the Creative Commons 
 * Attribution-Noncommercial-No Derivative Works 3.0 United States License. 
 * To myConsoleView a copy of this license, visit 
 * http://creativecommons.org/licenses/by-nc-nd/3.0/us/ 
 * or send a letter to Creative Commons, 171 Second Street, Suite 300, 
 * San Francisco, California, 94105, USA. * 
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.util.Scanner;

/**
 * In the MVC pattern, the Controller class handles input and updates the 
 * Model and the View.
 * <p>
 * The Controller knows about both the Model and the View, i.e., it contains 
 * references to objects of both classes.  This allows the Controller to 
 * invoke getters, setters, and other methods provided by the APIs of the 
 * Model and View classes.  However, there is general agreement that the 
 * Controller should be UI-agnostic.
 * <p>
 * A Controller should be able to present the Model to multiple Views. This
 * controller supports both a console view and a JFrame GUI view.  Ideally, 
 * any View will implement a standard interface.  This guarantees that a 
 * View's API will be the same regardless of the nature of the View, i.e., 
 * console, GUI, etc.  For simplicity, the Controller constructor in this 
 * example contains the "guts" of the program, but tasks could be out-sourced 
 * to private methods. 
 * <p>
 * A UI-agnostic Controller is preferred, but requires this additional classes 
 * and is omitted here for simplicity.
 * 
 * @author Daryl Close dclose@heidelberg.edu
 * @version 1.0, 20 Nov 2016
 */
public class Controller
{
    //-------- Constants --------
    
    public static final String SCREEN_TITLE = "Welcome Center";
    public static final String PROMPT = "Enter your name:  ";
    public static final String MESSAGE = "Hello, there, ";
    
    //-------- Instance fields ---------
    
    private Model myModel;
    private ViewConsole myConsoleView;
    private ViewGUI myGUIView;    
    
    //-------- Constructor ---------
    
    public Controller()
    {
        runConsoleApplication();
        //runGUIApplication(); 
    }
    
    //-----------------------------
    //     Console Controller Code
    //-----------------------------
    
    public void runConsoleApplication()
    {
        //Instantiate Model and ViewConsole objects
        myModel = new Model();
        myConsoleView = new ViewConsole();
        
        //Ask the view to display the title on the console
        myConsoleView.displayTitle(SCREEN_TITLE);
     
        //Ask the View to display the input prompt
        myConsoleView.displayPrompt(PROMPT);
        
        //Obtain input from the console and pass it to the Model
        myModel.setName(getConsoleInput());
      
        //Ask the View to display output
        myConsoleView.displayMessage(MESSAGE + myModel.getName()); 
        
        System.exit(0);
    }
    
    private String getConsoleInput()
    {
        Scanner keyboard = new Scanner(System.in);
        
        return keyboard.next();
    }
    
    //-----------------------------
    //     GUI Controller Code
    //-----------------------------
    
    public void runGUIApplication()
    { 
        //Instantiate Model and ViewGUI objects
        myModel = new Model();
        myGUIView = new ViewGUI();
        
        myGUIView.addListenersToWidgets(new WidgetListener());
        
        //Pass the prompt string to the View
        myGUIView.setPrompt("Enter your name: ");
        
        //Ask the View to display the input prompt
        myGUIView.displayGUIPrompt();
        
    }//End public void runGUIApplication()  
    
    private String getJFrameInput()
    {
        return myGUIView.getInputOutputTextField();
    }
    
    /**
     * This private class implements the ActionListener interface.  An object 
     * of this class was created for each button in the Controller constructor 
     * above.  The constructor for this class takes the row and column 
     * coordinates for the entry in the game model that corresponds to where 
     * the button is located.
     */
    private class WidgetListener implements ActionListener
    {
        /**
         * Implements actionPerformed abstract method from the ActionListener 
         * interface.  When a button is clicked, this interface method will be 
         * invoked automatically.  All button actions are specified here.  Note 
         * that <p>
         * (1) this method is never explicitly invoked in the source code; 
         * and <p>
         * (2) there is no looping in the method's source code, yet loop 
         * behavior occurs.
         * <p>
         * @param e the ActionEvent object
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("Continue"))
            {        
                //Obtain input from the GUI and pass it to the Model
                myModel.setName(getJFrameInput());
        
                //Pass the greeting to the View
                myGUIView.setGreeting("Hello, there, " 
                                      + myModel.getName() + "!");
              
                //Ask the View to display output
                myGUIView.displayGUIGreeting();  
            }
            else
                myGUIView.setInputOutputTextField("Error in window interface.");

        }//End void actionPerformed(ActionEvent)

    }//End private class WidgetListener
 
}//End class Controller

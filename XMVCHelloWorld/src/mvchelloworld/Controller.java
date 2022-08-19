/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 *
 * Copyright © 2021 Daryl Close 
 * This work is licensed under the Creative Commons 
 * Attribution-Noncommercial-No Derivative Works 3.0 United States License. 
 * To viewConsole a copy of this license, visit 
 * http://creativecommons.org/licenses/by-nc-nd/3.0/us/ 
 * or send a letter to Creative Commons, 171 Second Street, Suite 300, 
 * San Francisco, California, 94105, USA. * 
 */

package mvchelloworld;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
 * controller supports both a console view and a JFrame GUI view.   
 * <p>
 * A UI-agnostic Controller is preferred, but this requires a Java interface
 * and is omitted here for simplicity.
 * <p>
 * Switching between the console and the GUI view must be done manually in the
 * constructor below.
 * 
 * @author Daryl Close dclose@heidelberg.edu
 * @version 1.1, 25-Mar-2021
 */
public class Controller
{
    //--------constants--------
    
    public static final String SCREEN_TITLE = "Welcome Center";
    public static final String PROMPT = "Enter your name:  ";
    public static final String MESSAGE = "Hello there, ";
    
    //--------instance fields---------
    
    private Model model;
    private ViewConsole viewConsole;
    private ViewGUI viewGUI;    
    
    //--------constructor---------
    
    /**
     * No-arg constructor supports both GUI and console views, but only by
     * manually commenting out the undesired view.
     */
    public Controller()
    {
        //runConsoleApplication();
        runGUIApplication(); 
        
    }//End no-arg constructor
    
    //--------instance methods---------
  
    /**
     * Runs JFrame application.
     */    
    public void runGUIApplication()
    { 
        //Instantiate Model and ViewGUI objects
        model = new Model();
        viewGUI = new ViewGUI();
     
        //Ask the View to display the frame title and the input prompt
        viewGUI.displayTitle(SCREEN_TITLE);
        viewGUI.displayPrompt(PROMPT);
        
        //Create a listener object to handle events generated by the View 
        viewGUI.addListenersToWidgets(new WidgetListener());
   
    }//End public void runGUIApplication()  
    
    /**
     * Runs console application.
     */    
    public void runConsoleApplication()
    {
        //Instantiate Model and ViewConsole objects
        model = new Model();
        viewConsole = new ViewConsole();
        
        //Ask the view to display the title and the input prompt
        viewConsole.displayTitle(SCREEN_TITLE);
        viewConsole.displayPrompt(PROMPT);
        
        //Obtain input from the console and update the Model
        model.setName(obtainConsoleInput());
      
        //Ask the View to display output
        viewConsole.displayMessage(MESSAGE + model.getName() + "!"); 
        
        System.exit(0);
        
    }//End public void runConsoleApplication()
    
    /**
     * Obtains the user name from the console interface.
     * 
     * @return the name 
     */
    private String obtainConsoleInput()
    {
        return viewConsole.getInput();
        
    }//End private String obtainConsoleInput()
    
    /**
     * Obtains the user name from GUI interface.
     * 
     * @return the name 
     */
    private String obtainGUIInput()
    {
        return viewGUI.getInput();
        
    }//End private String obtainGUIInput()
    
    //-------- inner class ---------
    
    /**
     * This inner class implements the ActionListener interface. It underlies
     * the key distinction between the View and the Controller because the 
     * Controller handles input while the View handles only output.  The 
     * Controller updates the View by passing the View an object of this class.
     * <p> 
     * A common alternative to an inner class is to code the class as an 
     * anonymous parameter in the addListenersToWidgets call (see above).  
     * This class could also be placed in its own file instead of being in the 
     * Controller class. 
     */
    private class WidgetListener implements ActionListener
    {
        /**
         * Implements actionPerformed abstract method from the ActionListener 
         * interface.  When a button is clicked, this interface method will be 
         * invoked automatically.  All button actions are specified here.  Note 
         * that 
         * <p>
         * (1) this method is never explicitly invoked in the source code; 
         * and 
         * <p>
         * (2) there is no looping in the method's source code, yet loop 
         * behavior occurs.
         * 
         * @param e the ActionEvent object
         */
        @Override
        public void actionPerformed(ActionEvent e)
        { 
            if (e.getActionCommand().equals("Continue"))
            {  
                //Obtain input from the GUI and pass it to the Model
                model.setName(obtainGUIInput());
        
                //Ask the View to display output                
                viewGUI.displayMessage(MESSAGE + model.getName() + "\n");  
            }
            else
                viewGUI.displayMessage("Error in window interface.");
            
        }//End public void actionPerformed(ActionEvent)

    }//End private class WidgetListener implements ActionListener
  
}//End public class Controller
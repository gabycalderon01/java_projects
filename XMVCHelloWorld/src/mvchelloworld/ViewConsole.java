/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 *
 * Copyright © 2021 Daryl Close 
 * This work is licensed under the Creative Commons 
 * Attribution-Noncommercial-No Derivative Works 3.0 United States License. 
 * To view a copy of this license, visit 
 * http://creativecommons.org/licenses/by-nc-nd/3.0/us/ 
 * or send a letter to Creative Commons, 171 Second Street, Suite 300, 
 * San Francisco, California, 94105, USA. * 
 */

package mvchelloworld;

import java.util.Scanner;

/**
 * In MVC, the View class handles output.  This View is console-based.
 * <p>
 * The View knows nothing about the Model or the Controller, 
 * i.e., the View contains no references to objects of either class. 
 *
 * @author Daryl Close dclose@heidelberg.edu
 * @version 1.1, 25-Mar-2021
 */
public class ViewConsole 
{
    //-------constructors-------
    
    /**
     * No-arg constructor
     */
    public ViewConsole()
    {
        //Deliberately empty.  Console pane is created by the IDE/system. 
        
    }//End no-arg constructor
    
    //-------- instance methods ---------
    
    /**
     * Displays the screen title.
     * 
     * @param title the screen title
     */
    public void displayTitle(String title)
    {
        System.out.print(title + "\n\n");
        
    }//End public void displayTitle(String)
    
    /**
     * Displays the prompt.
     * 
     * @param prompt the prompt
     */
    public void displayPrompt(String prompt)
    {
        System.out.print(prompt);
        
    }//End public void displayPrompt(String)
    
    /**
     * Displays the message to the user.
     * 
     * @param message the user message
     */
    public void displayMessage(String message)
    {
        System.out.println("\n" + message + "\n");
        
    }//End public void displayMessage(String)
    
    /**
     * Gets the text entered by the user.
     * 
     * @return the user text
     */
    public String getInput()
    {
        Scanner keyboard = new Scanner(System.in);        
        return keyboard.next();
                
    }//End public String getInput()
           
}//End public class ViewConsole

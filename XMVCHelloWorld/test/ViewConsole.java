/*
 * CPS 202
 * Fall 2016
 * Dr. Close
 *
 * Copyright © 2016 Daryl Close 
 * This work is licensed under the Creative Commons 
 * Attribution-Noncommercial-No Derivative Works 3.0 United States License. 
 * To view a copy of this license, visit 
 * http://creativecommons.org/licenses/by-nc-nd/3.0/us/ 
 * or send a letter to Creative Commons, 171 Second Street, Suite 300, 
 * San Francisco, California, 94105, USA. * 
 */

//Import declarations go here

/**
 * In MVC, the View class handles output.  This View is console-based.
 * <p>
 * The View knows nothing about the Model or the Controller, 
 * i.e., the View contains no references to objects of either class. 
 * 
 * @author Daryl Close dclose@heidelberg.edu
 * @version 1.0, 21 Nov 2016
 */
public class ViewConsole 
{
    //-------- Instance fields ---------
    
    //private String title;
    
    //-------- Constructor ---------
    
    public ViewConsole()
    {
        //Deliberately empty 
    }
    
    //-------- Instance methods ---------
    
    public void displayTitle(String tempTitle)
    {
        System.out.print(tempTitle + "\n\n");
    }
    
    public void displayPrompt(String tempPrompt)
    {
        System.out.print(tempPrompt);
    }
    
    public void displayMessage(String tempMessage)
    {
        System.out.println("\n" + tempMessage + "!\n");
    } 
  
    public void setTitle(String tempTitle)
    {
        //title = tempTitle;        
    }    
             
}//End class ViewConsole

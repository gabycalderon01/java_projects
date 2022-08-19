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
 * San Francisco, California, 94105, USA.  
 */

//Import declarations go here

/**
 * This program illustrates the use of the Model-View-Controller (MVC) design 
 * pattern in a very simple console-based program. Many MVC tutorials assume a
 * GUI view, making the sample programs more difficult to understand.
 * <p>
 * MVCHelloMain contains the main() method and executes the program by
 * instantiating an anonymous Controller object.  In an alternative design,
 * the main() method could declare Model and View objects and then pass those
 * objects to the Controller.
 * <p>
 * Javadoc comments for methods and constructors are omitted throughout.
 * 
 * @author Daryl Close dclose@heidelberg.edu
 * @version 1.0, 12 Nov 2016
 */
public class MVCHelloMain 
{
    public static void main(String[] args) 
    {
        new Controller(); 
        
    }//End main method

}//End class MVCHelloMain

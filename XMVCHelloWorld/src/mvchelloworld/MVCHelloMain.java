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
 * San Francisco, California, 94105, USA.  
 */

package mvchelloworld;

/**
 * This program illustrates the use of the Model-View-Controller (MVC) design 
 * pattern in a very simple GUI program. Many MVC tutorials assume a
 * GUI view, making the sample programs more difficult to understand.  A console
 * view class is also provided for comparison to demonstrate that MVC design
 * has nothing to do with GUI design, per se.
 * 
 * @author Daryl Close dclose@heidelberg.edu
 * @version 1.1, 25-Mar-2021
 */
public class MVCHelloMain 
{
    /**
     * Main method.
     * <p>
     * The main() method  executes the program by instantiating an anonymous 
     * Controller object.  In an alternative design, the main() method could 
     * declare Model and View objects and then pass those objects to the 
     * Controller.
     * 
     * @param args String array for command line arguments 
     */
    public static void main(String[] args) 
    {
        new Controller(); 
        
    }//End public static void main(String[])

}//End public class MVCHelloMain

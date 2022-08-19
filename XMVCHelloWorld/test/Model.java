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
 * In MVC, the Model class contains the data for the application as well as 
 * any data logic.  In this example, the only datum is the name and there is 
 * no data logic.
 * <p>
 * The Model knows nothing about the View or the Controller, i.e., the Model 
 * contains no references to objects of either class.  The Model is fully
 * compatible with any sort of user interface, e.g., console, GUI, Web, etc.
 * 
 * @author Daryl Close dclose@heidelberg.edu
 * @version 1.0, 12 Nov 2016
 */
public class Model 
{
    //-------- Instance fields ---------
    
    private String name;
    
    //-------- Constructors ---------
    
    public Model()
    {
        name = null;
    }
    
    //-------- Instance methods ---------
    
    public void setName(String tempName)
    {
        name = tempName;
    }
    
    public String getName()
    {
        return name;
    }
    
}//End class Model

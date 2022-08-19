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
 * @version 1.1, 25-Mar-2021
 */
public class Model 
{
    //--------instance fields---------
    
    private String name;
    
    //--------constructors---------
    
    /**
     * No-arg constructor.
     */
    public Model()
    {
        name = "empty";
        
    }//End no-arg constructor
    
    //--------instance methods---------
    
    /**
     * Sets the name field value.
     * 
     * @param name the name
     */
    public void setName(String name)
    {
        this.name = name;
        
    }//End public void setName(String)
    
    /**
     * Gets the name field value.
     * 
     * @return the name 
     */
    public String getName()
    {
        return name;
        
    }//End public String getName()
    
}//End public class Model

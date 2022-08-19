/*
 * CPS 202
 * Gabriela Calderon & Spencer Kaup
 * 22 March 2021
 */
package PA6BabyNames;

import javax.swing.JOptionPane;

/**
 * File name:   BabyNamesJODelegate.java
 * Description: this class contains the user view of the data and handles I/O.
 * @author      Gabriela Calderon & Spencer Kaup
 * @revision    March 22, 2021
 */
public class BabyNamesJODelegate 
{    
    //--------------CONSTRUCTORS--------------
    /**
     * No-arg constructor that runs the JOptionPane code.
     */
    public BabyNamesJODelegate()
    {        
        String name;
        do
        {            
            name = JOptionPane.showInputDialog("Please enter a baby "
                                                     + "name: ");             
            JOptionPane.showMessageDialog(null, printOutput(name));
            System.out.println(printOutput(name));
        }
        while (!name.equals("Q"));
    } //End of no-arg constructor
    
    //----------------METHODS------------------    
    
    /**
     * This method displays all the output.
     * @param name  The name entered by the user.
     * @return      The output to be displayed.
     */
    public String printOutput(String name)
    {
        BabyNamesModel model = new BabyNamesModel();
        
        int girlFrequency = model.getGirlNameFrequency(name);
        int boyFrequency = model.getBoyNameFrequency(name);
        
        int girlIndex = model.getGirlNameIndex(name);
        int boyIndex = model.getBoyNameIndex(name);
                        
        String girlFound = (name + " is ranked " + girlIndex + " in popularity"
                + " among girls with " + girlFrequency + " namings.\n");
        String girlNotFound = (name + " is not ranked among the top 1000 girl "
                + "names.\n");
        String boyFound = (name + " is ranked " + boyIndex + " in popularity "
                + "among boys with " + boyFrequency + " namings.\n");
        String boyNotFound = (name + " is not ranked among the top 1000 boy "
                + "names.\n");
        String output = "";
        
        if (!name.equals("Q"))
        {    
            if (girlFrequency > 0)
                output += girlFound;                   
            else
                output += girlNotFound;
            if (boyFrequency > 0)
                output += boyFound;                    
            else
                output += boyNotFound;
        }
        else 
            System.exit(0);

        return output;
    } //End of printOutput() method
    
} //End of BabyNamesJODelegate class

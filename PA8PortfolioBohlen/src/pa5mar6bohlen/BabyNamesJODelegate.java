/*
 * CPS 202
 * Will Bohlen
 * 06-Mar-2020
 */
package pa5mar6bohlen;

import javax.swing.JOptionPane;

/**
 * File name:     BabyNamesJODelegate.java <p>
 * Description:   Programming Project 1, Savitch 6e, Ch. 10, p. 547.
 *                <p>
 *                This class acts as the delegate and contains all the test code.
 * 
 * <p>
 * Savitch, Walter. 2016. Absolute Java, 6th Edition. Essex: Pearson Education 
 *    Limited.
 * 
 * @author Will Bohlen wbohlen@heidelberg.edu
 * @revision 06-Mar-2020
 */
public class BabyNamesJODelegate 
{
    BabyNamesModel boyNames = new BabyNamesModel("boynames.txt");
    BabyNamesModel girlNames = new BabyNamesModel("girlnames.txt");
    
    /**
     * No-arg constructor runs test code.
     */
    public BabyNamesJODelegate()
    {
        JOptionPane pane = new JOptionPane();
        
        String name = pane.showInputDialog("Enter a name:");
        
        while (!name.equals("Q")) 
        {
            System.out.println(printFrequency(name));
            pane.showMessageDialog(null, printFrequency(name));
            
            name = pane.showInputDialog("Enter a name:");
        } 
    }

    /**
     * Generates a string with frequency and ranking for the given name.
     * @param name The name to check.
     * @return The formatted frequency and ranking of the name.
     */
    private String printFrequency(String name)
    {
        int girlFrequency = girlNames.getFrequency(name);
        int boyFrequency = boyNames.getFrequency(name);
        
        int girlIndex = girlNames.getIndex(name) + 1;
        int boyIndex = boyNames.getIndex(name) + 1;
        
        String outputString = "";
        
        if (girlFrequency > 0)
        {
            outputString += (name + " is ranked " + girlIndex +
            " in popularity among girl names with " + girlFrequency + " namings.");
        }
        else
        {
            outputString += (name + 
                    " is not ranked among the top 1000 girl names.");
        }
        
        outputString += "\n";
        
        if (boyFrequency > 0)
        {
            outputString += (name + " is ranked " + boyIndex +
            " in popularity among boy names with " + boyFrequency + " namings.");
        }
        else
        {
            outputString += (name + 
                    " is not ranked among the top 1000 boy names.");
        }
        return outputString;
    }
    
}

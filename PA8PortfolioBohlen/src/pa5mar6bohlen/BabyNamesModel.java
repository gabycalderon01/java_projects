/*
 * CPS 202
 * Will Bohlen
 * 06-Mar-2020
 */
package pa5mar6bohlen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * File name:     BabyNamesModel.java <p>
 * Description:   Programming Project 1, Savitch 6e, Ch. 10, p. 54
 *                <p>
 *                This class is a model that stores information on baby names.
 * 
 * <p>
 * Savitch, Walter. 2016. Absolute Java, 6th Edition. Essex: Pearson Education 
 *    Limited.
 * 
 * @author Will Bohlen wbohlen@heidelberg.edu
 * @revision 06-Mar-2020
 */
public class BabyNamesModel 
{
    private String[] babyNames = new String[1000];
    private int[] nameFrequency = new int[1000];
    
    /**
     * String constructor initializes the model using data from the specified
     * file.
     * @param fileName The file to read.
     */
    public BabyNamesModel(String fileName)
    {
        readFile(fileName);
    }
    
    /**
     * Returns the frequency of any given name.
     * @param name The name to check.
     * @return The name's frequency. Returns -1 if not found in list.
     */
    public int getFrequency(String name)
    {
        int index = getIndex(name);
        
        if (index == -1)
            return -1;
        else
            return nameFrequency[index];
    }

    /**
     * Returns the index of any given name.
     * @param name The name to check.
     * @return The name's index. Returns -1 if not found in list.
     */
    public int getIndex(String name)
    {
        for (int i = 0; i < babyNames.length; i++)
        {
            if (babyNames[i].equals(name))
                return i;
        }
        return -1;
    }    
    /**
     * Reads a file into the babyNames and nameFrequency arrays.
     * @param fileName File to read.
     */    
    private void readFile(String fileName)
    {
        Scanner inputStream = null;
        int currentIndex = 0;
        
        try
        {
            inputStream = new Scanner(new FileInputStream(fileName));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File " + fileName + " not found.");
            return;
        }
        while (inputStream.hasNextLine())
        {
            String line = inputStream.nextLine();
            
            babyNames[currentIndex] = line.split(" ")[0];
            nameFrequency[currentIndex] = Integer.parseInt(line.split(" ")[1]);
            
            currentIndex++;
        }
        inputStream.close();
    }
    
}

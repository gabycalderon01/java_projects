/*
 * CPS 202
 * Gabriela Calderon & Spencer Kaup
 * 15 March 2021
 */
package pa5BabyNames;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * File name:   BabyNamesModel.java
 * Description: this class handles files and arrays.
 * @author      Gabriela Calderon & Spencer Kaup
 * @revision    March 15, 2021
 */
public class BabyNamesModel
{
    //----------------INSTANCE FIELDS----------------------
    
    //private String[] namesList = new String [1000];
    //private int[] frequencyList = new int [1000];
    private String[] boyNamesList = new String [1000];
    private String[] girlNamesList = new String [1000];
    private int[] boyFrequencyList = new int [1000];
    private int[] girlFrequencyList = new int [1000];
    //------------------CONSTRUCTORS----------------                     
    /**
     * Constructor that initializes instance field textFileName. This
     * constructor is referenced in the Delegate class to assign the different
     * .txt file names.
     * @param textFileName 
     */
    BabyNamesModel()
    {        
        readTextFilesIntoLists("boynames.txt");
        readTextFilesIntoLists("girlnames.txt");       
        
    } //End of no-arg constructor           
    
    //-------------------METHODS-----------------------
    
    /**
     * Checks if the name is in the list, and if so returns its index.
     * @param name  Entered by the user.
     * @return      Index of the name.
     */
    public int getBoyNameIndex(String name)
    {
        for (int i = 0; i < boyNamesList.length; i++)
        {
            if (boyNamesList[i].equalsIgnoreCase(name))
                return i;
        }
        return -1;
    } //End of getNameIndex method
    
    public int getGirlNameIndex(String name)
    {
        for (int i = 0; i < girlNamesList.length; i++)
        {
            if (girlNamesList[i].equalsIgnoreCase(name))
                return i;
        }
        return -1;
    }
        
    /**
     * Used to get the index of the name entered by the user.
     * @param name  name entered by the user.
     * @return      the name's frequency or -1 if not found.
     */
    public int getBoyNameFrequency(String name)
    {
        int index = getBoyNameIndex(name);
        
        if (index == -1)
            return -1;
        else
            return boyFrequencyList[index];
    } //End of getNameFrequency method  
    
    public int getGirlNameFrequency(String name)
    {
        int index = getGirlNameIndex(name);
        
        if (index == -1)
            return -1;
        else
            return girlFrequencyList[index];
    }
    /**
     * Method readTextFilesIntoLists()   
     * @param textFileName  the name of the .txt file containing names and
     *                      frequencies.
     */
    private void readTextFilesIntoLists (String textFileName)
    {
        Scanner inFile;
        boolean dataInputComplete;
        
        try
        {
            inFile = new Scanner(new FileInputStream(textFileName));
            
            if (!inFile.hasNextLine())
                dataInputComplete = false;
            else
            {
                int i = 0;
                while (inFile.hasNextLine())
                {
                    String line = inFile.nextLine();
                    if (textFileName.equals("boynames.txt"))
                    {
                        boyNamesList[i] = line.split(" ")[0];
                        boyFrequencyList[i] = Integer.parseInt
                                                        (line.split(" ")[1]);
                        i++;
                    }
                    else if (textFileName.equals("girlnames.txt"))        
                    {
                        girlNamesList[i] = line.split(" ")[0];
                        girlFrequencyList[i] = Integer.parseInt
                                                        (line.split(" ")[1]);
                        i++;
                    }
                        
                }
                dataInputComplete = true;
            }
            inFile.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage() 
                                + "\nCan't find text file of names\n"
                                + "Exiting program");
            System.exit(0);
        }
    } //End of readTextFilesIntoLists
           
} //End of BabyNamesModel class

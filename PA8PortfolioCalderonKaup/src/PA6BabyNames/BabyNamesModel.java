/*
 * CPS 202
 * Gabriela Calderon & Spencer Kaup
 * 22 March 2021
 */
package PA6BabyNames;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * File name:   BabyNamesModel.java
 * Description: this class handles files and arrays.
 * @author      Gabriela Calderon & Spencer Kaup
 * @revision    March 22, 2021
 */
public class BabyNamesModel
{
    //----------------INSTANCE FIELDS----------------------
       
    private ArrayList <String> boyNames = new ArrayList<>();
    private ArrayList <String> girlNames = new ArrayList<>();
    private ArrayList <Integer> boyFrequency = new ArrayList<>();
    private ArrayList <Integer> girlFrequency = new ArrayList<>();
    
    //------------------CONSTRUCTORS----------------   
    
    /**
     * No-arg constructor that initializes all the instance variables, as well
     * as call the readTextFilesIntoLists with the two different text file
     * names.
     */
    BabyNamesModel()
    {        
        boyNames = new ArrayList<>(1000);
        girlNames = new ArrayList<>(1000);
        boyFrequency = new ArrayList<>(1000);
        girlFrequency = new ArrayList<>(1000);
        readTextFilesIntoArrayLists("boynames2020.txt");
        readTextFilesIntoArrayLists("girlnames2020.txt");               
    } //End of no-arg constructor           
    
    //-------------------METHODS-----------------------
    
    /**
     * Method used to get the index of the name entered by the user in the 
     * boys ArrayList.
     * @param name  Entered by the user.
     * @return      The index of the name in the boys ArrayList.
     */
    public int getBoyNameIndex(String name)
    {
        for (int i = 0; i < boyNames.size(); i++)
        {
            if (boyNames.get(i).equalsIgnoreCase(name))
                return i + 1;
        }
        return -1;
    } //End of the getBoyNameIndex method
    
    /**
     * Method used to get the index of the name entered by the user in the
     * girls ArrayList.
     * @param name  Entered by the user.
     * @return      The index of the name in the girls ArrayList.
     */
    public int getGirlNameIndex(String name)
    {
        for (int i = 0; i < girlNames.size(); i++)
        {
            if (girlNames.get(i).equalsIgnoreCase(name))
                return i + 1;
        }
        return -1;
    } //End of the getGirlNameIndex method
        
    /**
     * Method used to get the frequency of the name entered by the user in the 
     * boys ArrayList.
     * @param name  name entered by the user.
     * @return      the name's frequency in the boys ArrayList or -1 if not 
     *              found.
     */
    public int getBoyNameFrequency(String name)
    {
        int index = getBoyNameIndex(name);
        
        if (index == -1)
            return -1;
        else
            return (boyFrequency.get(index));
    } //End of getBoyNameFrequency method  
    
    /**
     * Method used to get the frequency of the name entered by the user in the 
     * girls ArrayList.
     * @param name  name entered by the user.
     * @return      the name's frequency in the girls ArrayList or -1 if not
     *              found.
     */
    public int getGirlNameFrequency(String name)
    {
        int index = getGirlNameIndex(name);
        
        if (index == -1)
            return -1;
        else
            return girlFrequency.get(index);
    } //End of the getGirlNameFrequency method
    
    /**
     * Method readTextFilesIntoArrayLists() is used to turn the text files 
     * into ArrayLists.
     * @param textFileName  the name of the .txt files containing names and
     *                      frequencies.
     */
    private void readTextFilesIntoArrayLists (String textFileName)
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
                    if (textFileName.equals("boynames2020.txt"))
                    {
                        boyNames.add(line.split(" ")[0]);
                        boyFrequency.add(Integer.parseInt
                                                        (line.split(" ")[1]));
                        i++;
                    }
                    else if (textFileName.equals("girlnames2020.txt"))        
                    {
                        girlNames.add(line.split(" ")[0]);
                        girlFrequency.add(Integer.parseInt
                                                        (line.split(" ")[1]));
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
    } //End of readTextFilesIntoArrayLists
           
} //End of BabyNamesModel class

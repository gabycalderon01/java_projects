/*
 * CPS 202
 * Will Bohlen
 * 4-May-2020
 */
package pa8portfoliobohlen;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * File name:     PA8PortfolioFileDelegateBohlen.java <p>
 * Description:   Programming Assignment 8 (JMenu Portfolio)
 *                <p>
 *                This program reads the help text file.
 * 
 *                Adapted from code written by Daryl Close.
 * @author Will Bohlen wbohlen@heidelberg.edu
 * @author Daryl Close dclose@heidelberg.edu
 * @revision 6-May-2020
 */
public class PA8PortfolioFileDelegateBohlen
{
    ////////// STATIC FIELDS //////////
    
    private static String fileName = "pa8-helpfile.txt";
 
    ////////// STATIC METHODS /////////
     
    /**
     * 
     * @return the text file as a string with line breaks. 
     */
    public static String readTextFile()
    {
        Scanner inputStream = null;
        String line = "";
        
        try //Try to open the text file
        {
            inputStream = new Scanner(new File(fileName));
        }        
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            return "Error reading file " + fileName;
        }
        
        //Loop through file and append each line to a string
        while (inputStream.hasNextLine())
            line = line + inputStream.nextLine() + "\n";        
        
        inputStream.close();
        
        return line; 
        
    }//End static method String readTextFile()
 
}//End class TextFileIOModel
package pa8portfolio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Gabyc
 */
public class PA8PortfolioFileDelegateCalderonKaup 
{
    private static String fileName = "pa8helpfile.txt";
    
    public static String readTextFile()
    {
        Scanner inputStream = null;
        String line = "";
        
        try
        {
            
            inputStream = new Scanner(new File(fileName));     
            
            /*while (inputStream.hasNextLine())
            {
                lines = lines + inputStream.nextLine() + "\n";
            }*/
            
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error reading file" + "FILES.txt");
            e.printStackTrace();
            System.exit(1);
        }
        
        
        inputStream.close();
        
        return line;
        
    }
}

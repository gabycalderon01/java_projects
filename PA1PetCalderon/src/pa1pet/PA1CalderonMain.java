package pa1pet;

import java.util.Scanner;

public class PA1CalderonMain
{
    /**
     * File name:     
    */
    public static void main(String[] args)
    {
        PA1Calderon usersPet = new PA1Calderon();
        
        //program header
        System.out.println("\n\t\tTEST OF VETINARY PET CLASS\n\n"
                            + "Gabriela Calderon\n"
                            + "February 1, 2021\n");
        System.out.println("This program tests drug dosage calculations"
                           + " based on a cat or dog Pet type.");
        System.out.println();
        
        System.out.println("My records on your pet are incomplete.");
        System.out.println("Here is what they currently say:");
        System.out.println();
        System.out.println(usersPet);
        //System.out.println();
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Please enter the pet's name:  ");
        String name = keyboard.nextLine( );
        
        System.out.print("Please enter the pet's type (dog or cat):  ");
        String petType = keyboard.nextLine( );
        
        System.out.print("Please enter the pet's age:  ");
        int age = keyboard.nextInt( );
        
        System.out.print("Please enter the pet's weight:  ");
        double weight = keyboard.nextDouble( );        
        System.out.println();
        
        usersPet.set(petType, name, age, weight);
        System.out.println("My records now say:");
        System.out.println(usersPet);
        
        System.out.println(String.format("Dose of carprofen: %.4f", 
                usersPet.getCarprofen(0.0)));
        System.out.println();
        System.out.println(String.format("Dose of acepromazine: %.4f", 
                usersPet.getAcepromazine(0.0)));
        System.out.println();
        
    }
}

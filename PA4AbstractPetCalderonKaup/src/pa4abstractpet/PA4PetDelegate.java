/*
 * CPS 202
 *  Spencer Kaup, Gabriela Calderon
 * 30 February 2021
 */
package pa4abstractpet;

/**
 * File name:     PA4PetDelegate.java <p>
 * Description:   Programming Project 8, Savitch 6e, Ch. 8, p. 520.
 *                <p>
 *                This class acts as the delegate and contains all the 
 *                test code.
 *
 * Savitch, Walter. 2016. Absolute Java, 6th Edition. Essex: Pearson Education 
 *    Limited.
 * 
 * @author Spencer Kaup skaup@heidelberg.edu & 
 *         Gabriela Calderon gcaldero@heidelberg.edu
 * @revision 3rd March 2021
 */
public class PA4PetDelegate{
    
    //-----------instance fields---------------
    
    Pet[] listOfPets = new Pet[5];
    Pet garfield;
    Pet garfieldJr;
    Pet odie;    
    
    //End of instance fields
    
    //-----------constructor----------------
    
    PA4PetDelegate()
    {                
        System.out.println(displayProgramHeader());
                
        listOfPets[0] = new Cat("Garfield", 10, 8.0);
        listOfPets[1] = new Cat("Garfield, Jr.", 10, 8.0);
        listOfPets[2] = new Cat("Mr. Whickers", 4, 7.0);
        listOfPets[3] = new Dog("Odie", 8, 40.0);
        listOfPets[4] = new Dog("Rex", 11, 65.0);
        
        displayListOfPets();
        catEqualsTest();
        catCloneTest();
        dogEqualsTest();
        dogCloneTest();
    } //End of PA4Delegate constructor
    
    //---------------methods----------------
    
    /**
     * Returns the program header.
     * @return displayProgramHeader
     */   
    public String displayProgramHeader()
    {
        return("\n\t\tTEST OF ABSTRACT PET CLASS WITH INHERITANCE\n\n"
                + "Gabriela Calderon and Spencer Kaup\n"
                + "March 3, 2021\n\n"
                + "This program tests drug dosage calculations based "
                + "on a cat or dog Pet type."
                + "\nAlso tested: equals(), hashCode(), clone(), and the "
                + "copy constructor.\n\n"
                + "The pets are stored in a list.\n");
    } //End of displayHeader method
    
    
    /**
     * Displays the array of pets along with the correct drug dosages.* 
     */
    private void displayListOfPets()
    {
        System.out.println("\nList of cats and dogs:\n");
        for (int i = 0; i < listOfPets.length; i++)
        {
            System.out.println(listOfPets[i].toString());
            System.out.printf("Acepromazine: \t%-9.5f\n",
                    listOfPets[i].acepromazine());
            System.out.printf("Carprofen: \t%.5f\n", listOfPets[i].carprofen());
            System.out.println();
        }
    } //End of displayListOfPets method
    
    /**
     * Tests the equals method for cats Garfield and Garfield Jr.
     */
    private void catEqualsTest()
    {
    Pet garfield = listOfPets[0];
    Pet garfieldJr = listOfPets[1];
    
    System.out.println("\n*****************************************"
                       + "\nThis is a test of the Cat equals override.\n"
                       + "\nLet's compare the garfield object with the "
                       + "garfieldJr object. \nFirst, we'll print out both "
                       + "objects so that we can see if both cats have "
                       + "\nthe same name, age, and weight. Then, we'll test "
                       + "the equals method.\n");
    
    System.out.println(garfield.toString());
    System.out.println("\n" + garfieldJr.toString());

    if (garfield.equals(garfieldJr))
        System.out.println("\nThe equals method says that the garfield and "
                           + "the garfieldJr objects have logical (deep)"
                           + " equality.");
    else
        System.out.println("\nThe equals method says that the Garfield and "
                           + "the garfieldJr objects do not have logical (deep)"
                           + " equality.");

    System.out.println("\nAs expected, the equals override worked "
                       + "correctly because the cats have different names."
                       + "\n\nNow let's use the Cat name setter to change "
                       + "the garfieldJr name field to \n\"Garfield.\""
                       + "That will test the other branch of the equals "
                       + "override.");

    garfieldJr.setName("Garfield");
    if (garfield.equals(garfieldJr))
        System.out.println("\nThe equals method says that the garfield object "
                + "and the garfieldJr object \nhave logical (deep) equality.");
    else
        System.out.println("\nThe equals method says that the garfield object "
                + "and the garfieldJr object \ndo not have logical (deep) "
                + "equality.");

    System.out.println("\nAs expected, the equals override worked "
                       + "correctly because now the cats have \nexactly the "
                       + "same names, ages, and weights.");

    }//End private method void catEqualsTest()
    
    /**
     * Tests the clone method for cat Garfield and its clone.
     */
    private void catCloneTest()
    {
        Pet garfield = listOfPets[0];
        
        System.out.println("\n*****************************************"
                + "\nThis is a test of the Cat clone override.\n"
                + "\nLet's clone Garfield. Here's the code to create the "
                + "clone:\n");
                
        String codeText = String.format("%55s", 
                "Cat garfieldClone = ((Cat) listOfPets[0]).clone();");
        
        System.out.println(codeText);
        
        System.out.println("\nNow we'll print out both the garfield object and"
                + " the garfieldClone object so that we can see that both "
                + "cats have the same name, age, and weight. Then, \nwe'll use "
                + "the equals method to prove that they are the same.\n");
        
        Cat garfieldClone = ((Cat) listOfPets[0]).clone();
        
        System.out.println("This is the garfield object: ");
        System.out.println(garfield.toString());
        System.out.println("\nThis is the garfieldClone object: ");
        System.out.println(garfieldClone.toString() + "\n");
    
        System.out.println("Let's use the equals method to verify: \n");
        
        if (garfield.equals(garfieldClone))
        System.out.println("The garfield and garfieldClone objects are "
                + "logically equal.\n");
        else
        System.out.println("The garfield and garfieldClone objects are not "
                + "logically equal.\n");
    } //End of catCloneTest method
    
    /**
     * Tests the equals method for dog Odie and his copy.
     */
    private void dogEqualsTest()            
    {
    Pet odie = listOfPets[3];
    Pet odieCopy = new Dog((Dog)odie);
    
    System.out.println("\n*****************************************"
                       + "\nThis is a test of the Dog equals override:");;
    
    if (odie.equals(odieCopy))
        System.out.println("The odie and odieCopy objects are logically"
                + " (deep) equal.\n");
    else
        System.out.println("The odie and odieCopy objects are not logically"
                + " (deep) equal.\n");
    }//End private method void dogEqualsTest()
    
    /**
     * Tests the clone method for dog Odie and his clone.
     */
    private void dogCloneTest()
    {
        Pet odie = listOfPets[3];
        
        System.out.println("\nThis is a test of the Dog clone override:");
       
        Dog odieClone = ((Dog) listOfPets[3]).clone();
        
        if (odie.equals(odieClone))
        System.out.println("The odie and odieClone objects are logically"
                + " equal.\n");
        else
        System.out.println("The odie and odieClone objects are not logically"
                + " equal.\n");   
    } //End of dogCloneTest method

} //End of PA4Delegate class

/** CPS 202
 * Spring 2021
 * Gabriela Calderon
 * 
 * Copyright 2021 Gabriela Calderon
*/

package pa1pet;
/**
 Class for basic pet records: type, name, age, and weight.
*/
/** File name:   PA1Calderon.java
* <p>
* Description: Program that modifies a vet's office database and
*              tests calculations of drug doses for pets. SOlves
*              project 10, Savitch, Walter. 2016. Absolute Java. 6th ed.
*              Boston: Addison-Wesley, Chapter 4, page 255-256.
* <p>
* @author Gabriela Calderon gcaldero@heidelberg.edu
* @version 1-Feb-2021
*/
public class PA1Calderon
{
    
    // These are instance fields.
    private String name;
    private int age;//in years
    private double weight;//in pounds
    private String petType;//This is the new petType field introduced.
    private double mgPerKg;//this is used to make the drug dosage calculations
    
    //THESE ARE ALL CONSTRUCTORS
    
    /*
    This constructor is used to iniciate the initialName and 
    initialPetType variables.
    */
    public PA1Calderon(String initialName, String initialPetType)
    {
        petType = initialPetType;
        name = initialName;
        age = 0;
        weight = 0;
    } 
    
    //this constructor is used to initiate the initialAge variable
    public PA1Calderon(int initialAge)
    {
        petType = "No pet type yet";
        name = "Name not entered";
        weight = 0;
        if (initialAge < 0)
        {
            System.out.println("Error: Negative age.");
            System.exit(0);
        }
        else
            age = initialAge;
    }
    
    // This constructor is used to initiate the initialWeight variable.
    public PA1Calderon(double initialWeight)
    {
        petType = "No pet type yet";
        name = "Name not entered";
        age = 0;
        if (initialWeight < 0)
        {
            System.out.println("Error: Negative weight.");
            System.exit(0);
        }
        else
            weight = initialWeight;
    }

    // This is a no-argument constructor.
    public PA1Calderon( )
    {
        petType = "No pet type yet";
        name = "Name not entered";
        age = 0;
        weight = 0;   
    }
    
    /*
    This constructor is used to check if the instance fields are
    appropriate for the code.
    */
    public PA1Calderon(String initialPetType, String initialName, 
            int initialAge, double initialWeight)
    {
        petType = initialPetType;
        name = initialName;
        if ((initialAge < 0) || (initialWeight < 0))
        {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        }
        else
        {
            age = initialAge;
            weight = initialWeight;
        }
    }
    //These is the end of all constructors
    //THESE ARE ALL METHODS
    // setter methods
    
    // This setter method is used to change the value of name.
    public void setName(String newName)
    {
        name = newName; 
    }
    // This is the end of the setName setter method.
    
    // This setter method is used to change the value of age.
    public void setAge(int newAge)
    {
        if (newAge < 0)
        {
            System.out.println("Error: Negative age.");
            System.exit(0);
        }
        else
            age = newAge;
    }
    // This is the end of the setAge setter method.
    
    //this setter method is used to change the value of weight
    public void setWeight(double newWeight)
    {
        if (newWeight < 0)
        {
            System.out.println("Error: Negative weight.");
            System.exit(0);
        }
        else
            weight = newWeight;
    }
    // This is the end of the setWeight setter method.
    
    // petType setter method
    /*
    This setter method is used to change the value of petType, as well as
    check if the pet type is dog or cat.
    */
    public void setPetType(String newPetType)
    {
        if (newPetType.equalsIgnoreCase("dog"))
            petType = newPetType;
        else if (newPetType.equalsIgnoreCase("cat"))
            petType = newPetType;
    } 
    // This is the end of the setPetType setter.
    
    // Setter method
    // This setter method is used to set the value of all instance fields.
    public void set(String newPetType, String newName,
            int newAge, double newWeight)
    {
        petType = newPetType.toUpperCase();
        name = newName;
        if ((newAge < 0) || (newWeight < 0))
        {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        }
        else
        {
            age = newAge;
            weight = newWeight;
        }
    }
    //This is the end of the setter method.
    
    //first drug method
    /*
    This method is used to calculate the drug usage of Acepromazine depending
    on wheter the pet is a dog or a cat, as well as the weight.
    */
    public double getAcepromazine(double acepromazineDosage)
    {
        mgPerKg = 0;
        if (petType.equalsIgnoreCase("dog"))
            mgPerKg = 0.03;
        else if (petType.equalsIgnoreCase("cat"))
            mgPerKg = 0.002;
        
        acepromazineDosage = (weight / 2.2) * (mgPerKg / 10);
        
        return acepromazineDosage;
    }            
    // This is the end of the getAcepromazine method.
    
    //second drug method
    /*
    This method is used to calculate the druge usage of Carprofen depending on
    wheter the pet is a dog or a cat, as well as the weight.
    */
    public double getCarprofen(double carprofenDosage)
    {
        
        mgPerKg = 0;
        if (petType.equalsIgnoreCase("dog"))
            mgPerKg = 0.5;
        else if (petType.equalsIgnoreCase("cat"))
            mgPerKg = 0.25;
        
        carprofenDosage = (weight / 2.2) * (mgPerKg / 12);
        
        return carprofenDosage;
                
    }
    // This is the end of the getCarprofen method.
    
    /*
    These are all getter methods. Ther are used so the Main Class 
    can access these instance fields.
    */
    public String getName( )
    {
        return name;
    }

    public int getAge( )
    {
        return age;
    }

    public double getWeight( )
    {
        return weight;
    }
    
    public String getPetType()
    {
        return petType;
    }
    //this is the end of all the getter methods
    
    /*
    One of the changes to the original code was moving the toString() method
    to the bottom of the code.
    This method is used to print out all the instance fields and their values
    during the tests at the Main Class.
    */ 
    public String toString( )
    {
        String petTypeText = "Pet type:";
        String nameText = "Name:";
        String ageText = "Age:";
        String weightText = "Weight:";
        
        return String.format("%-10s %-10s%n%-10s %-10s%n%-10s"
                             + " %-1d years%n%-10s %-2.1f pounds %n",
                             petTypeText,petType, nameText, name,
                             ageText, age,weightText, weight);
        
    }
    // this is the end of the toString() method.
}

/**
 * @author Gabriela Calderon
 * CPS 202
 * Intermediate computer programming
 */

package pa3pet;

public abstract class Pet {
    /**
     * Description: this class initializes the variables and creates the
     *              methods that are later overridden.
     */
    //------------instance fields-------------
    
    public String name;   
    public int age;
    public double weight;
    
    //------------constructors----------------
    
    /**
     * No-arg constructor
     */
    public Pet()
    {
        name = "No name yet";
        age = 0;
        weight = 0;
    } //End of no-arg constructor
        
    /**
     * Three-arg constructor
     */
    public Pet(String initialName, int initialAge, double initialWeight)
    {
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
    } // End of three-arg constructor.
    
    public Pet(String initialName)
    {
        name = initialName;
        age = 0;
        weight = 0;
    } // End of initialName constructor
    
    public Pet(int initialAge)
    {
        name = "No name yet.";
        weight = 0;
        if (initialAge < 0)
        {
            System.out.println("Error: Negative age.");
            System.exit(0);
        }
        else
            age = initialAge;
    } // End of initialAge constructor
    
    public Pet(double initialWeight)
    {
        name = "No name yet";
        age = 0;
        if (initialWeight < 0)
        {
            System.out.println("Error: Negative weight.");
            System.exit(0);
        }
        else
            weight = initialWeight;
    } // End of initialWeight constructor
    
    //--------------methods-------------------
    
    //THESE ARE THE GETTERS
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
    
    //THESE ARE THE SETTERS
    public void setName(String newName)
    {
        name = newName; 
    }
    
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
    
    public void set(String newName, int newAge, double newWeight)
    {
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
    /*
    Display header method.
    */ 
    public String displayHeader()
    {
        return("\n\t\tTEST OF VETINARY PET CLASS WITH INHERITANCE\n\n"
                + "Gabriela Calderon\n"
                + "February 24, 2021\n\n"
                + "This program tests drug dosage calculations based "
                + "on a cat or dog Pet type.\n\n"
                + "\n\tPET DRUG DOSAGE REPORT\n\n"
                + "Our records now say that the family pet is "
                + "registered as follows:\n");
    } //End of displayHeader method
    
    //first drug method
    /*
    This method is used to calculate the drug usage of Acepromazine depending
    on wheter the pet is a dog or a cat, as well as the weight.
    */
    public double getAcepromazine()
    {
        return 0;
    }            
    // This is the end of the getAcepromazine method.
    
    //second drug method
    /*
    This method is used to calculate the druge usage of Carprofen depending on
    wheter the pet is a dog or a cat, as well as the weight.
    */
    public double getCarprofen()
    {        
        return 0;                
    } // This is the end of the getCarprofen method
    
    //toString method

    /**
     * @Override
     */
    @Override
    public String toString()
    {                
        return ("");
    } //End of toString() method
    
    //equals method
    /*
    @param otherObject The Pet object being compared for deep equality
    @return            true or false
    */    
    @Override
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) //reflexive/self-intentity check
            return true;
        if (otherObject == null) //null check
            return false;                       
        if (getClass() != otherObject.getClass())
            return false;
        
        final Pet tempPet = (Pet) otherObject;
        return (this.age == tempPet.age
                && Double.valueOf(weight).equals(tempPet.weight)
                && this.name.equals(tempPet.name));     
        
    } //End of equals method
    
} //End of Pet class
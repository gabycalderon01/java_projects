/*
 * CPS 202
 * Spencer Kaup, Gabriela Calderon
 * 30 February 2021
 */

package pa4abstractpet;

/**
 * File name:     Pet.java <p>
 * Description:   Programming Project 8, Savitch 6e, Ch. 8, p. 520.
 *                <p>
 *                This class acts as the base pet data model.
 * 
 * Savitch, Walter. 2016. Absolute Java, 6th Edition. Essex: Pearson Education 
 *    Limited.
 * 
 * @author Spencer Kaup skaup@heidelberg.edu & 
 *         Gabriela Calderon gcaldero@heidelberg.edu
 * @revision 3rd March 2021
 */

/**
 Class for basic pet records: name, age, and weight.
*/
public abstract class Pet
{
    // ----------instance fields-----------
    private String name;
    private int age;//in years
    private double weight;//in pounds

    // ------constructors-------
    public Pet( )
    {
        name = "No name yet.";
        age = 0;
        weight = 0; 
    }
    
    public Pet(String initialName, int initialAge, 
                                          double initialWeight)
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
    }

    public Pet(String initialName)
    {
        name = initialName;
        age = 0;
        weight = 0;
    }  

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
    }

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
    }
    //End of constructors
    
    //-----------getters----------------
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
    //end of getters
    
    //------------setters-------------
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
    //end of setters
    
    //-------------methods---------------
    /**
     * toString() method
     * @return 
     */
    @Override
    public String toString ()
    {
        return (super.toString()
                + "\nPet Type: Dog");
    } //end public String toString()
        
    /**
     * Compares this object with another to see if they are the same.
     * @param otherObject The object to compare.
     * @return Whether or not the objects are the same.
     */
    @Override
    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass() != otherObject.getClass())
        {
            return false;
        }
        else
        {
            Pet otherPet = (Pet)otherObject;
            return (this.getName().equals(otherPet.getName())
                    && this.getAge() == otherPet.getAge()
                    && this.getWeight() == otherPet.getWeight());
        }
    } //end of equals method
    
    /**
     * Acepromazine method. Empty for now because it is abstract.
     * @return 
     */
    public abstract double acepromazine();
    
    /**
     * Carprofen method. Empty for now because it is abstract.
     * @return 
     */
    public abstract double carprofen();
}

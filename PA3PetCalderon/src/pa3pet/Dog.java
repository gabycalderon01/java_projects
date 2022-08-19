/**
 * @author Gabriela Calderon
 * CPS 202
 * Intermediate computer programming
 */
package pa3pet;
/**
 * Description: the cat class overrides the methods from the Pet class and
 *              describes the pet as a dog.
 */
public class Dog extends Pet
{
    
    //------------instance fields------------- 
    public double carprofenDosage = 0;
    public double acepromazineDosage = 0;
    
    //------------constructors----------------
    
    //No-arg constructor that calls the parent's no-arg constructor
    public Dog()
    {
        super();
    } //End of no-arg constructor.
    
    
    //3 arg cosntructor that calls the parent's 3 arg constructor
    public Dog(String initialName, int initialAge, double initialWeight)
    {
        super(initialName, initialAge, initialWeight);
        
    } //End of 3-arg constructor
    
    //Copy constructor   
    public Dog(Dog original)
    {
        name = original.name;
        age = original.age;
        weight = original.weight;
    } // End of copy constructor
    
    //--------------methods-------------------
    //THESE ARE THE GETTERS
    public String getDogName()
    {
        return name;
    }
    public int getDogAge()
    {
        return age;
    }
    public double getDogWeight()
    {
        return weight;
    }
    
    //THESE ARE THE SETTERS   
    @Override
    public void set(String name, int age, double weight)
    {
        name = "Bob";
        age = 4;
        weight = 8.0;
    }
    
    //Override for getAcepromazine() method
    /**
     * @Override
     */
    @Override
    public double getAcepromazine()
    {
        return (this.getWeight() / 2.2) * (0.03 / 10);        
    } //End of override for getAcepromazine() method
    
    //Override for getCarprofen() method
    /**
     * @Override
     */
    @Override
    public double getCarprofen()
    {
        return (this.getWeight() / 2.2) * (0.5 / 10);
        
    } //End of getCarprofen() method override
    
    //toString method
    @Override
    public String toString()
    {       
        String text = String.format((displayHeader() + "Pet type: Dog"
                + "\nName: " + this.getName() + "\nAge: " + this.getAge()
                + " years" + "\nWeight: " + this.getWeight() + " pounds"
                + "\nDose of carprofen: %.4f ml." 
                + "\nDose of acepromazine: %.4f ml."), 
                this.getCarprofen(), this.getAcepromazine());
        
        return text;
    } //End of toString() override

    //equals method
    @Override
    public boolean equals (Object otherObject)
    {
	/*if (!super.equals(otherObject))
		return false;
	else
		return true;
                */
        if (otherObject == null)
            return false;
        else if (getClass() != otherObject.getClass())
        {
            return false;
        }
        else
        {
            Dog otherDog = (Dog)otherObject;
            return (this.getName().equals(otherDog.getName())
                    && this.getAge() == otherDog.getAge()
                    && this.getWeight() == otherDog.getWeight());
        }
    
    } //End of equals() override
    
} //End of Dog class
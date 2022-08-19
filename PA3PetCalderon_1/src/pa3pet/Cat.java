/**
 * @author Gabriela Calderon
 * CPS 202
 * Intermediate computer programming
 */
package pa3pet;
/**
 * Description: the cat class overrides the methods from the Pet class and
 *              describes the pet as a cat.
 */
public class Cat extends Pet
{
    // -----------instance fields-------------    
    public double carprofenDosage = 0;
    public double acepromazineDosage = 0;
    //------------constructors----------------
    
    //No-arg constructor that calls the parent's no-arg constructor
    public Cat()
    {
        super();
    } //End of no-arg constructor.
    
    //3 arg cosntructor that calls the parent's 3 arg constructor
    public Cat(String initialName, int initialAge, double initialWeight)
    {
        super(initialName, initialAge, initialWeight);
        
    } //End of 3-arg constructor
    
    //Copy constructor
    public Cat(Cat otherCat)
    {
        this.setName(otherCat.getName());
        this.setAge(otherCat.getAge());
        this.setWeight(otherCat.getWeight());
    } //End of copy constructor
    
    
    //--------------methods-------------------
    
    //Getters for instance fields
    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }            
    
    public double getWeight()
    {
        return weight;
    }
    /*
    public String getPetType()
    {
        return petType;
    }
    */
    
    //Setters for instance fields
    
    public void setName(String newName)
    {                        
        this.name = newName; 
    }
    
    public void setAge (int newAge)
    {
        this.age = newAge;
    }
    
    public void setWeight(double newWeight)
    {
        this.weight = newWeight;
    }
 
    //Override for acepromazine() method
    /**
     * @Override
     */
    @Override
    public double getAcepromazine()
    {
        double acepromazineDosage = (weight / 2.2) * (0.002 / 10);
        
        return acepromazineDosage;
    } //End of override of getAcepromazine()
    
    //Override for carprofen() method
    /**
     * @Override
     */
    @Override
    public double getCarprofen()
    {
        double carprofenDosage = (weight / 2.2) * (0.25 / 12);
        
        return carprofenDosage;
    } //End of getCarprofen() override
    
    //toString method
    @Override
    public String toString()
    {    
        String text = String.format((displayHeader() + "Pet type: Cat"
                + "\nName: " + this.getName() + "\nAge: " + this.getAge()
                + " years" + "\nWeight: " + this.getWeight() + " pounds"
                + "\nDose of carprofen: %.4f ml." 
                + "\nDose of acepromazine: %.4f ml."), 
                this.getCarprofen(), this.getAcepromazine());
        
        return text;
    } //End of toString() method override
    
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
            Cat otherCat = (Cat)otherObject;
            return (this.getName().equals(otherCat.getName())
                    && this.getAge() == otherCat.getAge()
                    && this.getWeight() == otherCat.getWeight());
        } 

    } //End of toString() method override

} //End of Cat class
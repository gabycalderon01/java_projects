/*
 * CPS 202
 * Spencer Kaup, Gabriela Calderon
 * 30 February 2021
 */
package pa4abstractpet;

/**
 * File name:     Cat.java <p>
 * Description:   Programming Project 8, Savitch 6e, Ch. 8, p. 520.
 *                <p>
 *                This class extends the pet class.
 * 
 * Savitch, Walter. 2016. Absolute Java, 6th Edition. Essex: Pearson Education 
 *    Limited.
 * 
 * @author Spencer Kaup skaup@heidelberg.edu & 
 *         Gabriela Calderon gcaldero@heidelberg.edu
 * @revision 3rd March 2021
 */
public class Cat extends Pet {
    
    //----------constructors-----------
    
    /**
     * No-arg constructor calls Pet constructor.
     */
    public Cat()
    {
        super();
    } //End of no-arg constructor
    
    /**
     * Three argument constructor calls Pet constructor.
     * 
     * @param initialName The pet's name
     * @param initialAge The pet's age
     * @param initialWeight The pet's weight
     */    
    public Cat(String initialName, int initialAge, 
                                        double initialWeight)
    {
        super(initialName, initialAge, initialWeight);
    } //End of three arg constructor
    
    /**
     * Cat constructor copies data from another Cat object.
     * @param otherCat The Cat object to copy from.
     */
    public Cat(Cat otherCat)
    {
        this.setName(otherCat.getName());
        this.setAge(otherCat.getAge());
        this.setWeight(otherCat.getWeight());
    } //End of copy constructor
    
    //------------methods-------------
    
    /**
     * Compares this object with another to see if they are the same.
     * @param otherObject The object to compare.
     * @return Whether or not the objects are the same.
     */
    @Override
    public boolean equals(Object otherObject)
    {
        return super.equals(otherObject);
    } //End of equals method override
    
    /**
     * Outputs the pet data as a string.
     * @return The pet data.
     */
    @Override
    public String toString()
    {
        return String.format(("%-14s %-14s%n%-14s %-14s%n%-14s"
                             + " %-1d years%n%-14s %-3.1f pounds"),
                             "Pet type: ","Cat", "Name: ", this.getName(),
                             "Age: ", this.getAge(), "Weight: ",
                             this.getWeight());
    } //End of toString method override
    
    /**
     * Returns a copy of this object.
     * @return A copy of this object.
     */
    @Override
    public Cat clone()
    {
        return new Cat(this);
    } //End of clone override method
    
    /**
     * Returns an integer hashcode unique to this object.
     * @return This object's hashcode.
     */
    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 89 * hash + (this.getName() != null ? 
                this.getName().hashCode() : 0);
        hash = 89 * hash + this.getAge();
        hash = 89 * hash + (int) ((byte) (this.getWeight()) >>> 32);
        return hash;
    } //End of hashCode method override
    
    /**
     * Calculates the proper dosage of acepromazine.
     * @return The dosage.
     */
    @Override
    public double acepromazine()
    {
        return (this.getWeight() / 2.2) * (0.002 / 10);
    } //End of acepromazine method override
    
    /**
     * Calculates the proper dosage of carprofen.
     * @return The dosage.
     */
    @Override
    public double carprofen()
    {
        return (this.getWeight() / 2.2) * (0.25 / 12);
    } //End of carprofen method override
}

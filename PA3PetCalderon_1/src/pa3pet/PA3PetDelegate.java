/**
 * @author Gabriela Calderon
 * CPS 202
 * Intermediate computer programming
 */
package pa3pet;
/**
 * Description: the delegate class handles all I/O.
 */
public class PA3PetDelegate extends Pet
{
    PA3PetDelegate()
    {
        Cat bob;
        
        bob = new Cat("Bob", 4, 8.0);
        Pet alice = new Cat((Cat)bob);
        
        System.out.println(alice.toString());
        
        Pet tom = new Dog("Tom", 5, 40); //test dog
        
        //System.out.println(tom.toString());
        
        if (bob.equals(alice))
            System.out.println("\nBob and Alice are logically the same");
        else
            System.out.println("\nBob and Alice are logically different");
    }
} //End of delegate class

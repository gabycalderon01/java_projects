/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa2feb5bohlen;

/**
 * File name:    Card.java <p>
 * Description:  Programming Project 2, Savitch 6e, Ch. 6, p. 419.
 *               <p>
 *               This class is a data model that stores the information for 
 *               each card.
 * 
 * @author Will Bohlen
 * @version 05-Feb-2020
 */
public class Card 
{
    private int value;
    private boolean visible;
    
    /**
     * int constructor creates a new card object.
     * @param value The value the card should hold.
     */
    public Card(int value) 
    {
        this.value = value;
        this.visible = false;
    }
    
    /**
     * Gets the card's value.
     * @return The card's value.
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     * Gets the card's state.
     * @return Whether or not the card is visible.
     */
    public boolean getVisible()
    {
        return visible;
    }
    
    /**
     * Sets the card's state.
     * @param visible Whether or not the card is visible.
     */
    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }
    
    /**
     * Checks to see if two cards have the same value.
     * @param otherCard The other card to compare to.
     * @return Whether or not the cards have the same value.
     */
    public boolean equals(Card otherCard) 
    {
        if (otherCard.getValue() == this.value) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}

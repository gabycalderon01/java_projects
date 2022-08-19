/*
 * CPS 202
 * Spring 2020
 * Will Bohlen
 */
package pa2feb5bohlen;

/**
 * File name:    GameController.java <p>
 * Description:  Programming Project 2, Savitch 6e, Ch. 6, p. 419.
 *               <p>
 *               This class is a data model that stores the game board
 *               and updates it with new information.
 * 
 * @author Will Bohlen
 * @version 05-Feb-2020
 */
public class MemoryBoard 
{
    private Card[][] boardArray; // Stores the cards.
    private int boardWidth;
    private int boardHeight;
    private float startingValue = 1;
    private int firstX;
    private int firstY;
    private int secondX;
    private int secondY;
    private Card tempCard; // For swapping
    
    /**
     * No-arg constructor that generates a 4x4 board. 
     */
    public MemoryBoard()
    {
        boardWidth = 4;
        boardHeight = 4;
        
        createBoard();
    }
    
    /**
     * Sets the board size, then populates and shuffles it.
     */
    private void createBoard()
    {
        boardArray = new Card[boardWidth][boardHeight];
        
        populateBoard();
        shuffleCards();
    }
    
    /**
     * Populates the board with cards.
     */
    private void populateBoard() 
    {
        for (int x = 0; x < boardWidth; x++)
        {
            for (int y = 0; y < boardHeight; y++)
            {
                boardArray[x][y] = new Card((int)startingValue);
                startingValue += 0.5;
            }
        }
    }
    
    /**
     * Shuffles all of the cards on the board.
     */
    private void shuffleCards()
    {
        for (int pass = 0; pass < 99999; pass++)
        {
            // Choose two random sets of coordinates
            firstX = (int)(Math.random() * boardWidth);
            firstY = (int)(Math.random() * boardHeight);
            secondX = (int)(Math.random() * boardWidth);
            secondY = (int)(Math.random() * boardHeight);
            
            // Swap the cards in those positions
            tempCard = boardArray[firstX][firstY];
            boardArray[firstX][firstY] = boardArray[secondX][secondY];
            boardArray[secondX][secondY] = tempCard;
        }
    }
    
    /**
     * Gets a card at a specific index.
     * @param index the card's position on the board, from 1 to 16.
     * @return The Card object at the target coordinate.
     */
    public Card getCard(int index)
    {
        int x = index / 4; // Integer division to get x coord
        int y = index % 4; // Modulo to get y coord 
        return boardArray[x][y];
    }
    
    /**
     * Checks if all the cards on the board have been revealed.
     * @return Whether or not all cards have been revealed.
     */
    public boolean checkWin() 
    {
        for (int x = 0; x < boardWidth; x++)
        {
            for (int y = 0; y < boardHeight; y++)
            {
                // If we find any unflipped cards, we haven't won.
                if (!boardArray[x][y].getVisible())
                {
                    return false;
                }
            }
        }
        // Only executes if no unflipped cards are found, so must be a win.
        return true;
    }
}

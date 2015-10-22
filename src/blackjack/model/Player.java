
package blackjack.model;

import java.util.*;

/**
 * The Class Player.
 *
 */
public class Player
{
    
    /** The name. */
    private String name;
    
    /** The chip. */
    private int chip;
    
    /** The win. */
    private int win;
    
    /** The lose. */
    private int lose;
    
    /** The push. */
    private int push;
    
    /** The bet. */
    private int[] bet;
    
    /** The hand one. */
    private ArrayList<Integer> handOne;
    
    /** The hand two. */
    private ArrayList<Integer> handTwo;
    
    /**
     * Instantiates a new player.
     *
     * @param isPlayer true if this is a player not a dealer
     */
    public Player(boolean isPlayer)
    {
        this.name = isPlayer?"":"Dealer";
        this.chip = isPlayer?0:-1;
        this.win = isPlayer?0:-1;
        this.lose = isPlayer?0:-1;
        this.push = isPlayer?0:-1;
        this.bet = new int[2];
        this.bet[0] = isPlayer?0:-1;
        this.bet[1] = isPlayer?0:-1;
        this.handOne = new ArrayList<>();
        this.handTwo = isPlayer?new ArrayList<>():null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Name: " + name + " | Chips: " + chip + " | Win: " + win + " | Lose: " + lose + " | Push: " + push;
    }
    
    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Gets the hand one.
     *
     * @return the hand one
     */
    public ArrayList<Integer> getHandOne()
    {
	return this.handOne;
    }
    
    /**
     * Gets the hand two.
     *
     * @return the hand two
     */
    public ArrayList<Integer> getHandTwo()
    {
        return this.handTwo;
    }
    
    /**
     * Gets the chip.
     *
     * @return the chip
     */
    public int getChip()
    {
	return this.chip;
    }
    
    /**
     * Sets the chip.
     *
     * @param chip the new chip
     */
    public void setChip(int chip)
    {
	this.chip = chip;
    }
    
    /**
     * Adds the win.
     */
    public void addWin()
    {
	this.win++;
    }
    
    /**
     * Adds the lose.
     */
    public void addLose()
    {
	this.lose++;
    }
    
    /**
     * Adds the push.
     */
    public void addPush()
    {
	this.push++;
    }
    
    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Gets the win.
     *
     * @return the win
     */
    public int getWin()
    {
        return this.win;
    }
    
    /**
     * Sets the win.
     *
     * @param win the new win
     */
    public void setWin(int win)
    {
        this.win = win;
    }
    
    /**
     * Gets the lose.
     *
     * @return the lose
     */
    public int getLose()
    {
        return this.lose;
    }
    
    /**
     * Sets the lose.
     *
     * @param lose the new lose
     */
    public void setLose(int lose)
    {
        this.lose = lose;
    }
    
    /**
     * Gets the push.
     *
     * @return the push
     */
    public int getPush()
    {
        return this.push;
    }
    
    /**
     * Sets the push.
     *
     * @param push the new push
     */
    public void setPush(int push)
    {
        this.push = push;
    }
    
    /**
     * Gets the bet.
     *
     * @param whichHand the which hand
     * @return the bet
     */
    public int getBet(int whichHand)
    {
        return this.bet[whichHand];
    }
    
    /**
     * Sets the bet.
     *
     * @param whichHand the which hand
     * @param bet the bet
     */
    public void setBet(int whichHand, int bet)
    {
        this.bet[whichHand] = bet;
    }
    
    /**
     * Sets the bet.
     *
     * @param bet the new bet
     */
    public void setBet(int bet)
    {
        this.bet[0] = bet;
        this.bet[1] = bet;
    }
}

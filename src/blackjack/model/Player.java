/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.model;

import java.util.*;
/**
 *
 * @author Chad
 */
public class Player
{
    private String name;
    private int chip;
    private int win;
    private int lose;
    private int push;
    private int[] bet;
    private ArrayList<Integer> handOne;
    private ArrayList<Integer> handTwo;
    
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

    @Override
    public String toString()
    {
        return "Name: " + name + " | Chips: " + chip + " | Win: " + win + " | Lose: " + lose + " | Push: " + push;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public ArrayList<Integer> getHandOne()
    {
	return this.handOne;
    }
    
    public ArrayList<Integer> getHandTwo()
    {
        return this.handTwo;
    }
    
    public int getChip()
    {
	return this.chip;
    }
    
    public void setChip(int chip)
    {
	this.chip = chip;
    }
    
    public void addWin()
    {
	this.win++;
    }
    
    public void addLose()
    {
	this.lose++;
    }
    
    public void addPush()
    {
	this.push++;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getWin()
    {
        return this.win;
    }
    
    public void setWin(int win)
    {
        this.win = win;
    }
    
    public int getLose()
    {
        return this.lose;
    }
    
    public void setLose(int lose)
    {
        this.lose = lose;
    }
    
    public int getPush()
    {
        return this.push;
    }
    
    public void setPush(int push)
    {
        this.push = push;
    }
    
    public int getBet(int whichHand)
    {
        return this.bet[whichHand];
    }
    
    public void setBet(int whichHand, int bet)
    {
        this.bet[whichHand] = bet;
    }
    
    public void setBet(int bet)
    {
        this.bet[0] = bet;
        this.bet[1] = bet;
    }
}

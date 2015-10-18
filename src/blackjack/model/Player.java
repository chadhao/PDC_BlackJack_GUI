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
    private ArrayList<ArrayList<Integer>> inHand;
    private boolean isInsured;
    private boolean[] isDoubled;
    private boolean isSplit;
    
    public Player(String name, int chip, int win, int lose, int push)
    {
        this.name = name;
        this.chip = chip;
        this.win = win;
        this.lose = lose;
        this.push = push;
        this.isInsured = false;
        this.isDoubled = new boolean[2];
        this.isDoubled[0] = false;
        this.isDoubled[1] = false;
        this.isSplit = false;
        this.inHand = new ArrayList<ArrayList<Integer>>();
    }
    
    public Player(String name, int chip)
    {
        this.name = name;
        this.chip = chip;
        this.win = 0;
        this.lose = 0;
        this.push = 0;
        this.isInsured = false;
        this.isDoubled = new boolean[2];
        this.isDoubled[0] = false;
        this.isDoubled[1] = false;
        this.isSplit = false;
        this.inHand = new ArrayList<ArrayList<Integer>>();
    }
    
    public Player()
    {
        this.name = "Dealer";
        this.chip = -1;
        this.win = -1;
        this.lose = -1;
        this.push = -1;
        this.isInsured = false;
        this.isDoubled = new boolean[2];
        this.isDoubled[0] = false;
        this.isDoubled[1] = false;
        this.isSplit = false;
        this.inHand = new ArrayList<ArrayList<Integer>>();
    }
    
    public String toString()
    {
        return "\nName: " + this.name + "\nChips: " + this.chip + "\nWin: " + this.win
                + "\nLose: " + this.lose + "\nPush: " + this.push + "\n";
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public ArrayList<ArrayList<Integer>> getInHand()
	{
		return this.inHand;
	}
    
    public boolean isDoubled(int whichHand)
	{
		return this.isDoubled[whichHand];
	}
    
    public boolean isInsured()
	{
		return this.isInsured;
	}
    
    public boolean isSplit()
	{
		return this.isSplit;
	}
    
    public int getChip()
	{
		return this.chip;
	}
    
    public void setChip(int chip)
	{
		this.chip = chip;
	}
    
    public void setDoubled(boolean isDoubled)
	{
		this.isDoubled[0] = isDoubled;
		this.isDoubled[1] = isDoubled;
	}
    
    public void setDoubled(int whichHand, boolean isDoubled)
    {
    	this.isDoubled[whichHand] = isDoubled;
    }
    
    public void setInsured(boolean isInsured)
	{
		this.isInsured = isInsured;
	}
    
    public void setSplit(boolean isSplit)
	{
		this.isSplit = isSplit;
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
}

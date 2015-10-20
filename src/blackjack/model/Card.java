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
public class Card {
    public static final int NUM_OF_SET = 1;
    private static final String[] SUIT = {"S", "H", "C", "D"};
    private static final String[] RANK = {"2", "3", "4", "5", "6",
        "7", "8", "9", "T", "J", "Q", "K", "A"};
    public static HashMap power = new HashMap();
    private static String[] card = new String[52*Card.NUM_OF_SET];
    private static int cardNow;
    
    static
    {
        for (int i = 0; i < 13; i++)
        {
            if (i < 8)
            {
                power.put(RANK[i], i+2);
            }
            else if (i == 12)
            {
                power.put(RANK[i], 11);
            }
            else
            {
                power.put(RANK[i], 10);
            }
        }
        
        for (int i = 0; i < NUM_OF_SET; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                for (int k = 0; k < 13; k++)
                {
                    card[i*52+j*13+k] = RANK[k] + SUIT[j];
                }
            }
        }
        
        cardNow = 0;
    }
    
    public static void shuffleCards()
    {
        int r;
        Random rand = new Random();
        String temp;
        
        for (int i = 0; i < 52*NUM_OF_SET; i++)
        {
            r = rand.nextInt(52*NUM_OF_SET);
            temp = card[i];
            card[i] = card[r];
            card[r] = temp;
        }
        cardNow = 0;
    }
    
    public static String getCard(int index)
    {
        return card[index];
    }
    
    public static int getValue(int index)
    {
        return (int)power.get(String.valueOf(getCard(index).charAt(0)));
    }
    
    public static int dealCard()
    {
        return ++cardNow-1;
    }
    
    public static int getCardNow()
    {
        return cardNow;
    }
}
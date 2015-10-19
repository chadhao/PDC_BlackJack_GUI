/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Chad
 */
public class GamePanel extends BasePanel
{
    private ArrayList<String> dealerInHand;
    private ArrayList<String> playerInHandOne;
    private ArrayList<String> playerInHandTwo;
    private ArrayList<CardPanel> dealerCards;
    private ArrayList<CardPanel> playerCardsOne;
    private ArrayList<CardPanel> playerCardsTwo;
    private CardDeckContainer dealerDeckPanel;
    private CardDeckContainer playerDeckOnePanel;
    private CardDeckContainer playerDeckTwoPanel;
    private JPanel gameStatPanel;
    private JPanel gameButtonPanel;
    
    public GamePanel()
    {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        dealerInHand = new ArrayList<>();
        dealerInHand.add("2C");
        dealerInHand.add("2D");
        dealerInHand.add("2H");
        dealerInHand.add("2S");
        dealerInHand.add("JD");
        dealerInHand.add("KS");
        
        playerInHandOne = new ArrayList<>();
        playerInHandOne.add("3C");
        playerInHandOne.add("3D");
        playerInHandOne.add("3H");
        playerInHandOne.add("3S");
        playerInHandOne.add("JD");
        playerInHandOne.add("KS");
        
        playerInHandTwo = new ArrayList<>();
        playerInHandTwo.add("4C");
        playerInHandTwo.add("4D");
        playerInHandTwo.add("4H");
        playerInHandTwo.add("4S");
        playerInHandTwo.add("JD");
        playerInHandTwo.add("KS");
        
        dealerCards = new ArrayList<>();
        for (int i = 0; i < dealerInHand.size(); i++)
        {
            dealerCards.add(new CardPanel("img/cards/" + dealerInHand.get(i) + ".png"));
        }
        
        playerCardsOne = new ArrayList<>();
        for (int i = 0; i < playerInHandOne.size(); i++)
        {
            playerCardsOne.add(new CardPanel("img/cards/" + playerInHandOne.get(i) + ".png"));
        }
        
        playerCardsTwo = new ArrayList<>();
        for (int i = 0; i < playerInHandTwo.size(); i++)
        {
            playerCardsTwo.add(new CardPanel("img/cards/" + playerInHandTwo.get(i) + ".png"));
        }
        
        dealerDeckPanel = new CardDeckContainer(new CardDeckPanel(dealerCards));
        playerDeckOnePanel = new CardDeckContainer(new CardDeckPanel(playerCardsOne));
        playerDeckTwoPanel = new CardDeckContainer(new CardDeckPanel(playerCardsTwo));
        
        add(dealerDeckPanel);
        add(playerDeckOnePanel);
        add(playerDeckTwoPanel);
        
    }
    
}

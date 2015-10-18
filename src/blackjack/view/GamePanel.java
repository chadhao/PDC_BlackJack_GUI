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
    private CardDeckPanel dealerDeck;
    private JComponent dealerDeckPanel;
    
    public GamePanel()
    {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        dealerInHand = new ArrayList<>();
        dealerInHand.add("2C");
        dealerInHand.add("2D");
        dealerInHand.add("2H");
        dealerInHand.add("2S");
        
        dealerCards = new ArrayList<>();
        
        for (int i = 0; i < dealerInHand.size(); i++)
        {
            dealerCards.add(new CardPanel("img/cards/" + dealerInHand.get(i) + ".png"));
        }
        
        dealerDeck = new CardDeckPanel(dealerCards);
        
        dealerDeckPanel = new JPanel();

        dealerDeckPanel.setLayout(new FlowLayout());
        dealerDeckPanel.setOpaque(false);
        dealerDeckPanel.add(dealerDeck);
        add(dealerDeckPanel);
        
    }
    
}

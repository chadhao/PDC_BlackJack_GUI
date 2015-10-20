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
import javax.swing.border.*;
import blackjack.*;

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
    private JLabel gameStatPanelPlayerName;
    private JLabel gameStatPanelCurrentChips;
    private JPanel gameButtonPanel;
    private JPanel betButtonPanel;
    private JPanel playButtonPanel;
    
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
        
        gameStatPanel = new JPanel();
        gameStatPanelPlayerName = new JLabel("Player: " + BlackJack.player.getName());
        gameStatPanelCurrentChips = new JLabel("Current chips: " + BlackJack.player.getChip());
        gameStatPanelPlayerName.setFont(new Font("", Font.PLAIN, 14));
        gameStatPanelPlayerName.setForeground(Color.WHITE);
        gameStatPanelPlayerName.setBorder(new EmptyBorder(0, 0, 0, 10));
        gameStatPanelCurrentChips.setFont(new Font("", Font.PLAIN, 14));
        gameStatPanelCurrentChips.setForeground(Color.WHITE);
        gameStatPanelCurrentChips.setBorder(new EmptyBorder(0, 10, 0, 0));
        gameStatPanel.add(gameStatPanelPlayerName);
        gameStatPanel.add(gameStatPanelCurrentChips);
        gameStatPanel.setOpaque(false);
        
        gameButtonPanel = new JPanel(new CardLayout());
        betButtonPanel = new JPanel();
        playButtonPanel = new JPanel();
        JLabel pleaseBet = new JLabel("Please bet: ");
        pleaseBet.setFont(new Font("", Font.PLAIN, 16));
        pleaseBet.setForeground(Color.WHITE);
        betButtonPanel.add(pleaseBet);
        JTextField betField = new JTextField();
        betField.setFont(new Font("", Font.PLAIN, 16));
        betField.setPreferredSize(new Dimension(60, 32));
        betButtonPanel.add(betField);
        JButton betButton = new JButton("bet");
        betButtonPanel.add(betButton);
        betButtonPanel.setOpaque(false);
        JButton hitButton = new JButton("Hit");
        JButton standButton = new JButton("Stand");
        JButton doubleButton = new JButton("Double");
        JButton insureButton = new JButton("Insure");
        insureButton.setEnabled(false);
        JButton splitButton = new JButton("Split");
        splitButton.setEnabled(false);
        playButtonPanel.add(hitButton);
        playButtonPanel.add(standButton);
        playButtonPanel.add(doubleButton);
        playButtonPanel.add(insureButton);
        playButtonPanel.add(splitButton);
        playButtonPanel.setOpaque(false);
//        gameButtonPanel.add("betbutton", betButtonPanel);
        gameButtonPanel.add("playbutton", playButtonPanel);
        gameButtonPanel.setOpaque(false);
        
        add(gameStatPanel);
        add(dealerDeckPanel);
        add(playerDeckTwoPanel);
        add(playerDeckOnePanel);
        add(gameButtonPanel);
    }
    
}

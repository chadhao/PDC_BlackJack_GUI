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
import blackjack.model.*;
import blackjack.controller.*;

/**
 *
 * @author Chad
 */
public class GamePanel extends BasePanel
{
    private static final ArrayList<CardPanel> CARD_BACK = new ArrayList<CardPanel>();
    public static CardDeckContainer dealerDeckContainer;
    public static CardDeckContainer playerDeckOneContainer;
    public static CardDeckContainer playerDeckTwoContainer;
    public static CardDeckPanel dealerDeckPanel;
    public static CardDeckPanel playerDeckOnePanel;
    public static CardDeckPanel playerDeckTwoPanel;
    public static JPanel gameStatPanel;
    public static JLabel gameStatPanelPlayerName;
    public static JLabel gameStatPanelCurrentChips;
    public static JPanel gameButtonPanel;
    public static final CardLayout cardLayout = new CardLayout();
    private JPanel betButtonPanel;
    public static JTextField betField;
    private JPanel playButtonPanel;
    
    public GamePanel()
    {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        CARD_BACK.add(new CardPanel("img/cards/BACK.png"));
        
        //The code below is just for reference
//        dealerCards = new ArrayList<>();
//        for (int i = 0; i < dealerInHand.size(); i++)
//        {
//            dealerCards.add(new CardPanel("img/cards/" + dealerInHand.get(i) + ".png"));
//        }
//        
//        playerCardsOne = new ArrayList<>();
//        for (int i = 0; i < playerInHandOne.size(); i++)
//        {
//            playerCardsOne.add(new CardPanel("img/cards/" + playerInHandOne.get(i) + ".png"));
//        }
//        
//        playerCardsTwo = new ArrayList<>();
//        for (int i = 0; i < playerInHandTwo.size(); i++)
//        {
//            playerCardsTwo.add(new CardPanel("img/cards/" + playerInHandTwo.get(i) + ".png"));
//        }
        //The code above is just for reference
        
        dealerDeckContainer = new CardDeckContainer();
        playerDeckOneContainer = new CardDeckContainer();
        playerDeckTwoContainer = new CardDeckContainer(new CardDeckPanel(CARD_BACK));
        
        gameStatPanel = new JPanel();
        gameStatPanelPlayerName = new JLabel();
        gameStatPanelCurrentChips = new JLabel();
        gameStatPanelPlayerName.setFont(new Font("", Font.PLAIN, 14));
        gameStatPanelPlayerName.setForeground(Color.WHITE);
        gameStatPanelPlayerName.setBorder(new EmptyBorder(0, 0, 0, 10));
        gameStatPanelCurrentChips.setFont(new Font("", Font.PLAIN, 14));
        gameStatPanelCurrentChips.setForeground(Color.WHITE);
        gameStatPanelCurrentChips.setBorder(new EmptyBorder(0, 10, 0, 0));
        gameStatPanel.add(gameStatPanelPlayerName);
        gameStatPanel.add(gameStatPanelCurrentChips);
        gameStatPanel.setOpaque(false);
        
        gameButtonPanel = new JPanel(cardLayout);
        betButtonPanel = new JPanel();
        playButtonPanel = new JPanel();
        JLabel pleaseBet = new JLabel("Please bet: ");
        pleaseBet.setFont(new Font("", Font.PLAIN, 16));
        pleaseBet.setForeground(Color.WHITE);
        betButtonPanel.add(pleaseBet);
        betField = new JTextField();
        betField.setFont(new Font("", Font.PLAIN, 16));
        betField.setPreferredSize(new Dimension(80, 32));
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
        gameButtonPanel.add("betbutton", betButtonPanel);
        gameButtonPanel.add("playbutton", playButtonPanel);
        gameButtonPanel.setOpaque(false);
        
        add(gameStatPanel);
        add(dealerDeckContainer);
        add(playerDeckTwoContainer);
        add(playerDeckOneContainer);
        add(gameButtonPanel);
        
        System.out.println(dealerDeckContainer);
        System.out.println(playerDeckOneContainer);
        
        this.addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentShown(ComponentEvent e)
            {
                Game.initGame();
            }
        });
        
        betField.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                int keyChar = e.getKeyChar();
                if (keyChar < KeyEvent.VK_0 || keyChar > KeyEvent.VK_9)
                {
                    e.consume();
                }
            }
        });
        
        betButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Game.bet(Integer.parseInt(betField.getText()));
            }
        });
    }
    
}

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
    public static JPanel dealerStatContainer;
    public static JLabel dealerStatPoint = new JLabel();
    public static JPanel playerStatOneContainer;
    public static JLabel playerStatOnePoint = new JLabel();
    public static JLabel playerStatOneDescription = new JLabel();
    public static JPanel playerStatTwoContainer;
    public static JLabel playerStatTwoPoint = new JLabel();
    public static JLabel playerStatTwoDescription = new JLabel();
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
        dealerStatContainer = new JPanel(new BorderLayout());
        dealerStatContainer.setOpaque(false);
        JLabel dealerStatTitle = new JLabel("Dealer in Hand");
        dealerStatTitle.setForeground(Color.WHITE);
        dealerStatTitle.setHorizontalAlignment(JLabel.CENTER);
        dealerStatTitle.setFont(new Font("", Font.PLAIN, 12));
        dealerStatPoint.setForeground(Color.WHITE);
        dealerStatPoint.setHorizontalAlignment(JLabel.CENTER);
        dealerStatPoint.setFont(new Font("", Font.PLAIN, 12));
        dealerStatContainer.add(dealerStatTitle, BorderLayout.NORTH);
        dealerStatContainer.add(dealerStatPoint, BorderLayout.CENTER);
        
        playerDeckOneContainer = new CardDeckContainer();
        playerStatOneContainer = new JPanel(new BorderLayout());
        playerStatOneContainer.setOpaque(false);
        JLabel playerStatOneTitle = new JLabel("Player Hand 1");
        playerStatOneTitle.setForeground(Color.WHITE);
        playerStatOneTitle.setHorizontalAlignment(JLabel.CENTER);
        playerStatOneTitle.setFont(new Font("", Font.PLAIN, 12));
        playerStatOnePoint.setForeground(Color.WHITE);
        playerStatOnePoint.setHorizontalAlignment(JLabel.CENTER);
        playerStatOnePoint.setFont(new Font("", Font.PLAIN, 12));
        playerStatOneDescription.setForeground(Color.WHITE);
        playerStatOneDescription.setHorizontalAlignment(JLabel.CENTER);
        playerStatOneDescription.setFont(new Font("", Font.BOLD, 12));
        playerStatOneContainer.add(playerStatOneTitle, BorderLayout.NORTH);
        playerStatOneContainer.add(playerStatOnePoint, BorderLayout.CENTER);
        playerStatOneContainer.add(playerStatOneDescription, BorderLayout.SOUTH);
        
        playerDeckTwoContainer = new CardDeckContainer(new CardDeckPanel(CARD_BACK));
        playerStatTwoContainer = new JPanel(new BorderLayout());
        playerStatTwoContainer.setOpaque(false);
        JLabel playerStatTwoTitle = new JLabel("Player Hand 2");
        playerStatTwoTitle.setForeground(Color.WHITE);
        playerStatTwoTitle.setHorizontalAlignment(JLabel.CENTER);
        playerStatTwoTitle.setFont(new Font("", Font.PLAIN, 12));
        playerStatTwoPoint.setForeground(Color.WHITE);
        playerStatTwoPoint.setHorizontalAlignment(JLabel.CENTER);
        playerStatTwoPoint.setFont(new Font("", Font.PLAIN, 12));
        playerStatTwoDescription.setForeground(Color.WHITE);
        playerStatTwoDescription.setHorizontalAlignment(JLabel.CENTER);
        playerStatTwoDescription.setFont(new Font("", Font.BOLD, 12));
        playerStatTwoContainer.add(playerStatTwoTitle, BorderLayout.NORTH);
        playerStatTwoContainer.add(playerStatTwoPoint, BorderLayout.CENTER);
        playerStatTwoContainer.add(playerStatTwoDescription, BorderLayout.SOUTH);
        
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
        pleaseBet.setFont(new Font("", Font.PLAIN, 14));
        pleaseBet.setForeground(Color.WHITE);
        betButtonPanel.add(pleaseBet);
        betField = new JTextField();
        betField.setFont(new Font("", Font.PLAIN, 14));
        betField.setPreferredSize(new Dimension(80, 28));
        betButtonPanel.add(betField);
        JButton betButton = new JButton("bet");
        betButtonPanel.add(betButton);
        betButtonPanel.setOpaque(false);
        JButton hitButton = new JButton("Hit");
        JButton standButton = new JButton("Stand");
        JButton doubleButton = new JButton("Double");
        //JButton splitButton = new JButton("Split");
        //splitButton.setEnabled(false);
        playButtonPanel.add(hitButton);
        playButtonPanel.add(standButton);
        playButtonPanel.add(doubleButton);
        //playButtonPanel.add(splitButton);
        playButtonPanel.setOpaque(false);
        gameButtonPanel.add("betbutton", betButtonPanel);
        gameButtonPanel.add("playbutton", playButtonPanel);
        gameButtonPanel.setOpaque(false);
        
        add(gameStatPanel);
        add(dealerDeckContainer);
        add(playerDeckTwoContainer);
        add(playerDeckOneContainer);
        add(gameButtonPanel);
        
        this.addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentShown(ComponentEvent e)
            {
                Game.initGame();
            }
        });
        
        betButtonPanel.addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentShown(ComponentEvent e)
            {
                if (BlackJack.player.getChip() <= 0)
                {
                    JOptionPane.showMessageDialog(null, "You are penniless!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    User.deleteUserByName(BlackJack.player.getName());
                    BlackJack.player = new Player(true);
                    BlackJack.dealer = new Player(false);
                    BlackjackFrame.cardLayout.show(BlackJack.gameFrame, "newgame");
                }
                BlackJack.player.setBet(0);
                BlackJack.player.setDoubled(false);
                BlackJack.player.setInsured(false);
                BlackJack.player.setSplit(false);
                BlackJack.player.getHandOne().clear();
                BlackJack.player.getHandTwo().clear();
                BlackJack.dealer.getHandOne().clear();
                GamePanel.gameStatPanelPlayerName.setText("Player: " + BlackJack.player.getName());
                GamePanel.gameStatPanelCurrentChips.setText("Current chips: " + BlackJack.player.getChip());
                GamePanel.gameStatPanel.repaint();
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
        
        hitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Game.hit();
            }
        });
    }
    
}

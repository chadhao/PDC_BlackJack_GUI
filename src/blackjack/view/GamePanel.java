
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
 * The Class GamePanel.
 *
 */
public class GamePanel extends BasePanel
{
    
    /** The Constant CARD_BACK. */
    private static final ArrayList<CardPanel> CARD_BACK = new ArrayList<CardPanel>();
    
    /** The dealer deck container. */
    public static CardDeckContainer dealerDeckContainer;
    
    /** The player deck one container. */
    public static CardDeckContainer playerDeckOneContainer;
    
    /** The player deck two container. */
    public static CardDeckContainer playerDeckTwoContainer;
    
    /** The dealer deck panel. */
    public static CardDeckPanel dealerDeckPanel;
    
    /** The player deck one panel. */
    public static CardDeckPanel playerDeckOnePanel;
    
    /** The player deck two panel. */
    public static CardDeckPanel playerDeckTwoPanel;
    
    /** The dealer stat container. */
    public static JPanel dealerStatContainer;
    
    /** The dealer stat point. */
    public static JLabel dealerStatPoint = new JLabel();
    
    /** The player stat one container. */
    public static JPanel playerStatOneContainer;
    
    /** The player stat one point. */
    public static JLabel playerStatOnePoint = new JLabel();
    
    /** The player stat one description. */
    public static JLabel playerStatOneDescription = new JLabel();
    
    /** The player stat two container. */
    public static JPanel playerStatTwoContainer;
    
    /** The player stat two point. */
    public static JLabel playerStatTwoPoint = new JLabel();
    
    /** The player stat two description. */
    public static JLabel playerStatTwoDescription = new JLabel();
    
    /** The game stat panel. */
    public static JPanel gameStatPanel;
    
    /** The game stat panel player name. */
    public static JLabel gameStatPanelPlayerName;
    
    /** The game stat panel current chips. */
    public static JLabel gameStatPanelCurrentChips;
    
    /** The game stat panel current bet. */
    public static JLabel gameStatPanelCurrentBet;
    
    /** The game button panel. */
    public static JPanel gameButtonPanel;
    
    /** The Constant cardLayout. */
    public static final CardLayout cardLayout = new CardLayout();
    
    /** The bet button panel. */
    private JPanel betButtonPanel;
    
    /** The bet field. */
    public static JTextField betField;
    
    /** The play button panel. */
    private JPanel playButtonPanel;
    
    /** The hit button. */
    private static JButton hitButton;
    
    /** The stand button. */
    private static JButton standButton;
    
    /** The double button. */
    private static JButton doubleButton;
    
    /**
     * Instantiates a new game panel.
     */
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
        JLabel playerStatOneTitle = new JLabel("Player in Hand");
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
        gameStatPanelCurrentBet = new JLabel();
        gameStatPanelPlayerName.setFont(new Font("", Font.PLAIN, 14));
        gameStatPanelPlayerName.setForeground(Color.WHITE);
        gameStatPanelPlayerName.setBorder(new EmptyBorder(0, 0, 0, 5));
        gameStatPanelCurrentChips.setFont(new Font("", Font.PLAIN, 14));
        gameStatPanelCurrentChips.setForeground(Color.WHITE);
        gameStatPanelCurrentChips.setBorder(new EmptyBorder(0, 5, 0, 5));
        gameStatPanelCurrentBet.setFont(new Font("", Font.PLAIN, 14));
        gameStatPanelCurrentBet.setForeground(Color.WHITE);
        gameStatPanelCurrentBet.setBorder(new EmptyBorder(0, 5, 0, 0));
        gameStatPanel.add(gameStatPanelPlayerName);
        gameStatPanel.add(gameStatPanelCurrentChips);
        gameStatPanel.add(gameStatPanelCurrentBet);
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
        JButton betButton = new JButton("Bet");
        JButton backButton = new JButton("Back");
        betButtonPanel.add(betButton);
        betButtonPanel.add(backButton);
        betButtonPanel.setOpaque(false);
        
        hitButton = new JButton("Hit");
        standButton = new JButton("Stand");
        doubleButton = new JButton("Double");
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
                betField.setText("");
                if (BlackJack.player.getChip() <= 0)
                {
                    JOptionPane.showMessageDialog(null, "You are penniless!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    User.deleteUserByName(BlackJack.player.getName());
                    BlackJack.player = new Player(true);
                    BlackJack.dealer = new Player(false);
                    BlackjackFrame.cardLayout.show(getParent(), "welcome");
                }
                hitButton.setEnabled(true);
                standButton.setEnabled(true);
                doubleButton.setEnabled(true);
                BlackJack.player.setBet(0);
                BlackJack.player.getHandOne().clear();
                BlackJack.player.getHandTwo().clear();
                BlackJack.dealer.getHandOne().clear();
                GamePanel.gameStatPanelPlayerName.setText("Player: " + BlackJack.player.getName());
                GamePanel.gameStatPanelCurrentChips.setText("Chips: " + BlackJack.player.getChip());
                GamePanel.gameStatPanelCurrentBet.setText("Bet: 0");
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
        
        backButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to go back to main menu?\nYour record will be saved.", "Go Back", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION)
                {
                    User.updateUser();
                    BlackJack.player = new Player(true);
                    BlackJack.dealer = new Player(false);
                    BlackjackFrame.cardLayout.show(getParent(), "welcome");
                }
            }
        });
        
        hitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                doubleButton.setEnabled(false);
                Game.hit();
            }
        });
        
        standButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                hitButton.setEnabled(false);
                standButton.setEnabled(false);
                doubleButton.setEnabled(false);
                playerStatOneDescription.setText("Stand");
                playerStatOneDescription.repaint();
                Game.dealerGame();
            }
        });
        
        doubleButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                hitButton.setEnabled(false);
                standButton.setEnabled(false);
                doubleButton.setEnabled(false);
                if (!Game.doubleDown())
                {
                    hitButton.setEnabled(true);
                    standButton.setEnabled(true);
                    doubleButton.setEnabled(false);
                }
            }
        });
        
    }
    
}

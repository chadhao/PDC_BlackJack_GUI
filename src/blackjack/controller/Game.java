
package blackjack.controller;

import blackjack.*;
import blackjack.model.*;
import blackjack.view.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/**
 * The Class Game.
 *
 */
public class Game
{
    
    /** The is dealers turn. */
    public static boolean isDealersTurn = false;
    
    /**
     * Initial the game.
     */
    public static void initGame()
    {
        Card.shuffleCards();
        GamePanel.cardLayout.show(GamePanel.gameButtonPanel, "betbutton");
        GamePanel.gameStatPanelPlayerName.setText("Player: " + BlackJack.player.getName());
        GamePanel.gameStatPanelCurrentChips.setText("Chips: " + BlackJack.player.getChip());
        GamePanel.gameStatPanelCurrentBet.setText("Bet: 0");
        GamePanel.gameStatPanel.repaint();
        GamePanel.dealerDeckContainer.removeAll();
        GamePanel.dealerDeckContainer.repaint();
        GamePanel.playerDeckOneContainer.removeAll();
        GamePanel.playerDeckOneContainer.repaint();
    }
    
    /**
     * Bet a hand.
     *
     * @param bet chips to bet
     */
    public static void bet(int bet)
    {
        isDealersTurn = false;
        if (bet > BlackJack.player.getChip())
        {
            JOptionPane.showMessageDialog(null, "You do not have enough chips to bet!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            BlackJack.player.setBet(0, bet);
            BlackJack.player.setChip(BlackJack.player.getChip()-bet);
            if (Card.getCardNow() > (52*Card.NUM_OF_SET*3/4))
            {
                JOptionPane.showMessageDialog(null, "Shuffling cards...", "Information", JOptionPane.INFORMATION_MESSAGE);
    		Card.shuffleCards();
            }
            GamePanel.cardLayout.show(GamePanel.gameButtonPanel, "playbutton");
            BlackJack.dealer.getHandOne().add(Card.dealCard());
            BlackJack.player.getHandOne().add(Card.dealCard());
            BlackJack.dealer.getHandOne().add(Card.dealCard());
            BlackJack.player.getHandOne().add(Card.dealCard());
            GamePanel.gameStatPanelCurrentChips.setText("Chips: " + BlackJack.player.getChip());
            GamePanel.gameStatPanelCurrentBet.setText("Bet: " + BlackJack.player.getBet(0));
            GamePanel.gameStatPanel.repaint();
            GamePanel.dealerDeckContainer.removeAll();
            GamePanel.dealerStatPoint.setText(Card.getValue(BlackJack.dealer.getHandOne().get(0)) + " points");
            GamePanel.dealerDeckContainer.add(GamePanel.dealerStatContainer);
            GamePanel.dealerDeckContainer.add(new CardDeckPanel(Card.generateCardArray(0)));
            GamePanel.dealerDeckContainer.repaint();
            GamePanel.playerDeckOneContainer.removeAll();
            GamePanel.playerStatOnePoint.setText(totalValue(1) + " points");
            GamePanel.playerStatOneDescription.setText("");
            GamePanel.playerDeckOneContainer.add(GamePanel.playerStatOneContainer);
            GamePanel.playerDeckOneContainer.add(new CardDeckPanel(Card.generateCardArray(1)));
            GamePanel.playerDeckOneContainer.repaint();
        }
        if (!checkBlackjack(1))
        {
            checkInsure();
        }
    }
    
    /**
     * Get how many Aces in a hand.
     *
     * @param whichHand 0: dealer's hand / 1: player's first hand / 2: player's second hand
     * @return number of Aces
     */
    private static int getAce(int whichHand)
    {
    	int numOfAce = 0;
        if (whichHand == 0)
        {
            for (Integer integer : BlackJack.dealer.getHandOne())
            {
                if (Card.getValue(integer) == 11)
                {
                    numOfAce++;
                }
            }
        }
        else if (whichHand == 1)
        {
            for (Integer integer : BlackJack.player.getHandOne())
            {
                if (Card.getValue(integer) == 11)
                {
                    numOfAce++;
                }
            }
        }
        else
        {
            for (Integer integer : BlackJack.player.getHandTwo())
            {
                if (Card.getValue(integer) == 11)
                {
                    numOfAce++;
                }
            }
        }
    	return numOfAce;
    }
    
    /**
     * Get total value of a hand.
     *
     * @param whichHand 0: dealer's hand / 1: player's first hand / 2: player's second hand
     * @return total value of the chosen hand
     */
    public static int totalValue(int whichHand)
    {
        int totalValue = 0;
        if (whichHand == 0)
        {
            for (Integer integer: BlackJack.dealer.getHandOne())
            {
                totalValue += Card.getValue(integer);
            }
        }
        else if (whichHand == 1)
        {
            for (Integer integer: BlackJack.player.getHandOne())
            {
                totalValue += Card.getValue(integer);
            }
        }
        else
        {
            for (Integer integer: BlackJack.player.getHandTwo())
            {
                totalValue += Card.getValue(integer);
            }
        }
    	if (getAce(whichHand) > 0)
    	{
            totalValue -= (getAce(whichHand)-1) * 10;
            if (totalValue > 21)
            {
                totalValue -= 10;
            }
    	}
    	return totalValue;
    }
    
    /**
     * Check if a hand is blackjack.
     *
     * @param whichHand 1: player's first hand / 2: player's second hand
     * @return true, if chosen hand is blackjack
     */
    public static boolean checkBlackjack(int whichHand)
    {

        if (totalValue(1) == 21 && totalValue(0) != 21)
        {
            isDealersTurn = true;
            GamePanel.dealerDeckContainer.removeAll();
            GamePanel.dealerStatPoint.setText(totalValue(0) + " points");
            GamePanel.dealerDeckContainer.add(GamePanel.dealerStatContainer);
            GamePanel.dealerDeckContainer.add(new CardDeckPanel(Card.generateCardArray(0)));
            GamePanel.dealerDeckContainer.repaint();
            BlackJack.player.addWin();
            BlackJack.player.setChip((int)(BlackJack.player.getChip() + BlackJack.player.getBet(whichHand-1)*2.5));
            JOptionPane.showMessageDialog(null, "You hold Blackjack!", "Information", JOptionPane.INFORMATION_MESSAGE);
            GamePanel.cardLayout.show(GamePanel.gameButtonPanel, "betbutton");
            return true;
        }
        else if (totalValue(1) == 21 && totalValue(0) == 21)
        {
            isDealersTurn = true;
            GamePanel.dealerDeckContainer.removeAll();
            GamePanel.dealerStatPoint.setText(totalValue(0) + " points");
            GamePanel.dealerDeckContainer.add(GamePanel.dealerStatContainer);
            GamePanel.dealerDeckContainer.add(new CardDeckPanel(Card.generateCardArray(0)));
            GamePanel.dealerDeckContainer.repaint();
            BlackJack.player.addPush();
            BlackJack.player.setChip(BlackJack.player.getChip() + BlackJack.player.getBet(whichHand-1));
            JOptionPane.showMessageDialog(null, "You and dealer both hold Blackjack!", "Information", JOptionPane.INFORMATION_MESSAGE);
            GamePanel.cardLayout.show(GamePanel.gameButtonPanel, "betbutton");
            return true;
        }
        return false;
    }
    
    /**
     * Check if player can insure this hand.
     */
    public static void checkInsure()
    {
        if (BlackJack.dealer.getHandOne().isEmpty())
        {
            return;
        }
        if (Card.getValue(BlackJack.dealer.getHandOne().get(0)) == 11)
        {
            int choice = JOptionPane.showConfirmDialog(null, "Dealer shows an Ace.\nDo you want to insure this hand?", "Insure", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION)
            {
                BlackJack.player.setChip(BlackJack.player.getChip() - BlackJack.player.getBet(0)/2);
                GamePanel.playerStatOneDescription.setText("Insured");
                GamePanel.playerStatOneDescription.repaint();
                if (totalValue(0) == 21)
                {
                    isDealersTurn = true;
                    GamePanel.dealerDeckContainer.removeAll();
                    GamePanel.dealerStatPoint.setText(totalValue(0) + " points");
                    GamePanel.dealerDeckContainer.add(GamePanel.dealerStatContainer);
                    GamePanel.dealerDeckContainer.add(new CardDeckPanel(Card.generateCardArray(0)));
                    GamePanel.dealerDeckContainer.repaint();
                    GamePanel.dealerDeckContainer.revalidate();
                    BlackJack.player.setChip(BlackJack.player.getChip() + BlackJack.player.getBet(0));
                    BlackJack.player.addLose();
                    JOptionPane.showMessageDialog(null, "Dealer holds Blackjack!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    GamePanel.cardLayout.show(GamePanel.gameButtonPanel, "betbutton");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Dealer does not hold Blackjack!", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else
            {
                if (totalValue(0) == 21)
                {
                    isDealersTurn = true;
                    GamePanel.dealerDeckContainer.removeAll();
                    GamePanel.dealerStatPoint.setText(totalValue(0) + " points");
                    GamePanel.dealerDeckContainer.add(GamePanel.dealerStatContainer);
                    GamePanel.dealerDeckContainer.add(new CardDeckPanel(Card.generateCardArray(0)));
                    GamePanel.dealerDeckContainer.repaint();
                    GamePanel.dealerDeckContainer.revalidate();
                    BlackJack.player.addLose();
                    JOptionPane.showMessageDialog(null, "Dealer holds Blackjack!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    GamePanel.cardLayout.show(GamePanel.gameButtonPanel, "betbutton");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Dealer does not hold Blackjack!", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
    
    /**
     * Hit a hand.
     */
    public static void hit()
    {
        BlackJack.player.getHandOne().add(Card.dealCard());
        GamePanel.playerDeckOneContainer.removeAll();
        GamePanel.playerStatOnePoint.setText(totalValue(1) + " points");
        GamePanel.playerStatOneDescription.setText("Hit");
        GamePanel.playerDeckOneContainer.add(GamePanel.playerStatOneContainer);
        GamePanel.playerDeckOneContainer.add(new CardDeckPanel(Card.generateCardArray(1)));
        GamePanel.playerDeckOneContainer.repaint();
        GamePanel.playerDeckOneContainer.revalidate();
        checkBusted(1);
    }
    
    /**
     * Check is a hand is busted.
     *
     * @param whichHand 0: dealer's hand / 1: player's first hand / 2: player's second hand
     * @return true, if the chosen hand is busted
     */
    public static boolean checkBusted(int whichHand)
    {
        if (whichHand == 1 && totalValue(whichHand) > 21)
        {
            GamePanel.playerStatOnePoint.setText(totalValue(1) + " points");
            GamePanel.playerStatOneDescription.setText("Busted");
            GamePanel.playerDeckOneContainer.repaint();
            GamePanel.playerDeckOneContainer.revalidate();
            BlackJack.player.addLose();
            JOptionPane.showMessageDialog(null, "You busted!", "Information", JOptionPane.INFORMATION_MESSAGE);
            GamePanel.cardLayout.show(GamePanel.gameButtonPanel, "betbutton");
            return true;
        }
        else if (whichHand == 0 && totalValue(whichHand) > 21)
        {
            GamePanel.dealerStatPoint.setText(totalValue(0) + " points");
            GamePanel.dealerStatPoint.repaint();
            BlackJack.player.addWin();
            BlackJack.player.setChip(BlackJack.player.getChip() + BlackJack.player.getBet(0)*2);
            JOptionPane.showMessageDialog(null, "Dealer busted!", "Information", JOptionPane.INFORMATION_MESSAGE);
            GamePanel.cardLayout.show(GamePanel.gameButtonPanel, "betbutton");
            return true;
        }
        return false;
    }
    
    /**
     * Dealer's game.
     */
    public static void dealerGame()
    {
        JOptionPane.showMessageDialog(null, "It is dealer\'s turn now.", "Information", JOptionPane.INFORMATION_MESSAGE);
        isDealersTurn = true;
        while (totalValue(0) < 17)
        {
            //try{Thread.sleep(1000);}catch(Exception e){}
            GamePanel.dealerDeckContainer.removeAll();
            GamePanel.dealerStatPoint.setText(totalValue(0) + " points");
            GamePanel.dealerDeckContainer.add(GamePanel.dealerStatContainer);
            GamePanel.dealerDeckContainer.add(new CardDeckPanel(Card.generateCardArray(0)));
            GamePanel.dealerDeckContainer.repaint();
            GamePanel.dealerDeckContainer.revalidate();
            BlackJack.dealer.getHandOne().add(Card.dealCard());
//            ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
//            exec.schedule(new Runnable()
//            {
//                @Override
//                public void run()
//                {
//                    BlackJack.dealer.getHandOne().add(Card.dealCard());
//                }
//            }, 500, TimeUnit.MILLISECONDS);
//            exec.shutdown();
        }
        GamePanel.dealerDeckContainer.removeAll();
        GamePanel.dealerStatPoint.setText(totalValue(0) + " points");
        GamePanel.dealerDeckContainer.add(GamePanel.dealerStatContainer);
        GamePanel.dealerDeckContainer.add(new CardDeckPanel(Card.generateCardArray(0)));
        GamePanel.dealerDeckContainer.repaint();
        GamePanel.dealerDeckContainer.revalidate();
        if (!checkBusted(0))
        {
            judge();
        }
    }
    
    /**
     * Judge if the player wins.
     */
    public static void judge()
    {
        if (totalValue(0) == totalValue(1))
        {
            BlackJack.player.setChip(BlackJack.player.getChip() + BlackJack.player.getBet(0));
            BlackJack.player.addPush();
            JOptionPane.showMessageDialog(null, "Push!", "Information", JOptionPane.INFORMATION_MESSAGE);
            GamePanel.cardLayout.show(GamePanel.gameButtonPanel, "betbutton");
        }
        else if (totalValue(0) < totalValue(1))
        {
            BlackJack.player.setChip(BlackJack.player.getChip() + BlackJack.player.getBet(0)*2);
            BlackJack.player.addWin();
            JOptionPane.showMessageDialog(null, "You win!", "Information", JOptionPane.INFORMATION_MESSAGE);
            GamePanel.cardLayout.show(GamePanel.gameButtonPanel, "betbutton");
        }
        else
        {
            BlackJack.player.addLose();
            JOptionPane.showMessageDialog(null, "You lose!", "Information", JOptionPane.INFORMATION_MESSAGE);
            GamePanel.cardLayout.show(GamePanel.gameButtonPanel, "betbutton");
        }
    }
    
    /**
     * Double down a hand.
     *
     * @return true, if the hand is doubled down successfully
     */
    public static boolean doubleDown()
    {
        if (BlackJack.player.getChip() < BlackJack.player.getBet(0))
        {
            JOptionPane.showMessageDialog(null, "You do not have enough chips to double down this hand!", "Information", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        BlackJack.player.setChip(BlackJack.player.getChip() - BlackJack.player.getBet(0));
        BlackJack.player.setBet(0, BlackJack.player.getBet(0)*2);
        BlackJack.player.getHandOne().add(Card.dealCard());
        GamePanel.gameStatPanelCurrentChips.setText("Chips: " + BlackJack.player.getChip());
        GamePanel.gameStatPanelCurrentBet.setText("Bet: " + BlackJack.player.getBet(0));
        GamePanel.gameStatPanel.repaint();
        GamePanel.playerDeckOneContainer.removeAll();
        GamePanel.playerStatOnePoint.setText(totalValue(1) + " points");
        GamePanel.playerStatOneDescription.setText("Double Down");
        GamePanel.playerDeckOneContainer.add(GamePanel.playerStatOneContainer);
        GamePanel.playerDeckOneContainer.add(new CardDeckPanel(Card.generateCardArray(1)));
        GamePanel.playerDeckOneContainer.repaint();
        GamePanel.playerDeckOneContainer.revalidate();
        if (!checkBusted(1))
        {
            dealerGame();
        }
        return true;
    }
}

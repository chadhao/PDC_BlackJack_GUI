/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.controller;

import blackjack.*;
import blackjack.model.*;
import blackjack.view.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Chad
 */
public class Game
{
    public static boolean isDealersTurn = false;
    
    public static void initGame()
    {
        Card.shuffleCards();
        GamePanel.cardLayout.show(GamePanel.gameButtonPanel, "betbutton");
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
        if (BlackJack.player.getChip() <= 0)
        {
            JOptionPane.showMessageDialog(null, "You are penniless!", "Information", JOptionPane.INFORMATION_MESSAGE);
            User.deleteUserByName(BlackJack.player.getName());
            BlackJack.player = new Player(true);
            BlackJack.dealer = new Player(false);
            BlackjackFrame.cardLayout.show(BlackJack.gameFrame, "newgame");
        }
    }
    
    public static void bet(int bet)
    {
        if (bet > BlackJack.player.getChip())
        {
            JOptionPane.showMessageDialog(null, "You do not have enough chips to bet!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            BlackJack.player.setBet(bet);
            BlackJack.player.setChip(BlackJack.player.getChip()-bet);
            if (Card.getCardNow() > (52*Card.NUM_OF_SET*3/4))
            {
    		Card.shuffleCards();
            }
            GamePanel.cardLayout.show(GamePanel.gameButtonPanel, "playbutton");
            BlackJack.dealer.getHandOne().add(Card.dealCard());
            BlackJack.player.getHandOne().add(Card.dealCard());
            BlackJack.dealer.getHandOne().add(Card.dealCard());
            BlackJack.player.getHandOne().add(Card.dealCard());
            GamePanel.gameStatPanelCurrentChips.setText("Current chips: " + BlackJack.player.getChip());
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
    }
    
    private static int getAce(int whichHand)
    {
        //0: dealer's hand
        //1: player's first hand
        //2: player's second hand
        
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
    
    public static int totalValue(int whichHand)
    {
        //0: dealer's hand
        //1: player's first hand
        //2: player's second hand
        
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
        
}

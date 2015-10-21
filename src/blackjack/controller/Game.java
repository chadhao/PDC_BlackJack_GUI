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
            GamePanel.dealerDeckContainer.add(new CardDeckPanel(Card.generateCardArray(0)));
            GamePanel.dealerDeckContainer.repaint();
            GamePanel.playerDeckOneContainer.removeAll();
            GamePanel.playerDeckOneContainer.add(new CardDeckPanel(Card.generateCardArray(1)));
            GamePanel.playerDeckOneContainer.repaint();
        }
    }
        
}

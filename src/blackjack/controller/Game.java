/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.controller;

import blackjack.*;
import blackjack.model.*;
import blackjack.view.*;

/**
 *
 * @author Chad
 */
public class Game
{
    public static void initRound()
    {
        GamePanel.cardLayout.show(GamePanel.gameButtonPanel, "betbutton");
        BlackJack.player.setBet(0);
        BlackJack.player.setDoubled(false);
        BlackJack.player.setInsured(false);
        BlackJack.player.setSplit(false);
        BlackJack.player.getHandOne().clear();
        BlackJack.player.getHandTwo().clear();
        BlackJack.dealer.getHandOne().clear();
        if (Card.getCardNow() > (52*Card.NUM_OF_SET*3/4))
    	{
    		Card.shuffleCards();
    	}
        System.out.println(BlackJack.player);
        GamePanel.gameStatPanelPlayerName.setText("Player: " + BlackJack.player.getName());
        GamePanel.gameStatPanelCurrentChips.setText("Current chips: " + BlackJack.player.getChip());
        GamePanel.gameStatPanel.repaint();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import blackjack.controller.*;
import blackjack.model.*;
import blackjack.view.*;
import java.awt.EventQueue;
import java.sql.*;

/**
 *
 * @author Chad
 */
public class BlackJack {
    private static final String IMG_SRC = "img/bg.png";
    public static Player player;
    public static Player dealer;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        player = new Player("Chad", 1000, 0, 0, 0);
        Card.shuffleCards();
        for (int i = 0; i < 20; i++)
        {
            System.out.print(Card.getCard(i) + " | ");
            System.out.println(Card.getValue(i));
        }
        
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                BlackjackFrame gameFrame = new BlackjackFrame();
                WelcomePanel welcomePanel = new WelcomePanel(IMG_SRC);
                NewGamePanel newGamePanel = new NewGamePanel(IMG_SRC);
                LoadGamePanel loadGamePanel = new LoadGamePanel(IMG_SRC);
                GamePanel gamePanel = new GamePanel();
                gameFrame.add("welcome", welcomePanel);
                gameFrame.add("newgame", newGamePanel);
                gameFrame.add("loadgame", loadGamePanel);
                gameFrame.add("game", gamePanel);
                gameFrame.setVisible(true);
            }
        });
    }
    
}

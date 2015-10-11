/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.EventQueue;

/**
 *
 * @author Chad
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
        {

            @Override
            public void run()
            {
                BlackjackFrame gameFrame = new BlackjackFrame();
                WelcomePanel welcomePanel = new WelcomePanel("img/bg.png");
                NewGamePanel newGamePanel = new NewGamePanel("img/bg.png");
                gameFrame.add("welcome", welcomePanel);
                gameFrame.add("newgame", newGamePanel);
                gameFrame.setVisible(true);
            }
        });
    }
    
}

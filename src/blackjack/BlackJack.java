
package blackjack;

import blackjack.controller.*;
import blackjack.model.*;
import blackjack.view.*;
import java.awt.EventQueue;
import java.sql.*;

/**
 * The Class BlackJack.
 *
 */
public class BlackJack {
    
    /** The Constant IMG_SRC. */
    private static final String IMG_SRC = "img/bg.png";
    
    /** The player. */
    public static Player player;
    
    /** The dealer. */
    public static Player dealer;
    
    /**
     * The main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        player = new Player(true);
        dealer = new Player(false);
        
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

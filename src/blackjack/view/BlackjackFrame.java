/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import blackjack.*;
import blackjack.controller.*;

/**
 *
 * @author Chad
 */
public class BlackjackFrame extends JFrame
{
    public static final int DEFAULT_WIDTH = 450;
    public static final int DEFAULT_HEIGHT = 600;
    public static final CardLayout cardLayout = new CardLayout();

    public BlackjackFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setLayout(cardLayout);
        setTitle("Blackjack");
        setResizable(false);
        
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);
                if (BlackJack.player.getChip() != 0)
                {
                    User.updateUser();
                    JOptionPane.showMessageDialog(null, "Exiting game!\nYour record will be saved!", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
                System.exit(0);
            }
        });
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.view;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Chad
 */
public class WelcomePanel extends BasePanel
{
    public WelcomePanel(String imgSrc)
    {
        super(imgSrc);
        setLayout(null);
        
        JButton newGameButton = new JButton("New Game");
        JButton loadGameButton = new JButton("Load Game");
        JButton quitButton = new JButton("Quit");
        
        add(newGameButton);
        add(loadGameButton);
        add(quitButton);
        
        newGameButton.setBounds(WIDTH/2-60, HEIGHT/2+30, 120, 42);
        loadGameButton.setBounds(WIDTH/2-60, HEIGHT/2+100, 120, 42);
        quitButton.setBounds(WIDTH/2-60, HEIGHT/2+170, 120, 42);
        
        quitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        newGameButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BlackjackFrame.cardLayout.show(getParent(), "newgame");
            }
        });
    }
}

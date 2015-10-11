/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Chad
 */
public class WelcomePanel extends JComponent
{
    private Image bgImage;
    public static int width;
    public static int height;

    public WelcomePanel(String imgSrc)
    {
        bgImage = new ImageIcon(imgSrc).getImage();
        width = bgImage.getWidth(this);
        height = bgImage.getHeight(this);
        setLayout(null);
        
        JButton newGameButton = new JButton("New Game");
        JButton loadGameButton = new JButton("Load Game");
        JButton quitButton = new JButton("Quit");
        
        add(newGameButton);
        add(loadGameButton);
        add(quitButton);
        
        newGameButton.setBounds(width/2-60, height/2+30, 120, 42);
        loadGameButton.setBounds(width/2-60, height/2+100, 120, 42);
        quitButton.setBounds(width/2-60, height/2+170, 120, 42);
        
        quitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        newGameButton.addActionListener(null);
    }
    
    public void paintComponent(Graphics g)
    {
        if (bgImage != null)
        {
            g.drawImage(bgImage, 0, 0, null);
        }
    }
    
    public Dimension getPreferredSize()
    {
        return new Dimension(width, height);
    }
}

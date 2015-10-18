/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.view;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Chad
 */
public class CardPanel extends JComponent
{
    private Image cardImage;
    public final String CARD_NAME;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 150;

    public CardPanel(String imgSrc)
    {
        CARD_NAME = imgSrc.substring(10, 12);
        cardImage = new ImageIcon(imgSrc).getImage();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.drawImage(cardImage, 0, 0, null);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(WIDTH, HEIGHT);
    }
    
    
}

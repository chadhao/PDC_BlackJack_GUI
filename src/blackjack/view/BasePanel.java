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
public class BasePanel extends JComponent
{
    private Image bgImage;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 600;

    public BasePanel()
    {
        bgImage = null;
    }
    
    public BasePanel(String imgSrc)
    {
        bgImage = new ImageIcon(imgSrc).getImage();
    }
    
    public void paintComponent(Graphics g)
    {
        if (bgImage != null)
        {
            g.drawImage(bgImage, 0, 0, null);
        }
        else
        {
            g.setColor(new Color(11, 79, 40, 255));
            g.fillRect(0, 0, WIDTH, HEIGHT);
        }
    }
    
    public Dimension getPreferredSize()
    {
        return new Dimension(WIDTH, HEIGHT);
    }
}

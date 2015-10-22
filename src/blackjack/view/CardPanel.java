
package blackjack.view;

import java.awt.*;
import javax.swing.*;

/**
 * The Class CardPanel.
 *
 */
public class CardPanel extends JComponent
{
    
    /** The card image. */
    private Image cardImage;
    
    /** The card name. */
    public final String CARD_NAME;
    
    /** The Constant WIDTH. */
    public static final int WIDTH = 100;
    
    /** The Constant HEIGHT. */
    public static final int HEIGHT = 145;

    /**
     * Instantiates a new card panel.
     *
     * @param imgSrc the image source
     */
    public CardPanel(String imgSrc)
    {
        CARD_NAME = imgSrc.substring(10, 12);
        cardImage = new ImageIcon(imgSrc).getImage();
    }
    
    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(Graphics g)
    {
        g.drawImage(cardImage, 0, 0, null);
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#getPreferredSize()
     */
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(WIDTH, HEIGHT);
    }
    
    
}

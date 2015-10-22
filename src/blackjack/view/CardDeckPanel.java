
package blackjack.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * The Class CardDeckPanel.
 *
 */
public class CardDeckPanel extends JComponent
{
    
    /** The width. */
    public int WIDTH;
    
    /** The height. */
    public final int HEIGHT = 150;

    /**
     * Instantiates a new card deck panel.
     *
     * @param cards the cards
     */
    public CardDeckPanel(ArrayList<CardPanel> cards)
    {
        setLayout(null);
        if (cards.size() <= 5)
        {
            WIDTH = 100 + (cards.size() - 1) * 50;
        }
        else
        {
            WIDTH = 100 + (cards.size() - 1) * 25;
        }
        
        for (int i = cards.size()-1; i >= 0; i--)
        {
            add(cards.get(i));
            cards.get(i).setBorder(new LineBorder(Color.BLACK, 1));
            if (cards.size() <= 5)
            {
                cards.get(i).setBounds(i*50, 0, CardPanel.WIDTH, CardPanel.HEIGHT);
            }
            else
            {
                cards.get(i).setBounds(i*25, 0, CardPanel.WIDTH, CardPanel.HEIGHT);
            }
            
        }
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

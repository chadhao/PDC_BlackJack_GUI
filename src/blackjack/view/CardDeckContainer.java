
package blackjack.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * The Class CardDeckContainer.
 *
 */
public class CardDeckContainer extends JComponent
{
    
    /**
     * Instantiates a new card deck container.
     *
     * @param contentPanel the content panel
     */
    public CardDeckContainer(CardDeckPanel contentPanel)
    {
        setBorder(new EmptyBorder(10, 0, 10, 0));
        setLayout(new FlowLayout());
        setOpaque(false);
        add(contentPanel);
    }

    /**
     * Instantiates a new card deck container.
     */
    public CardDeckContainer()
    {
        setBorder(new EmptyBorder(10, 0, 10, 0));
        setLayout(new FlowLayout());
        setOpaque(false);
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#getPreferredSize()
     */
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(450, 165);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Chad
 */
public class CardDeckContainer extends JComponent
{
    public CardDeckContainer(CardDeckPanel contentPanel)
    {
        setBorder(new EmptyBorder(10, 0, 10, 0));
        setLayout(new FlowLayout());
        setOpaque(false);
        add(contentPanel);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(450, 165);
    }
}

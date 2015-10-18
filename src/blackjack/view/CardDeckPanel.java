/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Chad
 */
public class CardDeckPanel extends JComponent
{
    public int WIDTH;
    public final int HEIGHT = 150;

    public CardDeckPanel(ArrayList<CardPanel> cards)
    {
        setLayout(null);
        WIDTH = 100 + (cards.size() - 1) * 25;
        
        for (int i = cards.size()-1; i >= 0; i--)
        {
            add(cards.get(i));
            cards.get(i).setBorder(new LineBorder(Color.BLACK, 1));
            cards.get(i).setBounds(i*25, 0, CardPanel.WIDTH, CardPanel.HEIGHT);
        }
    }
    
    
    
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(WIDTH, HEIGHT);
    }
    
    
}

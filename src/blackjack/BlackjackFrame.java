/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.*;
import javax.swing.*;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

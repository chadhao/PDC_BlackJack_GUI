/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Chad
 */
public class NewGamePanel extends BasePanel
{
    public NewGamePanel(String imgSrc)
    {
        super(imgSrc);
        setLayout(null);
        
        JLabel nameLabel = new JLabel("Player Name", JLabel.CENTER);
        JTextField nameField = new JTextField();
        JButton playButton = new JButton("Play");
        JButton backButton = new JButton("Back");
        
        add(nameLabel);
        add(nameField);
        add(playButton);
        add(backButton);
        
        nameLabel.setFont(new Font("", Font.PLAIN, 16));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(WIDTH/2-60, HEIGHT/2+30, 120, 20);
        
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setFont(new Font("", Font.BOLD, 16));
        nameField.setBounds(WIDTH/2-100, HEIGHT/2+60, 200, 42);
        
        playButton.setBounds(WIDTH/2-60, HEIGHT/2+110, 120, 42);
        backButton.setBounds(WIDTH/2-60, HEIGHT/2+170, 120, 42);
        
        backButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BlackjackFrame.cardLayout.show(getParent(), "welcome");
            }
        });
    }
}

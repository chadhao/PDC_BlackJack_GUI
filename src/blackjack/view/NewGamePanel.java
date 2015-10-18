/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import blackjack.controller.*;
import blackjack.*;

/**
 *
 * @author Chad
 */
public class NewGamePanel extends BasePanel
{
    private JLabel nameLabel;
    private JTextField nameField;
    private JButton playButton;
    private JButton backButton;
    private JDialog msgBox;
    
    public NewGamePanel(String imgSrc)
    {
        super(imgSrc);
        setLayout(null);
        
        nameLabel = new JLabel("Player Name", JLabel.CENTER);
        nameField = new JTextField();
        playButton = new JButton("Play");
        backButton = new JButton("Back");
        
        add(nameLabel);
        add(nameField);
        add(playButton);
        add(backButton);
        
        nameLabel.setFont(new Font("", Font.PLAIN, 16));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(WIDTH/2-60, HEIGHT/2+30, 120, 20);
        
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setFont(new Font("", Font.BOLD, 16));
        nameField.setBorder(null);
        nameField.setBounds(WIDTH/2-100, HEIGHT/2+60, 200, 40);
        
        playButton.setBounds(WIDTH/2-60, HEIGHT/2+110, 120, 42);
        backButton.setBounds(WIDTH/2-60, HEIGHT/2+180, 120, 42);
        
        backButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                nameField.setText("");
                playButton.setEnabled(true);
                BlackjackFrame.cardLayout.show(getParent(), "welcome");
            }
        });
        
        playButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                playButton.setEnabled(false);
                if (nameField.getText().isEmpty())
                {
                    nameField.setText("Empty username!");
                }
                else if (!User.checkUsername(nameField.getText()))
                {
                    nameField.setText("Characters and numbers only!");
                }
                else if (User.hasUser(nameField.getText()))
                {
                    nameField.setText("User already exists!");
                }
                else
                {
                    if (User.addUser(nameField.getText()))
                    {
                        BlackJack.player = User.initPlayer(nameField.getText());
                    }
                    else
                    {
                        nameField.setText("Failed creating player!");
                    }
                }
            }
        });
        
        nameField.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                nameField.setText("");
                playButton.setEnabled(true);
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                
            }
        });
    }
    
    
}

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

/**
 *
 * @author Chad
 */
public class LoadGamePanel extends BasePanel
{
    JList<String> savedList;
    JButton playButton;
    JButton backButton;
    
    public LoadGamePanel(String imgSrc)
    {
        super(imgSrc);
        setLayout(null);
        String[] savedData = User.getUserList();
        
        savedList = new JList<>(savedData);
        playButton = new JButton("Play");
        backButton = new JButton("Back");
        
        if (savedData.length != 0)
        {
            savedList.setSelectedIndex(0);
        }
        savedList.setVisibleRowCount(5);
        savedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        savedList.setFixedCellHeight(22);
        savedList.setFont(new Font("", Font.PLAIN, 16));
        
        if (savedData.length > savedList.getVisibleRowCount())
        {
            JScrollPane scrollList = new JScrollPane(savedList);
            scrollList.setBorder(null);
            add(scrollList);
            scrollList.setBounds(WIDTH/2-150, HEIGHT/2, 300, 110);
        }
        else
        {
            savedList.setBorder(null);
            add(savedList);
            savedList.setBounds(WIDTH/2-150, HEIGHT/2, 300, 110);
        }
        
        add(playButton);
        add(backButton);
        
        playButton.setBounds(WIDTH/2-60, HEIGHT/2+120, 120, 42);
        backButton.setBounds(WIDTH/2-60, HEIGHT/2+190, 120, 42);
        
        backButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BlackjackFrame.cardLayout.show(getParent(), "welcome");
            }
        });
        
        playButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String selectedUsername = savedList.getSelectedValue().split("\\[")[1].split("\\]")[0];
                User.initPlayer(selectedUsername);
            }
        });
    }
    
}

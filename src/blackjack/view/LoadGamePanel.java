/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Chad
 */
public class LoadGamePanel extends BasePanel
{
    public LoadGamePanel(String imgSrc, String[] savedData)
    {
        super(imgSrc);
        setLayout(null);
        
        JList<String> savedList = new JList<>(savedData);
        JButton playButton = new JButton("Play");
        JButton backButton = new JButton("Back");
        
        add(savedList);
        add(playButton);
        add(backButton);
        
        
        if (savedData.length != 0)
        {
            savedList.setSelectedIndex(0);
        }
        savedList.setVisibleRowCount(5);
        if (savedData.length > savedList.getVisibleRowCount())
        {
            savedList.add(new JScrollPane(savedList));
        }
        
        savedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        savedList.setFixedCellHeight(22);
        savedList.setFont(new Font("", Font.PLAIN, 16));
        savedList.setBounds(WIDTH/2-125, HEIGHT/2, 250, 110);
        
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
    }
    
}

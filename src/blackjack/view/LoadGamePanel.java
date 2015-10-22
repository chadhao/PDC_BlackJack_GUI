
package blackjack.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import blackjack.controller.*;
import blackjack.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * The Class LoadGamePanel.
 *
 */
public class LoadGamePanel extends BasePanel
{
    
    /** The saved list. */
    private JList<String> savedList;
    
    /** The play button. */
    private JButton playButton;
    
    /** The back button. */
    private JButton backButton;
    
    /** The saved data. */
    private String[] savedData;
    
    /**
     * Instantiates a new load game panel.
     *
     * @param imgSrc the img src
     */
    public LoadGamePanel(String imgSrc)
    {
        super(imgSrc);
        setLayout(null);
        savedData = User.getUserList();
        
        savedList = new JList<>(savedData);
        playButton = new JButton("Play");
        backButton = new JButton("Back");
        
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
                if (savedList.getSelectedValue() != null)
                {
                    String selectedUsername = savedList.getSelectedValue().split("\\[")[1].split("\\]")[0];
                    User.initPlayer(selectedUsername);
                    BlackjackFrame.cardLayout.show(getParent(), "game");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please select a record from list!", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        this.addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentShown(ComponentEvent e)
            {
                savedData = User.getUserList();
                savedList.setListData(savedData);
            }
        });
    }
    
}

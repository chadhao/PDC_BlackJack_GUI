/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.controller;

import blackjack.model.DBOps;
import java.sql.*;

/**
 *
 * @author Chad
 */
public class User
{
    private int id;
    private String username;
    private int chips;
    private int win;
    private int lose;
    private int push;
    
    public User()
    {
        id = 0;
        username = "";
        chips = 0;
        win = 0;
        lose = 0;
        push = 0;
    }
    
    public User(int id, String username, int chips, int win, int lose, int push)
    {
        this.id = id;
        this.username = username;
        this.chips = chips;
        this.win = win;
        this.lose = lose;
        this.push = push;
    }
    
    public static boolean hasUser(String username)
    {
        try
        {
            ResultSet nameSet = DBOps.exeQuery("SELECT USERNAME FROM USERS");
            while(nameSet.next())
            {
                if (nameSet.getString(1).equals(username))
                {
                    return true;
                }
            }
        }
        catch (SQLException sqle)
        {
            return true;
        }
        
        return false;
    }
    
    public User getUserByName(String username)
    {
        int ID;
        int chips;
        int win;
        int lose;
        int push;
        try
        {
            ResultSet nameSet = DBOps.exeQuery("SELECT * FROM USERS WHERE USERNAME = \'" + username);
            while(nameSet.next())
            {
                ID = nameSet.getInt("ID");
                chips = nameSet.getInt("CHIPS");
                win = nameSet.getInt("WIN");
                lose = nameSet.getInt("LOSE");
                push = nameSet.getInt("PUSH");
                return new User(ID, username, chips, win, lose, push);
            }
        }
        catch (SQLException sqle)
        {
            return null;
        }
        return null;
    }
    
    public boolean addUser(String username)
    {
        this.username = username;
        this.chips = 1000;
        String SQLCommand = "INSERT INTO USERS (USERNAME, CHIPS) VALUES (\'" + this.username + "\', " + this.chips + ")";
        System.out.println(SQLCommand);
        try
        {
            DBOps.exeUpdate(SQLCommand);
        }
        catch (SQLException sqle)
        {
            return false;
        }
        return true;
    }
    
    public void deleteUserByName(String username)
    {
        
    }
    
    public void updateUser(User aUser)
    {
        
    }
    
    private void setUsername(String username)
    {
        this.username = username;
    }
    
    private void setChips(int chips)
    {
        this.chips = chips;
    }
    
    private void setWin(int win)
    {
        this.win = win;
    }
    
    private void setLose(int lose)
    {
        this.lose = lose;
    }
    
    private void setPush(int push)
    {
        this.push = push;
    }
    
    public int getID()
    {
        return id;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public int getChips()
    {
        return chips;
    }
    
    public int getWin()
    {
        return win;
    }
    
    public int getLose()
    {
        return lose;
    }
    
    public int getPush()
    {
        return push;
    }
}

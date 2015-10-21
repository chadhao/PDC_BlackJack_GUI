/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.controller;

import blackjack.model.*;
import blackjack.*;
import java.sql.*;
import java.util.ArrayList;

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
    
    public static boolean checkUsername(String username)
    {
        for (char aChar : username.toCharArray())
        {
            if (!((aChar >= '0' && aChar <= '9') || (aChar >= 'a' && aChar <= 'z') || (aChar >= 'A' && aChar <= 'Z')))
            {
                System.out.println(aChar);
                return false;
            }
        }
        return true;
    }
    
    public static boolean isDatabaseEmpty()
    {
        try
        {
            ResultSet numOfRows = DBOps.exeQuery("SELECT COUNT(*) FROM USERS");
            while(numOfRows.next())
            {
                if (numOfRows.getInt(1) == 0)
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
    
    public static User getUserByName(String username)
    {
        int ID;
        int chips;
        int win;
        int lose;
        int push;
        try
        {
            ResultSet nameSet = DBOps.exeQuery("SELECT * FROM USERS WHERE USERNAME = \'" + username + "\'");
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
    
    public static String[] getUserList()
    {
        ArrayList<String> userList = new ArrayList<>();
        try
        {
            ResultSet nameSet = DBOps.exeQuery("SELECT * FROM USERS");
            while(nameSet.next())
            {
                userList.add(nameSet.getInt("ID") + "| [" + nameSet.getString("USERNAME") + "] "
                + nameSet.getInt("CHIPS") + " chips W" + nameSet.getInt("WIN")
                + "|L" + nameSet.getInt("LOSE") + "|P" + nameSet.getInt("PUSH"));
            }
        }
        catch (Exception e)
        {
        }
        String[] stringArray = userList.toArray(new String[userList.size()]);
        return stringArray;
    }
    
    public static void initPlayer(String username)
    {
//        if (!hasUser(username))
//        {
//            addUser(username);
//        }
        User aUser = getUserByName(username);
        BlackJack.player.setName(aUser.getUsername());
        BlackJack.player.setChip(aUser.getChips());
        BlackJack.player.setWin(aUser.getWin());
        BlackJack.player.setLose(aUser.getLose());
        BlackJack.player.setPush(aUser.getPush());
    }
    
    public static boolean addUser(String username)
    {
        String SQLCommand = "INSERT INTO USERS (USERNAME, CHIPS) VALUES (\'" + username + "\', 1000)";
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
    
    public static boolean deleteUserByName(String username)
    {
        String SQLCommand = "DELETE FROM USERS WHERE USERNAME = \'" + username + "\'";
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
    
    public void updateUser(User aUser)
    {
        
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

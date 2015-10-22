
package blackjack.controller;

import blackjack.model.*;
import blackjack.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * The Class User is used to exchange data between database and Player class.
 *
 */
public class User
{
    
    /** The id. */
    private int id;
    
    /** The username. */
    private String username;
    
    /** The chips. */
    private int chips;
    
    /** The win. */
    private int win;
    
    /** The lose. */
    private int lose;
    
    /** The push. */
    private int push;
    
    /**
     * Instantiates a new user.
     */
    public User()
    {
        id = 0;
        username = "";
        chips = 0;
        win = 0;
        lose = 0;
        push = 0;
    }
    
    /**
     * Instantiates a new user.
     *
     * @param id the id
     * @param username the username
     * @param chips the chips
     * @param win the win
     * @param lose the lose
     * @param push the push
     */
    public User(int id, String username, int chips, int win, int lose, int push)
    {
        this.id = id;
        this.username = username;
        this.chips = chips;
        this.win = win;
        this.lose = lose;
        this.push = push;
    }
    
    /**
     * Check username.
     *
     * @param username the username
     * @return true, if the username is illegal
     */
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
    
    /**
     * Checks if database is empty.
     *
     * @return true, if database is empty
     */
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
    
    /**
     * Checks for user in database.
     *
     * @param username the username
     * @return true, if the user exists in database
     */
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
    
    /**
     * Gets the user by name from database.
     *
     * @param username the username
     * @return a User object if the user exists in database
     */
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
    
    /**
     * Gets the user list.
     *
     * @return the user list
     */
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
    
    /**
     * Initial the player.
     *
     * @param username the username
     */
    public static void initPlayer(String username)
    {
        User aUser = getUserByName(username);
        BlackJack.player.setName(aUser.getUsername());
        BlackJack.player.setChip(aUser.getChips());
        BlackJack.player.setWin(aUser.getWin());
        BlackJack.player.setLose(aUser.getLose());
        BlackJack.player.setPush(aUser.getPush());
    }
    
    /**
     * Add a user to database.
     *
     * @param username the username
     * @return true, if successful
     */
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
    
    /**
     * Delete user by name.
     *
     * @param username the username
     * @return true, if successful
     */
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
    
    /**
     * Update user.
     */
    public static void updateUser()
    {
        String name = BlackJack.player.getName();
        int chips = BlackJack.player.getChip();
        int win = BlackJack.player.getWin();
        int lose = BlackJack.player.getLose();
        int push = BlackJack.player.getPush();
        if (chips == 0)
        {
            deleteUserByName(name);
            return;
        }
        String SQLCommand = "UPDATE USERS SET CHIPS = " + chips + ", WIN = " + win + ", LOSE = " + lose + ", PUSH = " + push + "WHERE USERNAME = \'" + name + "\'";
        try
        {
            DBOps.exeUpdate(SQLCommand);
        }
        catch (SQLException sqle)
        {
        }
    }
    
    /**
     * Gets the user id.
     *
     * @return the id
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }
    
    /**
     * Gets the chips.
     *
     * @return the chips
     */
    public int getChips()
    {
        return chips;
    }
    
    /**
     * Gets the win.
     *
     * @return the win
     */
    public int getWin()
    {
        return win;
    }
    
    /**
     * Gets the lose.
     *
     * @return the lose
     */
    public int getLose()
    {
        return lose;
    }
    
    /**
     * Gets the push.
     *
     * @return the push
     */
    public int getPush()
    {
        return push;
    }
}

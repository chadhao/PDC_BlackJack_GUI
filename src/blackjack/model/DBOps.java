/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.model;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Chad
 */
public class DBOps
{
    public static Connection conn;
    
    public static void initConnection() throws SQLException
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            Properties props = new Properties();
            props.put("user", "blackjack");
            props.put("password", "blackjack");
            conn = DriverManager.getConnection("jdbc:derby:BLACKJACK;create=true", props);
            conn.setAutoCommit(false);
            Statement stat = conn.createStatement();
            stat.execute("create table users(id integer not null generated always as identity (start with 1, increment by 1) primary key,username varchar(256) not null,chips integer not null,win integer default 0 not null,lose integer default 0 not null,push integer default 0 not null)");
            System.out.println("DB setup done!");
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e)
        {
            e.printStackTrace();
        }
        
    }
    
    public static int exeUpdate(String SQLCommand) throws SQLException
    {
        if (conn == null)
        {
            initConnection();
        }
        Statement stat = conn.createStatement();
        return stat.executeUpdate(SQLCommand);
    }
    
    public static ResultSet exeQuery(String SQLCommand) throws SQLException
    {
        if (conn == null)
        {
            initConnection();
        }
        Statement stat = conn.createStatement();
        return stat.executeQuery(SQLCommand);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.model;

import java.sql.*;

/**
 *
 * @author Chad
 */
public class DBOps
{
    public final static String url = "jdbc:derby://localhost:1527/blackjack";
    public final static String username = "blackjack";
    public final static String password = "blackjack";
    
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(DBOps.url, DBOps.username, DBOps.password);
    }
    
    public static int exeUpdate(String SQLCommand) throws SQLException
    {
        Connection conn = getConnection();
        Statement stat = conn.createStatement();
        return stat.executeUpdate(SQLCommand);
    }
    
    public static ResultSet exeQuery(String SQLCommand) throws SQLException
    {
        Connection conn = getConnection();
        Statement stat = conn.createStatement();
        return stat.executeQuery(SQLCommand);
    }
}

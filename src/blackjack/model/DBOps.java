
package blackjack.model;

import java.sql.*;
import java.util.*;

/**
 * The Class DBOps is used to initialize database connection and execute SQL commands.
 *
 */
public class DBOps
{
    
    /** The connection. */
    public static Connection conn;
    
    /**
     * Initial the connection.
     *
     * @throws SQLException the SQL exception
     */
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
    
    /**
     * Execute update.
     *
     * @param SQLCommand the SQL command
     * @return the integer representation of the execution status
     * @throws SQLException the SQL exception
     */
    public static int exeUpdate(String SQLCommand) throws SQLException
    {
        if (conn == null)
        {
            initConnection();
        }
        Statement stat = conn.createStatement();
        return stat.executeUpdate(SQLCommand);
    }
    
    /**
     * Execute query.
     *
     * @param SQLCommand the SQL command
     * @return the result set
     * @throws SQLException the SQL exception
     */
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

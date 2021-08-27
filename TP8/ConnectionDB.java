package TP8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB 
{
    private Connection connection;
    
    public ConnectionDB() 
    {
        this.connection = null;
    }
    
    private void setConnection(Connection connection) 
    {
        this.connection = connection;
    }
    
    public Connection getConnection() 
    {
        return this.connection;
    }
    
    public boolean openConnection() 
    {
        try 
        {
            connection = DriverManager.getConnection("C:/Users/Jordy/Documents/Programação/DBrowserSQL/TP-8.db");
            this.setConnection(connection);
            return true;
        } 
        catch (SQLException error) 
        {
            System.out.println(error.getMessage());
            return false;
        }
    }
    
    public boolean closeConnection() 
    {
        try 
        {
            if(this.getConnection() != null)
                this.getConnection().close();
                return true;
        } 
        catch (SQLException error) 
        {
                System.out.println(error.getMessage());
                return false;
        }
        }
}
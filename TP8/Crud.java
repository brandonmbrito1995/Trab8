package TP8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud 
{
    private Connection connection;
    
    public Crud(Connection connection) 
    {
        this.connection = connection;
    }
    
    public boolean create(String Nome, int Matricula) 
    {
        Statement statement;
        try 
        {
            statement = this.connection.createStatement();
            statement.executeUpdate("INSERT INTO Aluno (Nome, Matricula) VALUES ('"+Nome+"', "+Matricula+")");
            
            return true;
            
        } 
        catch (SQLException error) 
        {
            System.out.println(error.getMessage());
            return false;
        }
    }
    
    public boolean read(String Nome, int Matricula) 
    {
        try 
        {
            Statement statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Aluno WHERE Matricula = " + Matricula);
            
            int id = result.getInt("Matricula");
            String titulo = result.getString("Nome");
            
            System.out.println(id + " - " + Nome);
            
            return true;
        } 
        catch (SQLException error) 
        {
            System.out.println(error.getMessage());
            return false;
        }
    }
    
    public boolean detect(String Nome) 
    {
        try 
        {
            Statement statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Aluno WHERE Nome LIKE " + "'%" + Nome + "%'");
            
            while (result.next()) 
            {
                int id = result.getInt("Matricula");
                String titulo = result.getString("Nome");
                
                System.out.println(id + " - " + Nome);
            }
            
            return true;
        } 
        catch (SQLException error) 
        {
            System.out.println(error.getMessage());
            return false;
        }
    }
    
    public boolean update(int Matricula, String Nome) 
    {
        try 
        {
            Statement statement = this.connection.createStatement();
            statement.executeQuery("UPDATE Aluno SET Nome = " + Nome + " WHERE Matricula = " + Matricula);

            return true;
        } 
        catch (SQLException error) 
        {
            System.out.println(error.getMessage());
            return false;
        }
    }
    
    public boolean delete(int Matricula) 
    {
        try 
        {
            Statement statement = this.connection.createStatement();
            statement.executeQuery("DELETE FROM Aluno WHERE Matricula = " + Matricula);

            return true;
        } 
        catch (SQLException error) 
        {
            System.out.println(error.getMessage());
            return false;
        }
    }
}
package conexao;

import java.sql.*;

public class ConexaoMySQL
{
    private static Connection connection = null;
    private static Statement st;
    
    public ConexaoMySQL()
    {
        
    }
    
    public static Connection conectar()
    {  
    	try 
    	{
            // Configurações na conexão MySQL
            String url = "jdbc:mysql://localhost/agenda";
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            connection = DriverManager.getConnection(url,"root","" );

            System.out.println("Conectado com Sucesso!");
            return connection;
        } 
    	catch (SQLException sqle)
    	{
            System.out.println("Não foi possivel conectar no banco."+ sqle);
            return null;
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("Driver não encontrado."+ cnfe);
            return null;
        }
    }
    
    public static boolean encerrar()
    {
    	try 
    	{
            connection.close();
            System.out.println("Conexão Encerrada.");
            return true;
        } 
    	catch (SQLException sqle) 
    	{
            return false;
        }
    }
}

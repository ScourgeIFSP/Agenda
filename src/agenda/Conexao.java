package agenda;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Conexao {
	
    private String connectionURL= "jdbc:mysql://localhost/Ruedo";
    private String driverName = "com.mysql.jdbc.Driver"; 
    private Connection conn = null;
    
    public Conexao()
    {
        
    }
    
    public Connection Conecta()
    {  
    	try 
    	{	
            Class.forName(this.driverName);
            conn = DriverManager.getConnection(connectionURL,"root","" );
            System.out.println("Conectado com Sucesso!");
            return conn;

        } 
    	catch (Exception e)
    	{
            System.out.println("N�o foi possivel conectar no banco"+ e);
            return null;
        }
    }
    
    public void encerra() throws SQLException
    {
    	try 
    	{
            conn.close();
            System.out.println("Conex�o Encerrada.");
        } 
    	catch (SQLException ex) 
    	{
            throw new SQLException(ex.getMessage());
        }
    }
}

package agenda;

import java.sql.*;

public class Conexao {
	
    private final String connectionURL= "jdbc:mysql://localhost/Ruedo";
    private final String driverName = "com.mysql.jdbc.Driver"; 
    private Connection conn = null;
    
    public Conexao()
    {
        
    }
    
    public Connection conecta()
    {  
    	try 
    	{	
            Class.forName(this.driverName);
            conn = DriverManager.getConnection(connectionURL,"root","" );
            System.out.println("Conectado com Sucesso!");
            return conn;
        } 
    	catch (SQLException sqle)
    	{
            System.out.println("Não foi possivel conectar no banco"+ sqle);
            return null;
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("Driver não encontrado"+ cnfe);
            return null;
        }
    }
    
    public void encerra() throws SQLException
    {
    	try 
    	{
            conn.close();
            System.out.println("Conexão Encerrada.");
        } 
    	catch (SQLException sqle) 
    	{
            throw new SQLException(sqle.getMessage());
        }
    }
}

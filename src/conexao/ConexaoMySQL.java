package conexao;

import java.sql.*;
import java.util.*;

public class ConexaoMySQL implements Conexao
{
    private static Connection connection = null;

    // Inicia conexão
    public Connection conectar()
    {  
    	try 
    	{
            // Configurações na conexão MySQL
            String url = "jdbc:mysql://"+Acesso.getServidor()+"/"+Acesso.getBanco();
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            connection = DriverManager.getConnection(url,Acesso.getUsuario(),Acesso.getSenha());

            System.out.println("Conectado com Sucesso!");
            return connection;
        } 
    	catch (SQLException sqle)
    	{
            System.out.println("Não foi possivel conectar no banco. Mensagem: "+sqle.getMessage());
            return null;
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("Driver não encontrado. "+cnfe.getMessage());
            return null;
        }
    }

    // Encerra conexão
    public boolean encerrar()
    {
    	try
    	{
            connection.close();
            System.out.println("Conexão Encerrada.");
            return true;
        }
    	catch (SQLException sqle)
    	{
            System.out.println("Conexão não pode ser encerrada: "+sqle.getMessage());
            return false;
        }
    }

    // Métodos de acesso ao banco
    public String seleciona(String tabela)
    {
        return "SELECT * FROM "+tabela;
    }

    public String seleciona(String tabela, String condicao, String valor)
    {
        return "SELECT * FROM "+tabela+" WHERE "+condicao+" = '"+valor+"'";
    }

    public String insere(String tabela, ArrayList<String> valores)
    {
        return "";
    }

    public String altera()
    {
        return "";
    }

    public String deleta()
    {
        return "";
    }
}

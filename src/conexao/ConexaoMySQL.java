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
            // Configurações de conexão MySQL
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

    // Seleciona todos os dados de uma tabela
    public String seleciona(String tabela)
    {
        return "SELECT * FROM "+tabela+";";
    }

    // Seleciona uma tabela com apenas uma condição
    public String seleciona(String tabela, String condicao, String valor)
    {
        return "SELECT * FROM "+tabela+" WHERE "+condicao+" = '"+valor+"';";
    }

    // Seleciona uma tabela com inumeras condições
    public String seleciona(String tabela, ArrayList<String> condicoes, ArrayList<String> valores)
    {
        String query = "SELECT * FROM "+tabela+" WHERE ";

        for (int i=0; i<condicoes.size(); i++)
        {
            if (i!=0)
            {
                query += " AND ";
            }
            query += condicoes.get(i)+" = "+valores.get(i);
            if (i == condicoes.size()-1)
            {
                query += ";";
            }
        }

        return query;
    }

    // Insere em uma tabela com os valores em ordem
    public String insere(String tabela, ArrayList<String> valores)
    {
        String query = "INSERT INTO "+tabela+" VALUES (";

        for(String valor : valores)
        {
            query += valor;
            if(valores.get(valores.size()-1) != valor)
            {
                query += ", ";
            }
            else
            {
                query += ");";
            }
        }

        return query;
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

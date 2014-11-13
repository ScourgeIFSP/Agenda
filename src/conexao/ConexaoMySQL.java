package conexao;

import java.sql.*;
import java.util.*;

public class ConexaoMySQL implements Conexao
{
    private static Connection con = null;

    // Inicia conexão
    public Connection conectar()
    {  
    	try 
    	{
            // Configurações de conexão MySQL
            String url = "jdbc:mysql://"+Acesso.getServidor()+"/"+Acesso.getBanco();
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            con = DriverManager.getConnection(url,Acesso.getUsuario(),Acesso.getSenha());

            System.out.println("Conectado com Sucesso!");
            return con;
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
            con.close();
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
    public ResultSet seleciona(String tabela)
    {
        String query = "SELECT * FROM "+tabela+";";

        return  GerenciarConexao.executarQuery(query);
    }

    // Seleciona uma tabela com apenas uma condição
    public ResultSet seleciona(String tabela, String condicao, String valor)
    {
        String query = "SELECT * FROM "+tabela+" WHERE "+condicao+" = '"+valor+"';";

        return GerenciarConexao.executarQuery(query);
    }

    // Seleciona uma tabela com inumeras condições
    public ResultSet seleciona(String tabela, ArrayList<String> condicoes, ArrayList<String> valores)
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

        return GerenciarConexao.executarQuery(query);
    }

    // Insere em uma tabela com os valores em ordem
    public ResultSet insere(String tabela, ArrayList<String> valores)
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

        return GerenciarConexao.executarQuery(query);
    }

    public ResultSet altera()
    {
        return null;
    }

    public ResultSet deleta()
    {
        return null;
    }
}

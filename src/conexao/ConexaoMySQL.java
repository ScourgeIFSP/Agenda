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
            if (con == null)
            {
                // Configurações de conexão MySQL
                String url = "jdbc:mysql://" + Acesso.getServidor() + "/" + Acesso.getBanco();
                String driverName = "com.mysql.jdbc.Driver";
                Class.forName(driverName);
                con = DriverManager.getConnection(url, Acesso.getUsuario(), Acesso.getSenha());

                System.out.println("Conectado com Sucesso!");
            }
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
    public ResultSet selecionar(String tabela)
    {
        String query = "SELECT * FROM "+tabela+";";

        return  GerenciarConexao.executarQuery(query);
    }

    // Seleciona uma tabela com apenas uma condição
    public ResultSet selecionar(String tabela, String condicao, String valor)
    {
        String query = "SELECT * FROM "+tabela+" WHERE "+condicao+" = '"+valor+"';";

        return GerenciarConexao.executarQuery(query);
    }

    // Seleciona uma tabela com inumeras condições
    public ResultSet selecionar(String tabela, ArrayList<String> condicoes, ArrayList<String> valores)
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
    public Integer inserir(String tabela, ArrayList<String> campos, ArrayList<String> valores)
    {
        String query = "INSERT INTO "+tabela+" (";

        for(String campo : campos)
        {
            query += campo;
            if(!campo.equals(campos.get(campos.size()-1)))
            {
                query += ", ";
            }
            else
            {
                query += ")";
            }
        }

        query += " VALUES ('";

        for(String valor : valores)
        {
            query += valor;
            if(!valor.equals(valores.get(valores.size()-1)))
            {
                query += "', '";
            }
            else
            {
                query += "');";
            }
        }

        return GerenciarConexao.exercutarUpdate(query);
    }

    // Altera registro de uma tabela com inumeras condições
    public Integer alterar(String tabela, ArrayList<String> campos, ArrayList<String> alteracoes, ArrayList<String> condicoes, ArrayList<String> valoresCondicoes)
    {
        String query = "UPDATE "+tabela+" SET ";

        int i = 0;
        for(String campo : campos)
        {
            String alteracao = alteracoes.get(i);
            query += campo+" = "+alteracao;

            if(!campo.equals(campos.get(campos.size()-1)))
            {
                query += ", ";
            }
            else
            {
                query += " WHERE ";
            }

            i++;
        }

        i = 0;
        for(String condicao : condicoes)
        {
            String valorCondicao = valoresCondicoes.get(i);
            query += condicao+" = "+valorCondicao;

            if(!condicao.equals(condicoes.get(condicoes.size()-1)))
            {
                query += ", ";
            }
            else
            {
                query += ";";
            }

            i++;
        }

        return GerenciarConexao.exercutarUpdate(query);
    }

    // Deleta registro de uma tabela com inumeras condições
    public Integer deletar(String tabela, ArrayList<String> condicoes, ArrayList<String> valoresCondicoes)
    {
        String query = "DELETE FROM "+tabela+" WHERE ";

        int i = 0;
        for(String condicao : condicoes)
        {
            String valorCondicao = valoresCondicoes.get(i);
            query += condicao+" = "+valorCondicao;
            if(!condicao.equals(condicoes.get(condicoes.size() - 1)))
            {
                query += ", ";
            }
            else
            {
                query += ");";
            }

            i++;
        }

        return GerenciarConexao.exercutarUpdate(query);
    }

    // Retorna último ID inserido de uma tabela
    public int ultimoId(String tabela)
    {
        String query = "SELECT * FROM "+tabela+" ORDER BY 1 DESC LIMIT 1;";

        ResultSet linhaId = GerenciarConexao.executarQuery(query);
        int id = 0;

        try
        {
            while (linhaId.next())
            {
                id = linhaId.getInt(1);
            }
        }
        catch(SQLException sqle)
        {
            System.out.println("SQL Exception (ultimoId()). Mensagem: "+sqle.getMessage() );
        }

        return id;
    }
}

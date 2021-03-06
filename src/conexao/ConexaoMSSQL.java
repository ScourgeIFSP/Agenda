package conexao;

import java.sql.*;
import java.util.*;

public class ConexaoMSSQL
{
    Connection conn = null;

    public Connection conectar()
    {
        String url="jdbc:sqlserver://"+Acesso.getServidor()+ "/" + Acesso.getBanco();

        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

            conn = DriverManager.getConnection(url,Acesso.getUsuario(),Acesso.getSenha());

            System.out.print("Conectado com sucesso");
        }
        catch (SQLException e)
        {
            System.out.print(e);
        }catch (Exception e1)
        {
            System.out.print("Não possível conectar");

        }
        return null;
    }

    public boolean encerrar()
    {
        try
        {
            conn.close();
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
        String query = "SELECT * FROM "+tabela+"";

        return  GerenciarConexao.executarQuery(query);
    }

    // Seleciona uma tabela com apenas uma condição
    public ResultSet selecionar(String tabela, String condicao, String valor)
    {
        String query = "SELECT * FROM "+tabela+" WHERE "+condicao+" = '"+valor+"'";

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

        }

        return GerenciarConexao.executarQuery(query);
    }

    // Insere registros em uma tabela
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
                query += "')";
            }
        }

        return GerenciarConexao.executarUpdate(query);
    }

    // Altera registro de uma tabela com inumeras condições
    public Integer alterar(String tabela, ArrayList<String> campos, ArrayList<String> alteracoes, ArrayList<String> condicoes, ArrayList<String> valoresCondicoes)
    {
        String query = "UPDATE "+tabela+" SET ";

        int i = 0;
        for(String campo : campos)
        {
            String alteracao = alteracoes.get(i);
            query += campo+" = '"+alteracao;

            if(!campo.equals(campos.get(campos.size()-1)))
            {
                query += "', ";
            }
            else
            {
                query += "' WHERE ";
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

        }

            i++;
        }

        return GerenciarConexao.executarUpdate(query);
    }

    // Deleta registro de uma tabela com apenas uma condição
    public Integer deletar(String tabela, String condicao, String valor)
    {
        String query = "DELETE FROM "+tabela+" WHERE "+condicao+" = '"+valor+"'";

        return GerenciarConexao.executarUpdate(query);
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
                query += ")";
            }

            i++;
        }

        return GerenciarConexao.executarUpdate(query);
    }

    // Retorna último ID inserido de uma tabela
    public int ultimoId(String tabela)
    {
        String query = "SELECT TOP 1 * FROM "+tabela+" ORDER BY 1 DESC";

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

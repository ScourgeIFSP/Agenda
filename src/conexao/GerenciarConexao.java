package conexao;

import java.sql.*;

public abstract class GerenciarConexao
{
    private static Conexao conexao;

    // Métodos
    public static ResultSet executarQuery(String query)
    {
        try
        {
            Statement st = conexao.conectar().createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("Query: "+query);
            return rs;
        }
        catch (SQLException sqle)
        {
            System.out.println("Query não foi executada. Mensagem: "+sqle);
            return null;
        }
    }

    // Getters
    public static Conexao getConexao()
    {
        return conexao;
    }

    // Setters
    public static void setConexao(Conexao conexao)
    {
        GerenciarConexao.conexao = conexao;
    }
}
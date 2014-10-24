package agenda;

import conexao.ConexaoMySQL;
import java.sql.*;

public class GerenciaContato
{
    public static ResultSet retornarTabelaContato()
    {
        String query = "SELECT * FROM contato";
        ResultSet resultado = rodarQuery(query);

        return resultado;
    }

    public static ResultSet retornarContato(int id)
    {
        String query = "SELECT * FROM contato WHERE ContatoId ="+id;
        ResultSet resultado = rodarQuery(query);

        return resultado;
    }

    public static ResultSet rodarQuery(String query)
    {
        Statement st;
        ResultSet rs;
        try
        {
            st = ConexaoMySQL.conectar().createStatement();
            rs = st.executeQuery(query);
            return rs;
        }
        catch (SQLException sqle)
        {
            return null;
        }
    }

}

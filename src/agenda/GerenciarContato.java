package agenda;

import conexao.*;

import java.sql.*;

public abstract class GerenciarContato
{
    private static Conexao conexao = GerenciarConexao.getConexao();

    // Métodos
    public static ResultSet retornarContato()
    {
        String query = conexao.seleciona("contato");

        return GerenciarConexao.executarQuery(query);
    }

    public static ResultSet retornarContato(int id)
    {
        String query = conexao.seleciona("contato","ContatoId",String.valueOf(id));

        return GerenciarConexao.executarQuery(query);
    }
}

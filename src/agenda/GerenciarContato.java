package agenda;

import conexao.*;

import java.sql.*;
import java.util.*;

public abstract class GerenciarContato
{
    private static Conexao conexao = GerenciarConexao.getConexao();

    // Métodos
    public static ResultSet retornarTabelaContato()
    {
        String query = conexao.seleciona("contato");

        return GerenciarConexao.executarQuery(query);
    }

    public static ResultSet retornarContato(int id)
    {
        String query = conexao.seleciona("contato","ContatoId",String.valueOf(id));

        return GerenciarConexao.executarQuery(query);
    }

    public static ResultSet retornarTelefonesContato(int id)
    {
        String query = conexao.seleciona("telefone","Contato_ContatoId",String.valueOf(id));

        return GerenciarConexao.executarQuery(query);
    }

    public static ResultSet inserirContato()
    {
        ArrayList<String> infoContato = new ArrayList<String>();
        infoContato.add(null);
        infoContato.add("");
        String query = conexao.insere("contato", infoContato);

        return GerenciarConexao.executarQuery(query);
    }
}

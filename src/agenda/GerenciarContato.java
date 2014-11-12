package agenda;

import conexao.*;

import java.sql.*;
import java.util.*;

public abstract class GerenciarContato
{
    // Conexao atual
    private static Conexao conexao = GerenciarConexao.getConexao();

    // Retora a tabela Contato
    public static ResultSet retornarContatos()
    {
        String query = conexao.seleciona("contato");

        return GerenciarConexao.executarQuery(query);
    }

    // Retorna um único Contato através do Id
    public static ResultSet retornarContato(int id)
    {
        String query = conexao.seleciona("contato","ContatoId",String.valueOf(id));

        return GerenciarConexao.executarQuery(query);
    }

    // Retorna os telefones do contato através do Id
    public static ResultSet retornarTelefonesContato(int id)
    {
        String query = conexao.seleciona("telefone","Contato_ContatoId",String.valueOf(id));

        return GerenciarConexao.executarQuery(query);
    }

    // Retorna os e-mails do contato através do Id
    public static ResultSet retornarEmailsContato(int id)
    {
        // Fazer
        return null;
    }

    // Insere um contato
    public static ResultSet inserirContato(ArrayList<String> infoContato)
    {
        String query = conexao.insere("contato", infoContato);

        return GerenciarConexao.executarQuery(query);
    }

    // Insere um contato
    public static ResultSet pesquisarContato(String nome)
    {
        // Fazer
        return null;
    }

    // Insere um contato
    public static ResultSet editarContato(int id, ArrayList<String> modificacoes)
    {
        // Fazer
        return null;
    }

    // Insere um contato
    public static ResultSet deletarContato(int id)
    {
        // Fazer
        return null;
    }
}

package agenda;

import conexao.*;

import java.sql.*;
import java.util.*;

public abstract class GerenciarContato
{
    // Conexao atual
    private static Conexao conexao = GerenciarConexao.getConexao();

    // Retora a tabela Contato
    public static ArrayList<Contato> retornarContatos()
    {
        ArrayList<Contato> contatos = new ArrayList<>();

        if(conexao!=null)
        {
            try
            {
                ResultSet linha = conexao.seleciona("contato");

                while (linha.next())
                {
                    contatos.add(retornarContato(linha.getInt("ContatoId")));
                }
            }
            catch (SQLException sqle)
            {
                System.out.println(sqle.getMessage());
            }
        }
        else
        {
            contatos.add(retornarContato(0));
        }

        return contatos;
    }

    // Retorna um único Contato através do Id
    public static Contato retornarContato(int id)
    {
        //String query = conexao.seleciona("contato","ContatoId",String.valueOf(id));

        Contato contato;
        String nome = null;
        ArrayList<String> telefones = null;
        ArrayList<String> emails = null;
        String endereco = null;
        String cidade = null;

        if(GerenciarConexao.getConexao()!=null)
        {
            try
            {
                ResultSet linhaContato = conexao.seleciona("contato","ContatoId",String.valueOf(id));
                while (linhaContato.next())
                {
                    nome = linhaContato.getString("ContatoNome");
                    endereco = linhaContato.getString("ContatoEndereco");
                    cidade = linhaContato.getString("ContatoCidade");
                }
            }
            catch (SQLException sqle)
            {
                System.out.println(sqle.getMessage());
            }
        }
        else
        {
            nome = "Sem conexao!";
        }

        contato = new Contato(id, nome, telefones, emails, endereco, cidade);

        return contato;
    }

    // Retorna os telefones do contato através do Id
    public static ArrayList<String> retornarTelefonesContato(int id)
    {
        // ToDo
        return null;
    }

    // Retorna os e-mails do contato através do Id
    public static ResultSet retornarEmailsContato(int id)
    {
        // ToDo
        return null;
    }

    // Insere um contato
    public static void inserirContato(ArrayList<String> infoContato)
    {
        conexao.insere("contato", infoContato);
    }

    // Pesquisa um contato
    public static ArrayList<Contato> pesquisarContato(String nome)
    {
        // ToDo
        return null;
    }

    // Edita um contato
    public static Boolean editarContato(int id, ArrayList<String> modificacoes)
    {
        // ToDo
        return null;
    }

    // Deleta um contato
    public static Boolean deletarContato(int id)
    {
        // ToDo
        return null;
    }
}

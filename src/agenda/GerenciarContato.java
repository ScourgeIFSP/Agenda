package agenda;

import conexao.*;

import java.sql.*;
import java.util.*;

public abstract class GerenciarContato
{
    // Conexao atual
    private static Conexao conexao = GerenciarConexao.getConexao();

    // Retora a tabela Contato
    public static ArrayList<Contato> retornarContatos(int idAgenda)
    {
        ArrayList<Contato> contatos = new ArrayList<>();

        if(conexao!=null)
        {
            try
            {
                ResultSet linha = conexao.selecionar("contato", "Agenda_AgendaId", String.valueOf(idAgenda));

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
    public static Contato retornarContato(int idContato)
    {
        Contato contato;
        String stringIdContato = String.valueOf(idContato);

        String nome = "";
        ArrayList<String> telefones = new ArrayList<>();
        ArrayList<String> emails = new ArrayList<>();
        String endereco = "";
        String cidade = "";

        if(conexao!=null)
        {
            try
            {
                ResultSet linhaContato = conexao.selecionar("contato", "ContatoId", stringIdContato);
                while (linhaContato.next())
                {
                    nome = linhaContato.getString("ContatoNome");
                    endereco = linhaContato.getString("ContatoEndereco");
                    cidade = linhaContato.getString("ContatoCidade");
                }

                ResultSet linhaContatoTelefone = conexao.selecionar("telefone", "Contato_ContatoId", stringIdContato);
                while (linhaContatoTelefone.next())
                {
                    String telefone = linhaContatoTelefone.getString("Telefone");
                    telefones.add(telefone);
                }

                ResultSet linhaContatoEmail = conexao.selecionar("email", "Contato_ContatoId", stringIdContato);
                while (linhaContatoEmail.next())
                {
                    String email = linhaContatoEmail.getString("Telefone");
                    emails.add(email);
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

        contato = new Contato(idContato, nome, telefones, emails, endereco, cidade);

        return contato;
    }

    // Insere um contato
    public static Boolean inserirContato(ArrayList<String> infoContato)
    {
        // ToDo
        conexao.inserir("contato", infoContato);

        return null;
    }

    // Pesquisa um contato
    public static ArrayList<Contato> pesquisarContato(String nome)
    {
        // ToDo
        return null;
    }

    // Edita um contato
    public static Boolean editarContato(int idContato, ArrayList<String> modificacoes)
    {
        // ToDo
        return null;
    }

    // Deleta um contato
    public static Boolean deletarContato(int idContato)
    {
        // ToDo
        return null;
    }
}

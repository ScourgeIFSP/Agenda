package agenda;

import conexao.*;
import gui.JanelaPrincipal;

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
                    String email = linhaContatoEmail.getString("Email");
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
    public static Boolean inserirContato(Contato contato)
    {
        String nome = contato.getNome();
        ArrayList<String> telefones = contato.getTelefones();
        ArrayList<String> emails = contato.getEmails();
        String endereco = contato.getEndereco();
        String cidade = contato.getCidade();

        // Insere registro na tabela contato
        ArrayList<String> campos = new ArrayList<>();
        campos.add("ContatoNome");
        campos.add("ContatoEndereco");
        campos.add("ContatoCidade");
        campos.add("Agenda_AgendaId");

        ArrayList<String> infoContato = new ArrayList<>();
        infoContato.add(nome);
        infoContato.add(endereco);
        infoContato.add(cidade);
        infoContato.add(String.valueOf(JanelaPrincipal.idAgenda));

        conexao.inserir("contato", campos, infoContato);

        int id = conexao.ultimoId("contato");

        // Insere registro na tabela telefone
        campos = new ArrayList<>();
        campos.add("Telefone");
        campos.add("Contato_ContatoId");

        for (String telefone : telefones)
        {
            infoContato = new ArrayList<>();
            infoContato.add(telefone);
            infoContato.add(String.valueOf(id));

            conexao.inserir("telefone", campos, infoContato);
        }

        // Insere registro na tabela email
        campos = new ArrayList<>();
        campos.add("Email");
        campos.add("Contato_ContatoId");

        for (String email : emails)
        {
            infoContato = new ArrayList<>();
            infoContato.add(email);
            infoContato.add(String.valueOf(id));

            conexao.inserir("email", campos, infoContato);
        }

        return null;
    }

    // Edita um contato
    public static Boolean editarContato(Contato contato)
    {
        String contatoId = String.valueOf(contato.getId());

        ArrayList<String> campos = new ArrayList<>();
        campos.add("ContatoNome");
        campos.add("ContatoEndereco");
        campos.add("ContatoCidade");
        ArrayList<String> alteracoes = new ArrayList<>();
        alteracoes.add(contato.getNome());
        alteracoes.add(contato.getEndereco());
        alteracoes.add(contato.getCidade());

        ArrayList<String> condicoes = new ArrayList<>();
        condicoes.add("ContatoId");
        ArrayList<String> valoresCondicoes = new ArrayList<>();
        valoresCondicoes.add(contatoId);

        conexao.alterar("contato",campos,alteracoes,condicoes,valoresCondicoes);
        conexao.deletar("telefone","Contato_ContatoId",contatoId);
        conexao.deletar("email","Contato_ContatoId",contatoId);

        campos = new ArrayList<>();
        campos.add("Telefone");
        campos.add("Contato_ContatoId");
        alteracoes = new ArrayList<>();
        alteracoes.add(contato.getTelefones().get(0));
        alteracoes.add(contatoId);
        conexao.inserir("telefone",campos,alteracoes);
        alteracoes = new ArrayList<>();
        alteracoes.add(contato.getTelefones().get(1));
        alteracoes.add(contatoId);
        conexao.inserir("telefone",campos,alteracoes);

        campos = new ArrayList<>();
        campos.add("Email");
        campos.add("Contato_ContatoId");
        alteracoes = new ArrayList<>();
        alteracoes.add(contato.getEmails().get(0));
        alteracoes.add(contatoId);
        conexao.inserir("email",campos,alteracoes);
        alteracoes = new ArrayList<>();
        alteracoes.add(contato.getEmails().get(1));
        alteracoes.add(contatoId);
        conexao.inserir("email",campos,alteracoes);

        return null;
    }

    // Deleta um contato
    public static Boolean deletarContato(int idContato)
    {
        conexao.deletar("telefone", "Contato_ContatoId", String.valueOf(idContato));
        conexao.deletar("email", "Contato_ContatoId", String.valueOf(idContato));
        conexao.deletar("contato", "ContatoId", String.valueOf(idContato));

        return null;
    }
}

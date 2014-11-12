package agenda;

import conexao.*;

import java.sql.*;
import java.util.*;

public class Contato
{
    // Atributos do Contato
    private final int id;
    private String nome;
    private ArrayList<String> telefones;
    private ArrayList<String> emails;
    private String endereco;
    private String cidade;

    // Construtor
    public Contato(int id)
    {
        this.id = id;
        if(GerenciarConexao.getConexao()!=null)
        {
            try {
                ResultSet linhaContato = GerenciarContato.retornarContato(this.id);
                while (linhaContato.next()) {
                    this.nome = linhaContato.getString("ContatoNome");
                    this.endereco = linhaContato.getString("ContatoEndereco");
                    this.cidade = linhaContato.getString("ContatoCidade");
                }
            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
            }
        }
        else
        {
            this.nome = "Sem conexao!";
        }
    }
    
    // Getters
    public int getId()
    {
        return id;
    }
    public String getNome() 
    {
        return nome;
    }
    public ArrayList<String> getTelefones()
    {
        return telefones;
    }
    public ArrayList<String> getEmails()
    {
        return emails;
    }
    public String getEndereco() 
    {
        return endereco;
    }
    public String getCidade() 
    {
        return cidade;
    }
    
    // Setters
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    public void setTelefones(ArrayList<String> telefones)
    {
        this.telefones = telefones;
    }
    public void setEmails(ArrayList<String> emails)
    {
        this.emails = emails;
    }
    public void setEndereco(String endereco) 
    {
        this.endereco = endereco;
    }
    public void setCidade(String cidade) 
    {
        this.cidade = cidade;
    }
}

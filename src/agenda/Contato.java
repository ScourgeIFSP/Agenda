package agenda;

import java.util.*;

public class Contato
{
    // Atributos do Contato
    private int id;
    private String nome;
    private ArrayList<String> telefones;
    private ArrayList<String> emails;
    private String endereco;
    private String cidade;

    // Construtor
    public Contato(int id, String nome, ArrayList<String> telefones, ArrayList<String> emails, String endereco, String cidade)
    {
        this.id = id;
        this.nome = nome;
        this.telefones = telefones;
        this.emails = emails;
        this.endereco = endereco;
        this.cidade = cidade;
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

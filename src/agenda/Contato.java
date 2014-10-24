package agenda;

import java.sql.*;
import java.util.ArrayList;

public class Contato
{
    private final int id;
    private String nome;
    private ArrayList<String> telefone;
    private ArrayList<String> email;
    private String endereco;
    private String cidade;
    
    public Contato(int id)
    {
        this.id = id;
        try
        {
            ResultSet linha = GerenciaContato.retornarContato(this.id);
            while (linha.next())
            {
                this.nome = linha.getString(2);
            }
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }
        // Select na tabela contato através do id, preenche os atributos da classe com o resultado
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

    public ArrayList<String> getTelefone()
    {
        return telefone;
    }
    
    public ArrayList<String> getEmail()
    {
        return email;
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

    public void setTelefone(ArrayList<String> telefone)
    {
        this.telefone = telefone;
    }
    
    public void setEmail(ArrayList<String> email)
    {
        this.email = email;
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

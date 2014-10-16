package agenda;

public class Contato 
{
    private final int id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private String cidade;
    
    public Contato(int id)
    {
        // Select na tabela contato através do id, preenche os atributos da classe com o resultado
        this.id = id;
    }
    
    // Getters
    public String getNome() 
    {
        return nome;
    }

    public String getTelefone() 
    {
        return telefone;
    }
    
    public String getEmail()
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

    public void setTelefone(String telefone) 
    {
        this.telefone = telefone;
    }
    
    public void setEmail(String email)
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

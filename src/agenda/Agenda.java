package agenda;

public class Agenda 
{
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String telefone;
    private String cep;
    private String cpf;
    
    public Agenda()
    {
        nome = "";
        endereco="";
        bairro="";
        cidade="";
        telefone ="";
        cep="";
        cpf="";
    }
    
    // Getters
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

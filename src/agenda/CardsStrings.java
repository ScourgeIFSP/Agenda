package agenda;

public abstract class CardsStrings
{
    // Strings referente aos cards do Painel Principal
    private static final String listarContatos = "listar";
    private static final String adicionarContatos = "adicionar";
    private static final String contato = "contato";
    
    // Getters
    public static String getListarContatosCard()
    {
        return listarContatos;
    }

    public static String getAdicionarContatosCard()
    {
        return adicionarContatos;
    }

    public static String getContatoCard()
    {
        return contato;
    }
}

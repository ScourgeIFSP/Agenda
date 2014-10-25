package conexao;

public abstract class Acesso
{
    private static String servidor = "localhost";
    private static String banco = "agenda";
    private static String usuario = "root";
    private static String senha = "";

    public static String getServidor()
    {
        return servidor;
    }

    public static String getBanco()
    {
        return banco;
    }

    public static String getUsuario()
    {
        return usuario;
    }

    public static String getSenha()
    {
        return senha;
    }
}

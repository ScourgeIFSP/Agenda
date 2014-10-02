package agenda;

public class Main 
{
    public static void main(String args[])
    {
      JanelaPrincipal form = new JanelaPrincipal();
      form.setVisible(true);
      Conexao conn = new Conexao();
      conn.Conecta();
    }
}

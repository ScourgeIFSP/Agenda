package agenda;

public class Main 
{
    public static void main(String args[])
    {
      JanelaPrincipal jp = new JanelaPrincipal();
      jp.setVisible(true);
      
      Conexao conn = new Conexao();
      conn.conecta();
    }
}

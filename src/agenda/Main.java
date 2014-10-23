package agenda;

import conexao.ConexaoMySQL;

public class Main
{
    public static void main(String args[])
    {
        ConexaoMySQL.conecta();
        JanelaPrincipal jp = new JanelaPrincipal();
        jp.setVisible(true);
        ConexaoMySQL.encerra();
    }
}

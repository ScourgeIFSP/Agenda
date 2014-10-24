package agenda;

import conexao.ConexaoMySQL;

public class Principal
{
    public static void main(String args[])
    {
        ConexaoMySQL.conecta();
        JanelaPrincipal jp = new JanelaPrincipal();
        jp.setVisible(true);
        ConexaoMySQL.encerra();
    }
}

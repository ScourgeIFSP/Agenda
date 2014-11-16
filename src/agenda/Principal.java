package agenda;

import conexao.*;

public class Principal
{
    public static void main(String args[])
    {
        // Seleciona o banco
        GerenciarConexao.setConexao(new ConexaoMySQL());

        // Abre a janela
        JanelaPrincipal jp = new JanelaPrincipal(3);
        jp.setVisible(true);
    }
}

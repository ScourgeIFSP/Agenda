package agenda;

import java.awt.*;
import javax.swing.*;

public abstract class CardsStrings
{
    // Strings referente aos cards do Painel Principal
    private static final JPanel painelPrincipal = new JPanel();
    private static final String listarContatos = "listar";
    private static final String adicionarContatos = "adicionar";

    // Mostra painel desejado
    public static void mostrarPainel(String card)
    {
        CardLayout cl = (CardLayout)(painelPrincipal.getLayout());
        cl.show(painelPrincipal, card);
    }
    
    // Getters
    public static JPanel getPainelPrincipal()
    {
        return painelPrincipal;
    }
    
    public static String getListarContatosCard()
    {
        return listarContatos;
    }

    public static String getAdicionarContatosCard()
    {
        return adicionarContatos;
    }
}

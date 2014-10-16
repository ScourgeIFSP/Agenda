package agenda;

import java.awt.*;
import javax.swing.*;

public abstract class CardsStrings
{
    // Strings referente aos cards do Painel Principal
    private static final JPanel painelPrincipal = new JPanel();
    private static final String listaString = "contatos";
    private static final String adicionarContatosString = "adicionar";
    
    public static void mostraCard(String card)
    {
        CardLayout cl = (CardLayout)(painelPrincipal.getLayout());
        cl.show(painelPrincipal, card);
    }
    
    // Getters
    public static JPanel getPainelPrincipal()
    {
        return painelPrincipal;
    }
    
    public static String getListaCard()
    {
        return listaString;
    }

    public static String getAdicionarContatosCard()
    {
        return adicionarContatosString;
    }
}

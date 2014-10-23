package agenda;

import java.awt.*;
import javax.swing.*;

public class JanelaPrincipal extends JFrame 
{
    // Variáveis globais
    private final Container janela = this.getContentPane();
    private JPanel painelPrincipal;
    private PainelMenu painelMenu;
    private PainelAdicionar painelAdicionar;
    private PainelListar painelListar;

    // Contrutor
    public JanelaPrincipal()
    {
        this.setTitle("Agenda");
        this.setMinimumSize(new Dimension(700, 500));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setLayout(new GridBagLayout());
        
        adcComponentes();
    }
    
    // Adiciona componentes na janela
    private void adcComponentes()
    {
        // Definindo variáveis
        painelPrincipal = CardsStrings.getPainelPrincipal();
        painelMenu = new PainelMenu();
        painelListar = new PainelListar();
        painelAdicionar = new PainelAdicionar();

        // Painel de menu
        GridBagConstraints cons = new GridBagConstraints();
        cons.insets = new Insets(5,5,5,0);
        cons.weighty = 1;
        cons.fill = GridBagConstraints.BOTH;
        janela.add(painelMenu,cons);
        
        // Painel principal
        painelPrincipal.setLayout(new CardLayout());
        cons.insets = new Insets(5,5,5,5);
        cons.weightx = 1;
        cons.ipadx = 0;
        cons.gridx = 1;
        cons.gridheight = GridBagConstraints.REMAINDER;
        janela.add(painelPrincipal, cons);
        
        // Adicionando cards
        painelPrincipal.add(painelListar, CardsStrings.getListarContatosCard());
        painelPrincipal.add(painelAdicionar, CardsStrings.getAdicionarContatosCard());
    }
}

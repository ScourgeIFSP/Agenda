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
    private PainelLista painelLista;
    
    // Contrutor
    public JanelaPrincipal() 
    {
        super("Agenda");
        this.setMinimumSize(new Dimension(700, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        janela.setLayout(new GridBagLayout());
        
        adcComponentes();
    }
    
    // Adiciona componentes na janela
    private void adcComponentes()
    {
        // Definindo variáveis
        painelPrincipal = new JPanel();
        painelMenu = new PainelMenu(painelPrincipal);
        painelLista = new PainelLista();
        painelAdicionar = new PainelAdicionar();
        GridBagConstraints cons = new GridBagConstraints();
        
        // Painel de menu
        cons.insets = new Insets(5,5,5,0);
        cons.weighty = 1;
        cons.fill = GridBagConstraints.BOTH;
        janela.add(painelMenu,cons);
        
        // Painel principal
        painelPrincipal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        painelPrincipal.setLayout(new CardLayout());
        cons.insets = new Insets(5,5,5,5);
        cons.weightx = 1;
        cons.ipadx = 0;
        cons.gridx = 1;
        cons.gridheight = GridBagConstraints.REMAINDER;
        janela.add(painelPrincipal, cons);
            painelPrincipal.add(painelLista, CardsStrings.getListaString());
            painelPrincipal.add(painelAdicionar, CardsStrings.getAdicionarContatosString());
    }
}

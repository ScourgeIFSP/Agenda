package agenda;

import java.awt.*;
import javax.swing.*;

public class JanelaPrincipal extends JFrame 
{
    // Variáveis globais
    private final Container janela = this.getContentPane();
    private JPanel painelPrincipal;
    private PainelMenu painelMenu;
    private PainelImagem painelImagem;
    private PainelAdicionar painelAdicionar;
    private PainelLista painelLista;
    
    // Contrutor
    public JanelaPrincipal() 
    {
        super("Agenda");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        janela.setLayout(new GridBagLayout());
        
        adcComponentes();
    }
    
    // Adiciona componentes na janela
    private void adcComponentes()
    {
        GridBagConstraints cons = new GridBagConstraints();
        
        painelPrincipal = new JPanel();
        painelMenu = new PainelMenu(painelPrincipal);
        painelImagem = new PainelImagem();
        painelAdicionar = new PainelAdicionar();
        painelLista = new PainelLista();
        
        // Painel principal
        painelPrincipal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        painelPrincipal.setLayout(new CardLayout());
        cons.insets = new Insets(5,5,5,5);
        cons.weighty = 1;
        cons.weightx = 1;
        cons.gridx = 1;
        cons.gridheight = GridBagConstraints.REMAINDER;
        cons.fill = GridBagConstraints.BOTH;
        janela.add(painelPrincipal, cons);
            painelPrincipal.add(painelLista, CardsStrings.getListaString());
            painelPrincipal.add(painelAdicionar, CardsStrings.getAdicionarContatosString());
        
        // Painel de menu
        cons.insets = new Insets(5,5,5,0);
        cons.weightx = 0;
        cons.gridy = 1;
        cons.gridx = 0;
        cons.ipadx = 15;
        cons.gridheight = 1;
        janela.add(painelMenu,cons);
        
        // Painel de imagem
        cons.insets = new Insets(5,5,0,0);
        cons.weighty = 0;
            // Temporário
            cons.ipady = 130;
        cons.gridy = 0;
        janela.add(painelImagem,cons);
    }
}

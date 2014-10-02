package agenda;

import java.awt.*;
import javax.swing.*;

public class JanelaPrincipal extends JFrame 
{
    // Variáveis globais
    String listaString = "lista", formularioString = "formulario";
    private final Container janela = this.getContentPane();
    private JPanel painelPrincipal = new JPanel();
    private PainelMenu painelMenu = new PainelMenu(painelPrincipal);
    private PainelCima painelImagem = new PainelCima();
    private PainelLista painelLista = new PainelLista();
    private PainelFormulario painelFormulario = new PainelFormulario();
    
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
    
    // Adiciona componentes
    private void adcComponentes()
    {
        GridBagConstraints cons = new GridBagConstraints();
        
        // Painel principal
        painelPrincipal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        painelPrincipal.setLayout(new CardLayout());
        cons.weighty =2;
        cons.weightx =1;
        cons.gridx =1;
        cons.fill = GridBagConstraints.BOTH;
        cons.gridheight = GridBagConstraints.REMAINDER;
        cons.insets = new Insets(3,2,3,2);
        janela.add(painelPrincipal, cons);
            painelPrincipal.add(painelLista, listaString);
            painelPrincipal.add(painelFormulario, formularioString);
        
        // Painel de menu
        cons.weightx =0;
        cons.weighty = 0;
        cons.gridy = 1;
        cons.gridx = 0;
        cons.fill = GridBagConstraints.VERTICAL;
        cons.ipadx = 30;
        cons.gridheight = 1;
        janela.add(painelMenu,cons);
        
        // Painel de imagem
        cons.weighty =0;
        cons.gridy = 0;
        cons.ipady = 130;       
        cons.fill = GridBagConstraints.BOTH;
        janela.add(painelImagem,cons);
    }
}

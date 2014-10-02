package agenda;

import java.awt.*;
import javax.swing.*;

public class JanelaPrincipal extends JFrame 
{
    String listaString = "lista";
    String formularioString = "formulario";
    private final Container janela = this.getContentPane();
    private JPanel painelPrincipal = new JPanel();
    private PainelMenu painelMenu = new PainelMenu(painelPrincipal);
    private PainelCima painelCima = new PainelCima();
    private PainelFormulario painelFormulario = new PainelFormulario();
    private PainelLista painelLista = new PainelLista();

    public JanelaPrincipal() 
    {
        super("Agenda");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        janela.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        
        painelPrincipal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        CardLayout cardLayout = new CardLayout();
        painelPrincipal.setLayout(cardLayout);
        cons.weighty =2;
        cons.weightx =1;
        cons.gridx =1;
        cons.fill = GridBagConstraints.BOTH;
        cons.gridheight = GridBagConstraints.REMAINDER;
        cons.insets = new Insets(3,2,3,2);
        janela.add(painelPrincipal, cons);
        painelPrincipal.add(painelLista, listaString);
        painelPrincipal.add(painelFormulario, formularioString);
        
        
        cons.weightx =0;
        cons.weighty = 0;
        cons.gridy = 1;
        cons.gridx = 0;
        cons.fill = GridBagConstraints.VERTICAL;
        cons.ipadx = 30;
        cons.gridheight = 1;
        janela.add(painelMenu,cons);
  
        
        cons.weighty =0;
        cons.gridy = 0;
        cons.ipady = 130;       
        cons.fill = GridBagConstraints.BOTH;
        janela.add(painelCima,cons);
    }
}

package agenda;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;

public class Formulario extends JFrame {

    PainelPrincipal painelPrincipal = new PainelPrincipal();
    PainelMenu painelMenu = new PainelMenu();
    PainelCima painelcima = new PainelCima();

    public Formulario() {
        super("Formulario");
        getContentPane().setLayout(new GridBagLayout());
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        GridBagConstraints cons = new GridBagConstraints();

        cons.weighty =2;
        cons.weightx =1;
        cons.gridx =1;
        cons.fill = GridBagConstraints.BOTH;
        cons.gridheight = GridBagConstraints.REMAINDER;
        cons.insets = new Insets(3,2,3,2);
        add(painelPrincipal, cons);
        
        
        cons.weightx =0;
        cons.weighty = 0;
        cons.gridy = 1;
        cons.gridx = 0;
        cons.fill = GridBagConstraints.VERTICAL;
        cons.ipadx = 30;
        cons.gridheight = 1;
        add(painelMenu,cons);
  
        
        cons.weighty =0;
        cons.gridy = 0;
        cons.ipady = 130;       
        cons.fill = GridBagConstraints.BOTH;
        add(painelcima,cons);
        
    }

}

package agenda;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PainelMenu extends JPanel 
{
    private CardLayout cardLayout;
    private JPanel painelPrincipal;
    private String listaString = "lista", formularioString = "formulario";
    private JButton btnAdicionar = new JButton("Adicionar");
    private JButton btnEditar = new JButton("Editar");
    private JButton btnExcluir = new JButton("Excluir");
    private JButton btnSair = new JButton("Sair");

    public PainelMenu(JPanel painelPrincipal) 
    {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        this.cardLayout = cardLayout;
        this.painelPrincipal = painelPrincipal;
        this.listaString = listaString;
        this.formularioString = formularioString;
        
        AddComponentes(btnAdicionar);
        AddComponentes(btnEditar);
        AddComponentes(btnExcluir);
        AddComponentes(btnSair);
        
        adcAcoes();
    }

    private void AddComponentes(JComponent componente) 
    {
        GridBagConstraints cons = new GridBagConstraints();

        cons.insets = new Insets(2, 2, 2, 2);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.weightx = 1;
        //cons.weighty = 1;
        cons.gridwidth = GridBagConstraints.REMAINDER;
        cons.ipady = 15;
        this.add(componente, cons);
    }
    
    private void adcAcoes()
    {
        btnAdicionar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                CardLayout cl = (CardLayout)(painelPrincipal.getLayout());
                cl.show(painelPrincipal, formularioString);
            }
        });
        
        btnSair.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
    }

}

package agenda;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PainelMenu extends JPanel 
{
    // Variáveis globais
    private JPanel painelPrincipal;
    private String contatosString = "contatos", formularioString = "formulario";
    private JButton btnContatos = new JButton("Contatos");
    private JButton btnAdicionar = new JButton("Adicionar");
    private JButton btnEditar = new JButton("Editar");
    private JButton btnExcluir = new JButton("Excluir");
    private JButton btnSair = new JButton("Sair");
    
    // Contrutor
    public PainelMenu(JPanel painelPrincipal) 
    {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        this.painelPrincipal = painelPrincipal;
        
        AddComponentes(btnContatos);
        AddComponentes(btnAdicionar);
        AddComponentes(btnEditar);
        AddComponentes(btnExcluir);
        AddComponentes(btnSair);
        
        adcAcoes();
    }
    
    // Adiciona um componente
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
    
    // Atribui ações aos botões
    private void adcAcoes()
    {
        btnContatos.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                CardLayout cl = (CardLayout)(painelPrincipal.getLayout());
                cl.show(painelPrincipal, contatosString);
            }
        });
        
        btnAdicionar.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                CardLayout cl = (CardLayout)(painelPrincipal.getLayout());
                cl.show(painelPrincipal, formularioString);
            }
        });
        
        btnSair.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
    }

}

package agenda;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PainelMenu extends JPanel 
{
    // Variáveis globais
    private final JPanel painelPrincipal;
    private JButton btnContatos;
    private JButton btnAdicionarContatos;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnSair;
    
    // Contrutor
    public PainelMenu(JPanel painelPrincipal) 
    {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        this.painelPrincipal = painelPrincipal;
        
        adcComponentes();
        adcAcoes();
    }
    
    // Adiciona um componente
    private void AddComponente(JComponent componente) 
    {
        GridBagConstraints cons = new GridBagConstraints();

        cons.insets = new Insets(2, 2, 2, 2);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.weightx = 1;
        cons.gridwidth = GridBagConstraints.REMAINDER;
        cons.ipady = 15;
        this.add(componente, cons);
    }
    
    // Adiciona componentes no painel
    private void adcComponentes()
    {
        btnContatos = new JButton("<html><center>Listar<br>Contatos</center></html>");
        btnAdicionarContatos = new JButton("<html><center>Adicionar<br>Contato</center></html>");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");
        btnSair = new JButton("Sair");
        
        AddComponente(btnContatos);
        AddComponente(btnAdicionarContatos);
        AddComponente(btnEditar);
        AddComponente(btnExcluir);
        AddComponente(btnSair);
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
                cl.show(painelPrincipal, CardsStrings.getListaString());
            }
        });
        
        btnAdicionarContatos.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                CardLayout cl = (CardLayout)(painelPrincipal.getLayout());
                cl.show(painelPrincipal, CardsStrings.getAdicionarContatosString());
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

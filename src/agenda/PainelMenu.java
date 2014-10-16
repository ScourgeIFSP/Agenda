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
        
        this.painelPrincipal = painelPrincipal;
        
        adcComponentes();
        adcAcoes();
    }
    
    // Adiciona componentes no painel
    private void adcComponentes()
    {
        // Definindo variáveis
        btnContatos = new JButton("<html><center>Listar<br>Contatos</center></html>");
        btnAdicionarContatos = new JButton("<html><center>Adicionar<br>Contato</center></html>");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");
        btnSair = new JButton("Sair");
        
        adcComponente(btnContatos);
        adcComponente(btnAdicionarContatos);
        adcComponente(btnEditar);
        adcComponente(btnExcluir);
        adcComponente(btnSair);
    }
    
    // Adiciona um componente
    private void adcComponente(JComponent componente) 
    {
        GridBagConstraints cons = new GridBagConstraints();
        cons.insets = new Insets(5,5,5,5);
        cons.weightx = 1;
        cons.ipady = 15;
        cons.ipadx = 15;
        cons.gridwidth = GridBagConstraints.REMAINDER;
        cons.fill = GridBagConstraints.HORIZONTAL;
        
        if (componente == btnSair)
        {
            cons.weighty = 1;
            cons.anchor = GridBagConstraints.NORTH;
        }
        
        this.add(componente, cons);
    }
    
    // Atribui ações aos botões
    private void adcAcoes()
    {
        btnContatos.addActionListener((ActionEvent e) ->
        {
            CardLayout cl = (CardLayout)(painelPrincipal.getLayout());
            cl.show(painelPrincipal, CardsStrings.getListaString());
        });
        
        btnAdicionarContatos.addActionListener((ActionEvent e) -> 
        {
            CardLayout cl = (CardLayout)(painelPrincipal.getLayout());
            cl.show(painelPrincipal, CardsStrings.getAdicionarContatosString());
        });
        
        btnSair.addActionListener((ActionEvent e) -> 
        {
            System.exit(0);
        });
    }
}

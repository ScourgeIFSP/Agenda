package agenda;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PainelMenu extends JPanel 
{
    // Variáveis globais
    private JButton btnContatos;
    private JButton btnAdicionarContatos;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnSair;
    
    // Contrutor
    public PainelMenu() 
    {
        this.setLayout(new GridBagLayout());
        
        adcComponentes();
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
        
        // Botões
        adcComponente(btnContatos, 0);
        adcComponente(btnAdicionarContatos, 1);
        adcComponente(btnEditar, 2);
        adcComponente(btnExcluir, 3);
        adcComponente(btnSair, 4);

        // Atribui ações aos botões
        btnContatos.addActionListener((ActionEvent e) ->
                CardsStrings.mostrarPainel(CardsStrings.getListarContatosCard()));

        btnAdicionarContatos.addActionListener((ActionEvent e) ->
                CardsStrings.mostrarPainel(CardsStrings.getAdicionarContatosCard()));

        btnSair.addActionListener((ActionEvent e) ->
                System.exit(0));
    }
    
    // Adiciona um componente
    private void adcComponente(JComponent componente, int i) 
    {
        GridBagConstraints cons = new GridBagConstraints();
        Dimension dim = new Dimension(0,50);
        cons.insets = new Insets(5,5,5,5);
        cons.weightx = 1;
        cons.ipadx = 15;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridy = i;
        
        if (componente == btnSair)
        {
            cons.weighty = 1;
            cons.anchor = GridBagConstraints.NORTH;
        }
        
        componente.setPreferredSize(dim);
        this.add(componente, cons);
    }
}

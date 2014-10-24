package agenda;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PainelAdicionar extends JPanel
{
    // Variáveis globais
    private TituloString tituloLabel = new TituloString("Incluir Contato: ");
    private JTextField txtnome = new JTextField();
    private JTextField txttelefone = new JTextField();
    private JTextField txtemail = new JTextField();
    private JTextField txtendereco = new JTextField();
    private JTextField txtcidade = new JTextField();
    private JPanel botoesPanel = new JPanel();
    private JButton adicionarButton = new JButton("Adicionar");
    private JButton cancelarButton = new JButton("Cancelar");
   
    // Contrutor
    public PainelAdicionar()
    {   
       this.setLayout(new GridBagLayout()); 
       
       adcComponentes();
    }
    
    // Adiciona componentes no painel
    private void adcComponentes()
    {
        // Definindo variáveis
        GridBagConstraints cons;
        
        // Título
        tituloLabel.adicionar(this);
        
        // Formulário
        adcCampo("Nome:", txtnome);
        adcCampo("Telefone:", txttelefone);
        adcCampo("E-mail:", txtemail);
        adcCampo("Endereço:", txtendereco);
        adcCampo("Cidade:", txtcidade);
        
        // Painel de botões
        cons = new GridBagConstraints();
        botoesPanel.setLayout(new GridBagLayout());
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.BOTH;
        cons.gridwidth = GridBagConstraints.REMAINDER;
        this.add(botoesPanel, cons);
        // Botões
        cons = new GridBagConstraints();
        cons.weighty = 1;
        cons.anchor = GridBagConstraints.NORTH;
        cons.insets = new Insets(10,4,4,4);
        adicionarButton.setPreferredSize(new Dimension(100,30));
        cancelarButton.setPreferredSize(new Dimension(100,30));
        botoesPanel.add(adicionarButton, cons);
        botoesPanel.add(cancelarButton, cons);

        // Adiciona ações aos botões
        adicionarButton.addActionListener((ActionEvent e) ->
        {

        });

        cancelarButton.addActionListener((ActionEvent e) ->
                JanelaPrincipal.mostrarPainel(CardsStrings.getListarContatosCard()));
    }
    
    // Adiciona um campo
    private void adcCampo(String label, JComponent componente)
    {  
        GridBagConstraints cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.WEST;
        cons.insets = new Insets(4,20,4,4);

        this.add(new JLabel(label), cons);
        
        cons.insets = new Insets(4,4,4,20);  
        cons.ipady = 4;
        cons.fill = GridBagConstraints.HORIZONTAL;  
        cons.weightx = 1;  
        cons.gridwidth = GridBagConstraints.REMAINDER;  
        this.add(componente, cons);
    }
}

package agenda;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PainelAdicionar extends JPanel
{
    // Variáveis globais
    private TituloString tituloLabel;
    private JTextField txtnome;
    private JTextField txttelefone;
    private JTextField txtemail;
    private JTextField txtendereco;
    private JTextField txtcidade;
    private JPanel botoesPanel;
    private JButton adicionarButton;
    private JButton cancelarButton;
   
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
        tituloLabel = new TituloString("Incluir Contato: ", this);
        txtnome = new JTextField();
        txttelefone = new JTextField();
        txtemail = new JTextField();
        txtendereco = new JTextField();
        txtcidade = new JTextField();
        botoesPanel = new JPanel();
        adicionarButton = new JButton("Adicionar");
        cancelarButton = new JButton("Cancelar");
        GridBagConstraints cons;
        
        // Título
        tituloLabel.adicionar();
        
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
                CardsStrings.mostrarPainel(CardsStrings.getListarContatosCard()));
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

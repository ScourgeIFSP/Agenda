package gui;

import agenda.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class PainelAdicionar extends JPanel
{
    // Variáveis globais
    private TituloPainel tituloLabel;
    private JTextField txtnome;
    private JTextField txttelefone1;
    private JTextField txttelefone2;
    private JTextField txtemail1;
    private JTextField txtemail2;
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
        tituloLabel = new TituloPainel("Adicionar Contato");
        txtnome = new JTextField();
        txttelefone1 = new JTextField();
        txttelefone2 = new JTextField();
        txtemail1 = new JTextField();
        txtemail2 = new JTextField();
        txtendereco = new JTextField();
        txtcidade = new JTextField();
        botoesPanel = new JPanel();
        adicionarButton = new JButton("Adicionar");
        cancelarButton = new JButton("Cancelar");
        GridBagConstraints cons = new GridBagConstraints();

        // Título
        tituloLabel.adicionar(this);

        // Formulário
        adcCampo("Nome:", txtnome);
        adcCampo("Telefone 1:", txttelefone1);
        adcCampo("Telefone 2:", txttelefone2);
        adcCampo("E-mail 1:", txtemail1);
        adcCampo("E-mail 2:", txtemail2);
        adcCampo("Endereço:", txtendereco);
        adcCampo("Cidade:", txtcidade);

        // Painel de botões
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
            int id = 0;

            String nome = txtnome.getText();
            ArrayList<String> telefones = new ArrayList<>();
            String telefone1 = txttelefone1.getText();
            telefones.add(telefone1);
            String telefone2 = txttelefone2.getText();
            telefones.add(telefone2);
            ArrayList<String> emails = new ArrayList<>();
            String email1 = txtemail1.getText();
            emails.add(email1);
            String email2 = txtemail2.getText();
            emails.add(email2);
            String endereco = txtendereco.getText();
            String cidade = txtcidade.getText();

            Contato novoContato = new Contato(id, nome, telefones, emails, endereco, cidade);

            GerenciarContato.inserirContato(novoContato);

            limparCampos();
            JanelaPrincipal.atualizarPainelLista();
        });

        cancelarButton.addActionListener((ActionEvent e) ->
        {
            limparCampos();
            JanelaPrincipal.atualizarPainelLista();
        });
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

    // Limpa campos
    private void limparCampos()
    {
        txtnome.setText("");
        txttelefone1.setText("");
        txttelefone2.setText("");
        txtemail1.setText("");
        txtemail2.setText("");
        txtendereco.setText("");
        txtcidade.setText("");
    }
}

package gui;

import agenda.Contato;
import agenda.GerenciarContato;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class PainelContato extends JPanel
{
    // Variáveis globais
    private TituloPainel tituloLabel;
    private JTextField nomeTField;
    private JTextField telefone1TField;
    private JTextField telefone2TField;
    private JTextField email1TField;
    private JTextField email2TField;
    private JTextField enderecoTField;
    private JTextField cidadeTField;
    private JButton excluirButton;
    private JButton editarButton;
    private JPanel botoesJPanel;

    // Contrutor
    public PainelContato()
    {
        this.setLayout(new GridBagLayout());
    }

    // Escolhe o contato a ser exibido
    public void escolherContato(int idContato)
    {
        Contato contato = GerenciarContato.retornarContato(idContato);

        // Definindo variáveis
        tituloLabel = new TituloPainel("Contato");
        nomeTField = new JTextField();
        telefone1TField = new JTextField();
        telefone2TField = new JTextField();
        email1TField = new JTextField();
        email2TField = new JTextField();
        enderecoTField = new JTextField();
        cidadeTField = new JTextField();
        botoesJPanel = new JPanel();
        editarButton = new JButton("Editar");
        excluirButton = new JButton("Excluir");

        // Títulos
        tituloLabel.adicionar(this);
        tituloLabel.setText(contato.getNome());

        // Campos
            // - Nome
            adcCampo("Nome:", nomeTField);
            nomeTField.setText(contato.getNome());
            // - Telefones
            ArrayList<String> telefones = contato.getTelefones();
            adcCampo("Telefone 1:", telefone1TField);
            telefone1TField.setText(telefones.get(0));
            adcCampo("Telefone 2:", telefone2TField);
            telefone2TField.setText(telefones.get(1));
            // - Emails
            ArrayList<String> emails = contato.getEmails();
            adcCampo("Email 1:", email1TField);
            email1TField.setText(emails.get(0));
            adcCampo("Email 2:", email2TField);
            email2TField.setText(emails.get(1));
            // - Endereço
            adcCampo("Endereço:", enderecoTField);
            enderecoTField.setText(contato.getEndereco());
            // - Cidade
            adcCampo("Cidade:", cidadeTField);
            cidadeTField.setText(contato.getCidade());
        // ---

        // Painel de botões
        botoesJPanel.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        cons.weighty = 1;
        cons.weightx = 1;
        cons.fill = GridBagConstraints.BOTH;
        cons.gridwidth = GridBagConstraints.REMAINDER;
        this.add(botoesJPanel, cons);

        // Botões
        cons = new GridBagConstraints();
        cons.insets = new Insets(10,4,4,4);
        cons.anchor = GridBagConstraints.NORTH;
        cons.weighty = 1;
        editarButton.setPreferredSize(new Dimension(100,30));
        excluirButton.setPreferredSize(new Dimension(100,30));
        cons.gridx = 0;
        botoesJPanel.add(editarButton, cons);
        cons.gridx = 1;
        botoesJPanel.add(excluirButton, cons);

        // Adiciona ações aos botões
        editarButton.addActionListener((ActionEvent e) ->
        {
            Contato contatoEditado = GerenciarContato.retornarContato(idContato);

            ArrayList<String> telefonesEditados = new ArrayList<>();
            telefonesEditados.add(telefone1TField.getText());
            telefonesEditados.add(telefone2TField.getText());
            ArrayList<String> emailsEditados = new ArrayList<>();
            emailsEditados.add(email1TField.getText());
            emailsEditados.add(email2TField.getText());

            contatoEditado.setNome(nomeTField.getText());
            contatoEditado.setTelefones(telefonesEditados);
            contatoEditado.setEmails(emailsEditados);
            contatoEditado.setEndereco(enderecoTField.getText());
            contatoEditado.setCidade(cidadeTField.getText());

            GerenciarContato.editarContato(contatoEditado);
            JanelaPrincipal.atualizarPainelLista();
        });

        excluirButton.addActionListener((ActionEvent e) ->
        {
            GerenciarContato.deletarContato(idContato);
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
}

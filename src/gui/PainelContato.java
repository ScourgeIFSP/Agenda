package gui;

import agenda.Contato;
import agenda.GerenciarContato;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class PainelContato extends JPanel
{
    // Variáveis globais
    private TituloPainel tituloLabel;
    private JTextField nomeTField;
    private JTextField enderecoTField;
    private JTextField cidadeTField;
    private JPanel gapPanel;

    // Contrutor
    public PainelContato()
    {
        this.setLayout(new GridBagLayout());
    }

    // Escolhe o contato a ser exibido
    public void escolherContato(int idContato)
    {
        Contato contato = GerenciarContato.retornarContato(idContato);
        ArrayList<String> telefones = contato.getTelefones();
        ArrayList<String> emails = contato.getEmails();

        // Definindo variáveis
        tituloLabel = new TituloPainel("Contato");
        nomeTField = new JTextField();
        enderecoTField = new JTextField();
        cidadeTField = new JTextField();
        gapPanel = new JPanel();

        // Títulos
        tituloLabel.adicionar(this);
        tituloLabel.setText(contato.getNome());

        // Campos
            // - Nome
            adcCampo("Nome:", nomeTField);
            nomeTField.setText(contato.getNome());
            // - Telefones
            int i=0;
            for (String telefone : telefones)
            {
                int j=i+1;
                JTextField telefoneTField = new JTextField(telefone);
                adcCampo("Telefone "+j+":", telefoneTField);
                i++;
            }
            // - Emails
            i=0;
            for (String email : emails)
            {
                int j=i+1;
                JTextField emailTField = new JTextField(email);
                adcCampo("Email "+j+":", emailTField);
                i++;
            }
            // - Endereço
            try
            {
                if (!contato.getEndereco().equals(""))
                {
                    adcCampo("Endereço:", enderecoTField);
                    enderecoTField.setText(contato.getEndereco());
                }
            }
            catch (NullPointerException npe)
            {
                System.out.println("Exception: "+npe.getMessage());
            }
            // - Cidade
            try
            {
                if (!contato.getEndereco().equals(""))
                {
                    adcCampo("Cidade:", cidadeTField);
                    cidadeTField.setText(contato.getCidade());
                }
            }
            catch (NullPointerException npe)
            {
                System.out.println("Exception: "+npe.getMessage());
            }
        // ---

        // Painel de ajuste
        GridBagConstraints cons = new GridBagConstraints();
        cons.weighty = 1;
        this.add(gapPanel, cons);
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

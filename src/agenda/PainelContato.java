package agenda;

import java.awt.*;
import javax.swing.*;

public class PainelContato extends JPanel
{
    // Variáveis globais
    private TituloString tituloLabel;
    private JTextField nomeTField;
    private JTextField telefoneTField;
    private JTextField emailTField;
    private JTextField endereçoTField;
    private JTextField cidadeTField;
    private JPanel gapPanel;

    // Contrutor
    public PainelContato()
    {
        this.setLayout(new GridBagLayout());

        adcComponentes();
    }

    // Adiciona componentes no painel
    private void adcComponentes()
    {
        // Definindo variáveis
        GridBagConstraints cons;
        tituloLabel = new TituloString("Contato");
        nomeTField = new JTextField();
        telefoneTField = new JTextField();
        emailTField = new JTextField();
        endereçoTField = new JTextField();
        cidadeTField = new JTextField();
        gapPanel = new JPanel();

        // Títulos
        tituloLabel.adicionar(this);

        // Campos
        adcCampo("Nome:", nomeTField);
        adcCampo("Endereço:", endereçoTField);
        adcCampo("Cidade:", cidadeTField);

        // Painel de ajuste
        cons = new GridBagConstraints();
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

    public void escolherContato(int idContato)
    {
        Contato contato = GerenciarContato.retornarContato(idContato);

        tituloLabel.setText(contato.getNome());
        nomeTField.setText(contato.getNome());
        endereçoTField.setText(contato.getEndereco());
        cidadeTField.setText(contato.getCidade());
    }

}

package agenda;

import java.awt.*;
import javax.swing.*;

public class PainelContato extends JPanel
{
    // Variáveis globais
    private static TituloString tituloLabel = new TituloString("Nome do contato");
    private static JTextField nomeTField = new JTextField();
    private static JTextField telefoneTField = new JTextField();
    private static JTextField emailTField = new JTextField();
    private static JTextField endereçoTField = new JTextField();
    private static JTextField cidadeTField = new JTextField();
    private static JPanel gapPanel = new JPanel();

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

    public static void setContato(int idContato)
    {
        Contato contato = new Contato(idContato);

        tituloLabel.setText(contato.getNome());
        nomeTField.setText(contato.getNome());
        endereçoTField.setText(contato.getEndereco());
        cidadeTField.setText(contato.getCidade());
    }

}

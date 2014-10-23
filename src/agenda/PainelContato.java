package agenda;

import java.awt.*;
import javax.swing.*;

public class PainelContato extends JPanel
{
    // Variáveis globais
    private TituloString tituloLabel;
    private JLabel nomeLabel;
    private JLabel telefoneLabel;
    private JLabel emailLabel;
    private JLabel endereçoLabel;
    private JLabel cidadeLabel;

    // Contrutor
    public PainelContato()
    {
        this.setLayout(new GridBagLayout());

        adcComponentes();
    }

    // Adiciona componentes no painel
    private void adcComponentes()
    {
        tituloLabel = new TituloString("Nome do contato");
        nomeLabel = new JLabel("Nome:");
    }

}

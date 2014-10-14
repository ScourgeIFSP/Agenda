package agenda;

import java.awt.*;
import javax.swing.*;

public class PainelLista extends JPanel
{
    // Variáveis globais
    private JLabel tituloLabel;
    private JTextField buscarField;
    private JButton buscarButton;
    private JPanel contatosPanel;
    private JScrollPane contatosScroll;
    
    // Contrutor
    public PainelLista()
    {
        setLayout(new GridBagLayout());
        adcComponentes();
        
    }
    
    // Adiciona componentes no painel
    private void adcComponentes()
    {
        // Definindo variáveis
        tituloLabel = new JLabel("Contatos:");
        contatosPanel = new JPanel();
        contatosScroll = new JScrollPane(contatosPanel);
        GridBagConstraints cons = new GridBagConstraints();
                
        // Título
        tituloLabel.setFont(new Font(null, Font.BOLD, 20));
        cons.insets = new Insets(10, 10, 15, 10);
        cons.weightx = 1;
        cons.anchor = GridBagConstraints.WEST;
        this.add(tituloLabel, cons);
        
        // Lista
        contatosPanel.setLayout(new GridBagLayout());
        cons.insets = new Insets(5, 5, 5, 5);
        cons.ipady = 40;
        cons.fill = GridBagConstraints.HORIZONTAL;
        String[] lista = {"Contato 1", "Contato 2", "Contato 3", "Contato 4", "Contato 1", "Contato 2", "Contato 3", "Contato 4"};
        try
        {
            int n = lista.length;
            for(int i=0;i<n;i++)
                {
                    JButton btn = new JButton(lista[i]);
                    btn.setContentAreaFilled(false);
                    cons.gridy=i+1;
                    if (i==n-1)
                    {
                        cons.weighty = 1;
                        cons.anchor = GridBagConstraints.NORTH;
                    }
                    contatosPanel.add(btn, cons);
                } 
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            
        }
        
        // Scrol Lista
        contatosScroll.setBorder(null);
        cons.insets = new Insets(0,0,0,0);
        cons.fill = GridBagConstraints.BOTH;
        this.add(contatosScroll, cons);
    }
}

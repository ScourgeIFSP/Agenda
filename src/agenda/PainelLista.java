package agenda;

import java.awt.*;
import javax.swing.*;

public class PainelLista extends JPanel
{
    private JLabel tituloLabel;
    private JTextField buscarField;
    private JButton buscarButton;
    private JScrollPane scrollContatos;
    
    public PainelLista()
    {
        setLayout(new GridBagLayout());
        adcComponentes();
        
    }
    
    private void adcComponentes()
    {
        GridBagConstraints cons = new GridBagConstraints();
        
        tituloLabel = new JLabel("Contatos:");
        String[] lista = {"Contato 1", "Contato 2", "Contato 3", "Contato 4"};
        
        tituloLabel.setFont(new Font(null, Font.BOLD, 20));
        cons.insets = new Insets(10, 10, 15, 10);
        cons.weightx = 1;
        cons.anchor = GridBagConstraints.WEST;
        this.add(tituloLabel, cons);
        
        cons.insets = new Insets(5, 5, 5, 5);
        cons.ipady = 40;
        cons.fill = GridBagConstraints.HORIZONTAL;
        
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
                    this.add(btn, cons);
                } 
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            
        }
    }
}

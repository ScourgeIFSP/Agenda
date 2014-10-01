package agenda;

import java.awt.*;
import javax.swing.*;

public class PainelLista extends JPanel
{
    private JTextField buscarField;
    private JButton buscarButton;
    private JScrollPane scrollContatos;
    private JList<String> listaContatos;
    
    public PainelLista()
    {
        setLayout(new GridBagLayout());
        adcComponentes();
    }
    
    private void adcComponentes()
    {
        GridBagConstraints cons = new GridBagConstraints();
        
        String[] lista = {"item1", "item2", "item3"};
        listaContatos = new JList(lista);
        scrollContatos = new JScrollPane(listaContatos);
        
        cons.insets = new Insets(10,10,10,10);
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.BOTH;
        this.add(scrollContatos, cons);
    }
}

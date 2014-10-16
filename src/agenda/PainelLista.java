package agenda;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class PainelLista extends JPanel
{
    // Variáveis globais
    private TituloString tituloLabel;
    private JTextField buscarField;
    private JButton buscarButton;
    private JPanel contatosPanel;
    private JScrollPane contatosScroll;
    
    // Contrutor
    public PainelLista()
    {
        this.setLayout(new GridBagLayout());
        
        adcComponentes();
    }
    
    // Adiciona componentes no painel
    private void adcComponentes()
    {
        // Definindo variáveis
        tituloLabel = new TituloString("Contatos:", this);
        contatosPanel = new JPanel();
        contatosScroll = new JScrollPane(contatosPanel);
        GridBagConstraints cons = new GridBagConstraints();
                
        // Título
        tituloLabel.adicionar();
        
        // Lista
        contatosPanel.setLayout(new GridBagLayout());
        cons.weightx = 1;
        cons.insets = new Insets(5, 5, 5, 5);
        cons.ipady = 40;
        cons.fill = GridBagConstraints.HORIZONTAL;
        java.util.List<String> lista = new ArrayList();
        for (int i=0; i<20; i++)
        {
            String s = "Contato ";
            lista.add(s+i);
        }
             
        int size = lista.size();
        for(int i=0;i<size;i++)
        {
            JButton btn = new JButton(lista.get(i));
            btn.setContentAreaFilled(false);
            cons.gridy=i+1;
            if (i==size-1)
            {
                cons.weighty = 1;
                cons.anchor = GridBagConstraints.NORTH;
            }
            contatosPanel.add(btn, cons);
        } 
        
        // Scrol Lista
        contatosScroll.setBorder(null);
        cons.insets = new Insets(0,0,0,0);
        cons.fill = GridBagConstraints.BOTH;
        this.add(contatosScroll, cons);
    }
}

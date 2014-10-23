package agenda;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class PainelListar extends JPanel
{
    // Variáveis globais
    private TituloString tituloLabel;
    private JPanel contatosPanel;
    private JScrollPane contatosScroll;
    
    // Contrutor
    public PainelListar()
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
        java.util.List<Contato> contatos = Agenda.getContatos();
             
        int size = contatos.size();
        for(int i=0;i<size;i++)
        {
            JButton btn = new JButton(contatos.get(i).getNome());
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

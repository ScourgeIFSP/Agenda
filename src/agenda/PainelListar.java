package agenda;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PainelListar extends JPanel
{
    // Variáveis globais
    private int idAgenda = JanelaPrincipal.idAgenda;
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
    public void adcComponentes()
    {
        // Definindo variáveis
        tituloLabel = new TituloString("Contatos");
        contatosPanel = new JPanel();
        contatosScroll = new JScrollPane(contatosPanel);
        GridBagConstraints cons = new GridBagConstraints();
                
        // Título
        tituloLabel.adicionar(this);

        // Lista
        contatosPanel.setLayout(new GridBagLayout());
        cons.insets = new Insets(5, 5, 5, 5);
        cons.weightx = 1;
        cons.ipady = 40;
        cons.fill = GridBagConstraints.HORIZONTAL;
        Agenda agenda = new Agenda(idAgenda);

        // Contato da lista
        ArrayList<Contato> contatos = agenda.getContatos();
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

            int j = i;
            btn.addActionListener((ActionEvent e) ->
            {
                JanelaPrincipal.atualizarPainelContato();
                JanelaPrincipal.painelContato.escolherContato(contatos.get(j).getId());
            });
        }

        // Scrol Lista
        contatosScroll.setBorder(null);
        cons.insets = new Insets(0,0,0,0);
        cons.weighty = 1;
        cons.fill = GridBagConstraints.BOTH;
        this.add(contatosScroll, cons);
    }
}

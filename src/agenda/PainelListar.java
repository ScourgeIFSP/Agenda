package agenda;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PainelListar extends JPanel
{
    // Variáveis globais
    private int idAgenda = 3;
    private TituloString tituloLabel = new TituloString("Contatos");
    private JPanel contatosPanel = new JPanel();
    private JScrollPane contatosScroll = new JScrollPane(contatosPanel);
    
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
        GridBagConstraints cons;
                
        // Título
        tituloLabel.adicionar(this);

        // Lista
        criarLista();

        // Scrol Lista
        contatosScroll.setBorder(null);
        cons = new GridBagConstraints();
        cons.insets = new Insets(0,0,0,0);
        cons.weighty = 1;
        cons.ipady = 40;
        cons.fill = GridBagConstraints.BOTH;
        cons.anchor = GridBagConstraints.NORTH;
        this.add(contatosScroll, cons);
    }

    public void atualizarPainel()
    {
        // contatosScroll.remove(contatosPanel);
        contatosPanel = new JPanel();
        criarLista();
        // contatosScroll.add(contatosPanel);
    }

    private void criarLista()
    {
        GridBagConstraints cons;

        // Lista
        contatosPanel.setLayout(new GridBagLayout());
        cons = new GridBagConstraints();
        cons.weightx = 1;
        cons.insets = new Insets(5, 5, 5, 5);
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
                PainelContato.setContato(contatos.get(j).getId());
                JanelaPrincipal.mostrarPainel(JanelaPrincipal.contato);

            });
        }
    }
}

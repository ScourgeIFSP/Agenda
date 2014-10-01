package agenda;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelMenu extends JPanel {

    private JButton btnAdicionar = new JButton("Adicionar");
    private JButton btnEditar = new JButton("Editar");
    private JButton btnExcluir = new JButton("Excluir");
    private JButton btnSair = new JButton("Sair");

    public PainelMenu() {

        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        AddComponentes(btnAdicionar, this);
        AddComponentes(btnEditar, this);
        AddComponentes(btnExcluir, this);
        AddComponentes(btnSair, this);

    }

    private void AddComponentes(JComponent componente, JPanel painel) {
        GridBagConstraints cons = new GridBagConstraints();

         cons.insets = new Insets(2, 2, 2, 2);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.weightx = 1;
        //cons.weighty = 1;
        cons.gridwidth = GridBagConstraints.REMAINDER;
        cons.ipady = 15;
         painel.add(componente, cons);
    }


}

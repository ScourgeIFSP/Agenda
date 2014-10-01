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


public class PainelCima extends JPanel
{
	    private JLabel lblImagem = new JLabel("Teste");
	 
	    public PainelCima() {
			

	        this.setLayout(new GridBagLayout());
	        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	        AddComponentes(lblImagem, this);
	      

	    }

	    private void AddComponentes(JComponent componente, JPanel painel) {
	        GridBagConstraints cons = new GridBagConstraints();

	    	         painel.add(componente, cons);
	    }


	}


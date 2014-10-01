package agenda;

import java.awt.*;
import javax.swing.*;

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


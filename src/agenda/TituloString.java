package agenda;

import java.awt.*;
import javax.swing.*;

public class TituloString extends JLabel
{    
    JPanel painel = new JPanel();
    
    public TituloString (String tituloString, JPanel painel)
    {
        this.setText(tituloString);
        this.setFont(new Font(null, Font.BOLD, 20));
        this.painel = painel;
    }
    
    // Adiciona o título
    public void adicionar()
    {
        GridBagConstraints cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.NORTHWEST; 
        cons.insets = new Insets(10, 10, 15, 10);     
        cons.weightx = 1;  
        cons.gridwidth = GridBagConstraints.REMAINDER; 
        painel.add(this, cons);
    }
}

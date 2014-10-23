package agenda;

import java.awt.*;
import javax.swing.*;

public class TituloString extends JLabel
{
    public TituloString (String tituloString)
    {
        this.setText(tituloString);
        this.setFont(new Font(null, Font.BOLD, 20));
    }
    
    // Adiciona o título
    public void adicionar(JPanel painel)
    {
        GridBagConstraints cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.NORTHWEST; 
        cons.insets = new Insets(10, 10, 15, 10);     
        cons.weightx = 1;  
        cons.gridwidth = GridBagConstraints.REMAINDER;
        painel.add(this, cons);
    }
}

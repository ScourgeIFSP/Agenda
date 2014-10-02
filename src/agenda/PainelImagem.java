package agenda;

import java.awt.*;
import javax.swing.*;

public class PainelImagem extends JPanel
{
    private JLabel lblImagem;

    public PainelImagem() 
    {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        lblImagem = new JLabel("Imagem");

        AddComponentes();
    }

    private void AddComponentes() 
    {
        GridBagConstraints cons = new GridBagConstraints();
        
        lblImagem = new JLabel("Imagem");
        
        this.add(lblImagem, cons);
    }
}


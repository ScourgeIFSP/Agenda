package agenda;

import java.awt.*;
import javax.swing.*;

public class PainelAdicionar extends JPanel
{
    // Variáveis globais
    private TituloString tituloLabel;
    private JTextField txtnome;
    private JTextField txttelefone;
    private JTextField txtemail;
    private JTextField txtendereco;
    private JTextField txtcidade;
   
    // Contrutor
    public PainelAdicionar()
    {   
       this.setLayout(new GridBagLayout()); 
       
       adcComponentes();
    }
    
    // Adiciona componentes no painel
    private void adcComponentes()
    {
        // Definindo variáveis
        tituloLabel = new TituloString("Incluir Contato: ", this);
        txtnome = new JTextField();
        txttelefone = new JTextField();
        txtemail = new JTextField();
        txtendereco = new JTextField();
        txtcidade = new JTextField();
        
        tituloLabel.adicionar();
        adcCampo("Nome: ", txtnome, this, false);
        adcCampo("Telefone: ", txttelefone, this, false);
        adcCampo("E-mail: ", txtemail, this, false);
        adcCampo("Endereço: ", txtendereco, this, false);
        adcCampo("Cidade: ", txtcidade, this, true);
    }
    
    // Adiciona um campo
    private void adcCampo(String label, JComponent componente ,JPanel painel, Boolean ultimoCampo) 
    {  
        GridBagConstraints cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.NORTHWEST;
        cons.insets = new Insets(4,20,4,4);  
        if(ultimoCampo)
        { 
            cons.weighty = 1; 
        }

        painel.add(new JLabel(label), cons);  

        cons.insets = new Insets(4,4,4,20);  
        cons.fill = GridBagConstraints.HORIZONTAL;  
        cons.weightx = 1;  
        cons.gridwidth = GridBagConstraints.REMAINDER;  
        painel.add(componente, cons);  
    }
}

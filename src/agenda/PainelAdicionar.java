package agenda;

import java.awt.*;
import javax.swing.*;

public class PainelAdicionar extends JPanel
{
    // Variáveis globais
    private JTextField txtnome;
    private JTextField txtendereco;
    private JTextField txtbairro;
    private JTextField txtcidade;
    private JTextField txttelefone;
    private JTextField txtcep;
    private JTextField txtcpf;
   
    // Contrutor
    public PainelAdicionar()
    {   
       this.setLayout(new GridBagLayout()); 
       
       adcComponentes();
    }
    
    // Adiciona um componente
    private void AddComponentes(String label, JComponent componente,JPanel painel ) 
    {  
        GridBagConstraints cons = new GridBagConstraints();  
        cons.fill = GridBagConstraints.NONE;  
        cons.anchor = GridBagConstraints.NORTHWEST;  
        cons.insets = new Insets(4,4,4,4);  

        cons.weightx = 0;  
        cons.gridwidth = 1;  
        painel.add(new JLabel(label), cons);  

        cons.fill = GridBagConstraints.BOTH;  
        cons.weightx = 1;  
        cons.gridwidth = GridBagConstraints.REMAINDER;  
        painel.add(componente, cons);  
    }  
    
    // Adiciona componentes no painel
    private void adcComponentes()
    {
        txtnome = new JTextField();
        txtendereco = new JTextField();
        txtbairro = new JTextField();
        txtcidade = new JTextField();
        txttelefone = new JTextField();
        txtcep = new JTextField();
        txtcpf = new JTextField();
    
        AddComponentes("Nome", txtnome, this);
        AddComponentes("Endereço", txtendereco, this);
        AddComponentes("Bairro", txtbairro, this);
        AddComponentes("Cidade", txtcidade, this);
        AddComponentes("Telefone", txttelefone, this);
        AddComponentes("CEP", txtcep, this);
        AddComponentes("CPF", txtcpf, this);
    }
}

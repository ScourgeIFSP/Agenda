package agenda;

import java.awt.*;
import javax.swing.*;

public class JanelaPrincipal extends JFrame 
{
    // Variáveis globais
    private final Container janela;
    public static JPanel painelPrincipal;
    public static PainelMenu painelMenu;
    public static PainelListar painelListar;
    public static PainelContato painelContato;
    public static PainelAdicionar painelAdicionar;

    // Strings referente aos cards do Painel Principal
    public static String painelListarCard;
    public static String painelContatoCard;
    public static String painelAdicionarCard;

    // Inteiro referente a agenda atual
    public static Integer idAgenda;

    // Contrutor
    public JanelaPrincipal(Integer idAgenda)
    {
        JanelaPrincipal.idAgenda = idAgenda;
        this.setTitle("Agenda");
        this.setMinimumSize(new Dimension(700, 500));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela = this.getContentPane();
        janela.setLayout(new GridBagLayout());
        
        adcComponentes();
    }
    
    // Adiciona componentes na janela
    private void adcComponentes()
    {
        // Definindo variáveis
        painelPrincipal = new JPanel();
        painelMenu = new PainelMenu();
        painelListar = new PainelListar();
        painelContato = new PainelContato();
        painelAdicionar = new PainelAdicionar();
        GridBagConstraints cons = new GridBagConstraints();

        // Painel de menu
        cons.insets = new Insets(5,5,5,0);
        cons.weighty = 1;
        cons.fill = GridBagConstraints.BOTH;
        janela.add(painelMenu,cons);
        
        // Painel principal
        painelPrincipal.setLayout(new CardLayout());
        cons.insets = new Insets(5,5,5,5);
        cons.weightx = 1;
        cons.ipadx = 0;
        cons.gridx = 1;
        cons.gridheight = GridBagConstraints.REMAINDER;
        janela.add(painelPrincipal, cons);
        
        // Adicionando cards
        painelListarCard = "listar";
        painelPrincipal.add(painelListar, painelListarCard);
        painelAdicionarCard = "adicionar";
        painelPrincipal.add(painelAdicionar, painelAdicionarCard);
        painelContatoCard = "contato";
        painelPrincipal.add(painelContato, painelContatoCard);
    }

    // Mostra painel desejado
    public static void mostrarPainel(String card)
    {
        CardLayout cl = (CardLayout)(painelPrincipal.getLayout());
        cl.show(painelPrincipal, card);
    }

    // Atualiza e mostra a lista de contatos
    public static void atualizarPainelLista()
    {
        painelListar.removeAll();
        painelListar.adcComponentes();
        painelPrincipal.add(painelListar,painelListarCard);
        mostrarPainel(painelListarCard);
    }

    // Atualiza e mostra o painel de contato
    public static void atualizarPainelContato()
    {
        painelContato.removeAll();
        painelPrincipal.add(painelContato,painelContatoCard);
        mostrarPainel(painelContatoCard);
    }

}
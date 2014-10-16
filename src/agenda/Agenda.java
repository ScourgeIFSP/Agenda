package agenda;

import java.util.*;

public class Agenda
{
    public Agenda()
    {
        
    }
    
    public List<Contato> getContatos()
    {
        //int qtdContatos = 20; // qtdContatos = Quantidade de linhas resultantes de um select na tabela contatos
        int idContato = 1;
        
        /*Contato[] contatos = new Contato[qtdContatos]; 
        
        int i=0;
        while( Select na tabela contatos, while deverá passar por todas linhas )
        {
            contatos[i] = new Contato(idContato);
            i++;
        }
        */
        
        List<Contato> contatos = new ArrayList();
        
        int i=0;
        while(/*Select na tabela contatos, while deverá passar por todas linhas*/i==1)
        {
            Contato contato = new Contato(idContato);
            contatos.add(contato);
            i++;
        }
        
        return contatos;
    }
}

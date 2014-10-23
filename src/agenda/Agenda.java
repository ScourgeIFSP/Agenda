package agenda;

import java.util.*;

public class Agenda
{
    public static List<Contato> getContatos()
    {
        int qtdContatos = 20; // Quantidade de linhas na tabela contato

        List<Contato> contatos = new ArrayList<>(); // Lista de Contatos

        // Adiciona contatos na lista
        int i=0;
        while(i<qtdContatos)
        {
            Contato contato = new Contato("Contato "+i);
            contatos.add(contato);
            i++;
        }

        // Retorna lista
        return contatos;
    }
}

package agenda;

import java.util.*;

public class Agenda
{
    // Lista de Contatos
    private ArrayList<Contato> contatos;

    // Construtor
    public Agenda(int idAgenda)
    {
        // Adiciona Contatos na lista
        this.contatos = GerenciarContato.retornarContatos(idAgenda);
    }

    // Retorna lista de Contatos
    public ArrayList<Contato> getContatos()
    {
        return contatos;
    }
}

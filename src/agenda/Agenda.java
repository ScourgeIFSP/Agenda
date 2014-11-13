package agenda;

import java.util.*;

public class Agenda
{
    // Lista de Contatos
    private ArrayList<Contato> contatos;

    // Construtor
    public Agenda()
    {
        // Adiciona Contatos na lista
        this.contatos = GerenciarContato.retornarContatos();
    }

    public ArrayList<Contato> getContatos()
    {
        // Retorna lista
        return contatos;
    }
}

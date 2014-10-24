package agenda;

import java.sql.*;
import java.util.*;

public class Agenda
{
    private static List<Contato> contatos = new ArrayList<>(); // Lista de Contatos

    public static List<Contato> getContatos()
    {
        // Adiciona contatos na lista
        try
        {
            ResultSet linha = GerenciaContato.retornarTabelaContato();

            while(linha.next())
            {
                contatos.add(new Contato(linha.getInt("ContatoId")));
            }
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }

        // Retorna lista
        return contatos;
    }
}

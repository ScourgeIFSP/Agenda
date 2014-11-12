package agenda;

import conexao.*;

import java.sql.*;
import java.util.*;

public class Agenda
{
    // Lista de Contatos
    private ArrayList<Contato> contatos = new ArrayList<>();

    public ArrayList<Contato> getContatos()
    {
        // Adiciona Contatos na lista
        if(GerenciarConexao.getConexao()!=null)
        {
            try
            {
                ResultSet linha = GerenciarContato.retornarContatos();

                while (linha.next())
                {
                    contatos.add(new Contato(linha.getInt("ContatoId")));
                }
            }
            catch (SQLException sqle)
            {
                System.out.println(sqle.getMessage());
            }
        }
        else
        {
            contatos.add(new Contato(0));
        }

        // Retorna lista
        return contatos;
    }
}

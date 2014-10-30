package agenda;

import conexao.GerenciarConexao;

import java.sql.*;
import java.util.*;

public class Agenda
{
    private static List<Contato> contatos = new ArrayList<>(); // Lista de Contatos

    public static List<Contato> getContatos()
    {
        // Adiciona contatos na lista
        if(GerenciarConexao.getConexao()!=null)
        {
            try {
                ResultSet linha = GerenciarContato.retornarContato();

                while (linha.next()) {
                    contatos.add(new Contato(linha.getInt("ContatoId")));
                }
            } catch (SQLException sqle) {
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

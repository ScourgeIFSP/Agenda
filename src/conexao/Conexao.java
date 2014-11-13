package conexao;

import java.sql.*;
import java.util.*;

public interface Conexao
{
    // Iniciar e encerrar conexões ao banco de dados
    public Connection conectar();
    public boolean encerrar();

    // Seleciona todos os dados de uma tabela
    public ResultSet selecionar(String tabela);

    // Seleciona uma tabela com apenas uma condição
    public ResultSet selecionar(String tabela, String condicao, String valor);

    // Seleciona uma tabela com inumeras condições
    public ResultSet selecionar(String tabela, ArrayList<String> condicoes, ArrayList<String> valores);

    // Insere em uma tabela com os valores em ordem
    public ResultSet inserir(String tabela, ArrayList<String> valores);

    public ResultSet alterar();
    public ResultSet deletar();
}
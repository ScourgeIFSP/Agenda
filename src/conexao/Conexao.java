package conexao;

import java.sql.*;
import java.util.*;

public interface Conexao
{
    // Iniciar e encerrar conexões ao banco de dados
    public Connection conectar();
    public boolean encerrar();

    // Seleciona todos os dados de uma tabela
    public ResultSet seleciona(String tabela);

    // Seleciona uma tabela com apenas uma condição
    public ResultSet seleciona(String tabela, String condicao, String valor);

    // Seleciona uma tabela com inumeras condições
    public ResultSet seleciona(String tabela, ArrayList<String> condicoes, ArrayList<String> valores);

    // Insere em uma tabela com os valores em ordem
    public ResultSet insere(String tabela, ArrayList<String> valores);

    public ResultSet altera();
    public ResultSet deleta();
}

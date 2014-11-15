package conexao;

import java.sql.*;
import java.util.*;

public interface Conexao
{
    // Iniciar e encerrar conexões aos bancos de dados
    public Connection conectar();
    public boolean encerrar();

    // Seleciona todos os dados de uma tabela
    public ResultSet selecionar(String tabela);

    // Seleciona uma tabela com apenas uma condição
    public ResultSet selecionar(String tabela, String condicao, String valor);

    // Seleciona uma tabela com inumeras condições
    public ResultSet selecionar(String tabela, ArrayList<String> condicoes, ArrayList<String> valores);

    // Insere registro em uma tabela com os valores em ordem correta
    public Integer inserir(String tabela, ArrayList<String> valores);

    // Altera registro de uma tabela com inumeras condições
    public Integer alterar(String tabela, ArrayList<String> campos, ArrayList<String> alteracoes, ArrayList<String> condicoes, ArrayList<String> valoresCondicoes);

    // Deleta registro de uma tabela com inumeras condições
    public Integer deletar(String tabela, ArrayList<String> condicoes, ArrayList<String> valoresCondicoes);
}
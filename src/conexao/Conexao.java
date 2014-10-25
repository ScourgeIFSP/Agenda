package conexao;

import java.sql.*;
import java.util.*;

public interface Conexao
{
    // Criar e encerrar conexões ao banco de dados
    public Connection conectar();
    public boolean encerrar();

    // Métodos de acesso ao banco de dados
    public String seleciona(String tabela);
    public String seleciona(String tabela, String condicao, String valor);
    public String insere(String tabela, ArrayList<String> valores);
    public String altera();
    public String deleta();
}

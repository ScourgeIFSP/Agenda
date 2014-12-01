package conexao;

import java.sql.*;

public class ConexaoPostgre {

        private static Connection con = null;

        public Connection Conectar()
        {
            try {

                String url = "jdbc:postgresql://" + Acesso.getServidor() + "/" + Acesso.getBanco();

                Class.forName("org.postgresql.Driver");

                con = DriverManager.getConnection(url, Acesso.getUsuario(), Acesso.getSenha());

                System.out.println("Conexão realizada com sucesso.");

            } catch (Exception e)
            {
                System.out.println("Conexão falhou");

                e.printStackTrace();
            }
            return null;
        }


        public boolean encerrar() {
            try {
                con.close();
                System.out.println("Conexão Encerrada.");
                return true;
            } catch (SQLException sqle) {
                System.out.println("Conexão não pode ser encerrada: " + sqle.getMessage());
                return false;
            }
        }
    }

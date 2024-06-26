package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/contatosBook";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private static Connection conn;

    public static Connection getConexao() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            return conn;
        } catch (SQLException e) {
            System.err.println("Erro ao estabelecer conexão com o Banco de dados");
            e.printStackTrace();
            return null;
        }
    }
}

package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {

    public static Connection ConectarBD() {

        Connection connection;
        String host = "jdbc:mysql://localhost/";
        String BD = "gym";
        String user = "root";
        String password = "";

        try {
            connection = DriverManager.getConnection(host+BD,user,password);
            System.out.println("Conectado exitosamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void DesconectarBD(Connection bd) {
        try {
            bd.close();
            System.out.println("Desconectdo exitosamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
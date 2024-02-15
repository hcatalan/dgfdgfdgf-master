//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTableExample {
    private static final String JDBC_URL = "jdbc:postgresql://192.168.22.124:5432/ddbb";
    private static final String USER = "usuario";
    private static final String PASSWORD = "password";

    /**Borrar tabla*/
    public DeleteTableExample() {
    }

    /**Conectarse a la base de datos*/
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://192.168.22.124:5432/ddbb", "usuario", "password");
    }

    /**Borrar tabla*/
    public static void deleteTable(String tableName) {
        try {
            Connection connection = getConnection();

            try {
                Statement statement = connection.createStatement();

                try {
                    String query = "DROP TABLE IF EXISTS " + tableName;
                    statement.executeUpdate(query);
                    System.out.println("Tabla '" + tableName + "' eliminada con éxito.");
                } catch (Throwable var7) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var6) {
                            var7.addSuppressed(var6);
                        }
                    }

                    throw var7;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var8) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var5) {
                        var8.addSuppressed(var5);
                    }
                }

                throw var8;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var9) {
            var9.printStackTrace();
        }

    }

    public static void main() {
        System.out.println("Ingrese el nombre de la tabla que desea borrar");
        Scanner scanner = new Scanner(System.in);
        String tabla = scanner.nextLine();
        deleteTable(tabla);
    }
}

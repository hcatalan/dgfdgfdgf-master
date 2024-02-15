import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateTableController {
    private static final String JDBC_URL = "jdbc:postgresql://192.168.22.124:5432/ddbb";
    private static final String USER = "usuario";
    private static final String PASSWORD = "password";

    /**Conectarse a la base de datos*/
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    /**Crear tabla*/
    public static void createTable(String nombreTabla) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Escribe el nombre de la variable principal que quieras ponerle:");
            String nombrePrimaria = scanner.nextLine();
            System.out.println("Escribe el nombre de la variable secundaria que quieras ponerle:");
            String nombreVarchar = scanner.nextLine();
            System.out.println("Escribe el nombre de la variable terciaria que quieras ponerle:");
            String nombreInt = scanner.nextLine();

            String query = "CREATE TABLE " + nombreTabla + "(" +
                    nombrePrimaria + " SERIAL PRIMARY KEY, " +
                    nombreVarchar + " VARCHAR(50), " +
                    nombreInt + " INT)";
            /**Ejecutar la consulta*/
            statement.executeUpdate(query);
            System.out.println("Tabla creada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe el nombre de la tabla que quieras hacer:");
        String tabla = scanner.nextLine();
        createTable(tabla);
    }
}

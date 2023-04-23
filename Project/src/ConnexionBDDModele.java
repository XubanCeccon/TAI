import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBDDModele {
    private static Connection connection;

    public static Connection getConnexion() {
        if (connection == null) {
            try {
                String driver = "com.mysql.cj.jdbc.Driver";
                String url = "jdbc:mysql://localhost/tai";
                String username = "root";
                String password = "";

                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnexion();
            if (connection != null) {
                System.out.println("Database connection successful!");
                connection.close();
            } else {
                System.out.println("Failed to establish database connection.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to the database.");
            e.printStackTrace();
        }
    }
}

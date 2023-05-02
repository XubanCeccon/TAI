import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBDDModele {
    Connection connexion;

    // Constructor
    public ConnexionBDDModele() {
        try {
            // System.out.println("Chargement de pilote JDBC<-->MySQL ...");
            Class.forName("com.mysql.jdbc.Driver");
            // System.out.println("Pilote charged.");
            String utilisateurBDD = "root"; 	                    // Utilisateur de la BD
            String motdepasseBDD = ""; 			                    // Password de l'utilisateur de la BD
            String nomBDD = "tai"; 	                                // Nom de la BD ? laquelle nous allons acceder
            String urlBDD = "jdbc:mysql://localhost/" + nomBDD;

            try {
                connexion = DriverManager.getConnection(urlBDD, utilisateurBDD, motdepasseBDD);
                // System.out.println("Connexion etablie avec la BDD.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch(ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    // Getter
    public Connection getConnexion() { return connexion; }

    // Method
    public void fermerConnexion() {
        try {
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
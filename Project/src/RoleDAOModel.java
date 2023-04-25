import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAOModel {
    public RoleBeanModel findById(int id) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();
        RoleBeanModel role = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM user_role WHERE id=" + id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                role = new RoleBeanModel();
                role.setId(resultSet.getInt("id"));
                role.setNom(resultSet.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }
}

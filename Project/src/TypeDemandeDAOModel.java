import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeDemandeDAOModel {
    public TypeDemandeBeanModel findById(int id) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();
        TypeDemandeBeanModel type = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM type_demande WHERE id=" + id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                type = new TypeDemandeBeanModel();
                type.setId(resultSet.getInt("id"));
                type.setNom(resultSet.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return type;
    }
}

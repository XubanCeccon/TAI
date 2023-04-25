import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DemandeDAOModel {
    public List<DemandeBeanModel> findByUserId(int id) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();
        List<DemandeBeanModel> demandeList = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM demande WHERE id_user=" + id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                DemandeBeanModel demande = new DemandeBeanModel();
                demande.setId(resultSet.getInt("id"));
                demande.setJustification(resultSet.getString("justification"));
                demande.setValidationRh(resultSet.getBoolean("validation_rh"));
                demande.setValidationManager(resultSet.getBoolean("validation_manager"));
                demande.setId_user(resultSet.getInt("id_user"));
                demande.setId_rh(resultSet.getInt("id_rh"));
                demande.setId_manager(resultSet.getInt("id_manager"));

                TypeDemandeDAOModel typeDemandeDAOModel = new TypeDemandeDAOModel();
                TypeDemandeBeanModel typeDemande = typeDemandeDAOModel.findById(resultSet.getInt("id_type_demande"));

                if(typeDemande != null) demande.setTypeDemande(typeDemande.getNom());
                else demande.setTypeDemande(null);

                demandeList.add(demande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return demandeList;
    }
}

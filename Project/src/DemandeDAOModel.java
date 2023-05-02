import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
                demande.setDebut(resultSet.getDate("debut").toLocalDate());
                demande.setFin(resultSet.getDate("fin").toLocalDate());

                TypeDemandeDAOModel typeDemandeDAOModel = new TypeDemandeDAOModel();
                TypeDemandeBeanModel typeDemande = typeDemandeDAOModel.findById(resultSet.getInt("id_type_demande"));

                if(typeDemande != null) demande.setTypeDemande(typeDemande.getId());

                demandeList.add(demande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return demandeList;
    }

    public void creerDemande(UserBeanModel user, String debut, String fin, String typeDemande, String justification) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();

        try {
            TypeDemandeDAOModel typeDemandeDAOModel = new TypeDemandeDAOModel();
            TypeDemandeBeanModel type = typeDemandeDAOModel.findByName(typeDemande);

            String[] date_debut = debut.split("/");
            LocalDate formatted_debut = LocalDate.of(Integer.parseInt(date_debut[2]), Integer.parseInt(date_debut[1]), Integer.parseInt(date_debut[0]));
            String[] date_fin = fin.split("/");
            LocalDate formatted_fin = LocalDate.of(Integer.parseInt(date_fin[2]), Integer.parseInt(date_fin[1]), Integer.parseInt(date_fin[0]));

            PreparedStatement statement = statement = connexion.prepareStatement("INSERT INTO demande (" +
                "id_type_demande, justification, validation_rh, validation_manager, " +
                "id_user, id_user_rh, id_user_manager, debut, fin" +
            ") VALUES (" +
                type.getId() + ", " + justification + ", " + null + ", " + null + ", " +
                user.getId() + ", " + user.getId_rh() + ", " + user.getId_manager() +
                java.sql.Date.valueOf(formatted_debut)  + ", " + java.sql.Date.valueOf(formatted_fin) +
            ");");

            ResultSet resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void validerDemande(UserBeanModel user, DemandeBeanModel demande, boolean valid) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();

        try {
            PreparedStatement statement = null;
            if(user.getRole() == "rh") {
                statement = connexion.prepareStatement("UPDATE demande SET validation_rh=" + valid + " WHERE id=" + demande.getId());
            } else if(user.getRole() == "manager") {
                statement = connexion.prepareStatement("UPDATE demande SET validation_manager=" + valid + " WHERE id=" + demande.getId());
            } else return;

            ResultSet resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

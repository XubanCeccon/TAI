import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DemandeDAOModel {
    public List<DemandeBeanModel> findByUserId(int id) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();
        List<DemandeBeanModel> demandeList = new ArrayList<>();

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM demande WHERE id_user=" + id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                DemandeBeanModel demande = new DemandeBeanModel();
                demande.setId(rs.getInt("id"));
                demande.setJustification(rs.getString("justification"));

                demande.setValidationRh(rs.getString("validation_rh") == null ? "null" : rs.getString("validation_rh"));
                demande.setValidationManager(rs.getString("validation_manager") == null ? "null" : rs.getString("validation_manager"));

                demande.setId_user(rs.getInt("id_user"));
                demande.setId_rh(rs.getInt("id_user_rh"));
                demande.setId_manager(rs.getInt("id_user_manager"));
                demande.setDebut(rs.getDate("debut").toLocalDate());
                demande.setFin(rs.getDate("fin").toLocalDate());

                TypeDemandeDAOModel typeDemandeDAOModel = new TypeDemandeDAOModel();
                TypeDemandeBeanModel typeDemande = typeDemandeDAOModel.findById(rs.getInt("id_type_demande"));

                if(typeDemande != null) {
                    demande.setId_typeDemande(typeDemande.getId());
                    demande.setTypeDemande(typeDemande.getNom());
                }

                demandeList.add(demande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return demandeList;
    }

    public void creerDemande(int user_id, String debut, String fin, String typeDemande, String justification) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();

        try {
            UserDAOModel userDAOModel = new UserDAOModel();
            UserBeanModel user = userDAOModel.findUserById(user_id);

            TypeDemandeDAOModel typeDemandeDAOModel = new TypeDemandeDAOModel();
            TypeDemandeBeanModel type = typeDemandeDAOModel.findByName(typeDemande);

            String[] date_debut = debut.split("-");
            LocalDate formatted_debut = LocalDate.of(Integer.parseInt(date_debut[0]), Integer.parseInt(date_debut[1]), Integer.parseInt(date_debut[2]));
            String[] date_fin = fin.split("-");
            LocalDate formatted_fin = LocalDate.of(Integer.parseInt(date_fin[0]), Integer.parseInt(date_fin[1]), Integer.parseInt(date_fin[2]));
            System.out.println(user.getId_rh());
            System.out.println(user.getId_manager());

            PreparedStatement statement = connexion.prepareStatement("INSERT INTO demande (" +
                "id_type_demande, justification, validation_rh, validation_manager, " +
                "id_user, id_user_rh, id_user_manager, debut, fin" +
            ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");

            statement.setInt(1, type.getId());
            statement.setString(2, justification);
            statement.setObject(3, null);
            statement.setObject(4, null);
            statement.setInt(5, user.getId());
            statement.setInt(6, user.getId_rh());
            statement.setInt(7, user.getId_manager());
            statement.setDate(8, java.sql.Date.valueOf(formatted_debut));
            statement.setDate(9, java.sql.Date.valueOf(formatted_fin));

            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void validerDemande(int demande_id, int user_id, int valid) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();

        try {
            UserDAOModel userDAOModel = new UserDAOModel();
            UserBeanModel user = userDAOModel.findUserById(user_id);

            PreparedStatement statement = null;
            if(user.getRole().equals("rh")) {
                statement = connexion.prepareStatement("UPDATE demande SET validation_rh=? WHERE id=?");
                statement.setString(1, Integer.toString(valid));
                statement.setString(2, Integer.toString(demande_id));
            } else if(user.getRole().equals("manager")) {
                statement = connexion.prepareStatement("UPDATE demande SET validation_manager=? WHERE id=?");
                statement.setString(1, Integer.toString(valid));
                statement.setString(2, Integer.toString(demande_id));
            } else return;

            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<DemandeBeanModel> findCpByManagerId(int id) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();

        TypeDemandeDAOModel typeDemandeDAOModel = new TypeDemandeDAOModel();
        TypeDemandeBeanModel type = typeDemandeDAOModel.findByName("cp");

        List<DemandeBeanModel> demandeList = new ArrayList<>();

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM demande WHERE id_user_manager=? AND id_type_demande=? ;");
            statement.setString(1, Integer.toString(id));
            statement.setString(2, Integer.toString(type.getId()));
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                boolean condition = rs.getString("id_type_demande").equals(Integer.toString(type.getId())) && (rs.getString("validation_manager") == null || !rs.getString("validation_manager").equals("1"));
                if(condition) {
                    DemandeBeanModel demande = new DemandeBeanModel();
                    demande.setId(rs.getInt("id"));
                    demande.setJustification(rs.getString("justification"));

                    demande.setValidationRh(rs.getString("validation_rh") == null ? "null" : rs.getString("validation_rh"));
                    demande.setValidationManager(rs.getString("validation_manager") == null ? "null" : rs.getString("validation_manager"));

                    demande.setId_user(rs.getInt("id_user"));
                    demande.setId_rh(rs.getInt("id_user_rh"));
                    demande.setId_manager(rs.getInt("id_user_manager"));
                    demande.setDebut(rs.getDate("debut").toLocalDate());
                    demande.setFin(rs.getDate("fin").toLocalDate());

                    demande.setId_typeDemande(type.getId());
                    demande.setTypeDemande(type.getNom());

                    demandeList.add(demande);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return demandeList;
    }

    public List<DemandeBeanModel> findAbsenceByManagerId(int id) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();

        TypeDemandeDAOModel typeDemandeDAOModel = new TypeDemandeDAOModel();
        TypeDemandeBeanModel type = typeDemandeDAOModel.findByName("absence");

        List<DemandeBeanModel> demandeList = new ArrayList<>();

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM demande WHERE id_user_manager=? AND id_type_demande=? ;");
            statement.setString(1, Integer.toString(id));
            statement.setString(2, Integer.toString(type.getId()));
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                boolean condition = rs.getString("id_type_demande").equals(Integer.toString(type.getId())) && (rs.getString("validation_manager") == null || !rs.getString("validation_manager").equals("1"));
                if(condition) {
                    DemandeBeanModel demande = new DemandeBeanModel();
                    demande.setId(rs.getInt("id"));
                    demande.setJustification(rs.getString("justification"));

                    demande.setValidationRh(rs.getString("validation_rh") == null ? "null" : rs.getString("validation_rh"));
                    demande.setValidationManager(rs.getString("validation_manager") == null ? "null" : rs.getString("validation_manager"));

                    demande.setId_user(rs.getInt("id_user"));
                    demande.setId_rh(rs.getInt("id_user_rh"));
                    demande.setId_manager(rs.getInt("id_user_manager"));
                    demande.setDebut(rs.getDate("debut").toLocalDate());
                    demande.setFin(rs.getDate("fin").toLocalDate());

                    demande.setId_typeDemande(type.getId());
                    demande.setTypeDemande(type.getNom());

                    demandeList.add(demande);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return demandeList;
    }
}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOModel {
    public UserBeanModel findUserByEmailAndPassword(String email, String password) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();
        UserBeanModel user = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM user WHERE mail=? AND mdp=?");
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new UserBeanModel();
                user.setId(resultSet.getInt("id"));
                user.setId(resultSet.getInt("id"));
                user.setId_rh(resultSet.getInt("id_rh"));
                user.setNom(resultSet.getString("nom"));
                user.setPrenom(resultSet.getString("prenom"));

                user.setSite(resultSet.getString("id_site"));
                user.setSoldeCP(resultSet.getFloat("solde_cp"));
                user.setDroitAnnuelCP(resultSet.getFloat("droit_annuel_cp"));
                user.setCompteurAbsence(resultSet.getInt("compteur_absences"));

                RoleDAOModel roldeDAOModel = new RoleDAOModel();
                RoleBeanModel role = roldeDAOModel.findById(resultSet.getInt("id_role"));

                if(role != null) user.setRole(role.getNom());
                else user.setRole(null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public List<UserBeanModel> findUsersByRhId(int id) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();
        List<UserBeanModel> userList = new ArrayList<>();

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM user WHERE id_rh=?;");
            statement.setString(1, Integer.toString(id));
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                UserBeanModel user = new UserBeanModel();
                user.setId(resultSet.getInt("id"));
                user.setId_rh(resultSet.getInt("id_rh"));
                user.setId_manager(resultSet.getInt("id_manager"));
                user.setNom(resultSet.getString("nom"));
                user.setPrenom(resultSet.getString("prenom"));

                user.setSite(resultSet.getString("id_site"));
                user.setSoldeCP(resultSet.getFloat("solde_cp"));
                user.setDroitAnnuelCP(resultSet.getFloat("droit_annuel_cp"));
                user.setCompteurAbsence(resultSet.getInt("compteur_absences"));

                RoleDAOModel roldeDAOModel = new RoleDAOModel();
                RoleBeanModel role = roldeDAOModel.findById(resultSet.getInt("id_role"));

                if(role != null) user.setRole(role.getNom());
                else user.setRole(null);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public UserBeanModel findUserById(int id) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();
        UserBeanModel user = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM user WHERE id=" + id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new UserBeanModel();
                user.setId(resultSet.getInt("id"));
                user.setId_rh(resultSet.getInt("id_rh"));
                user.setId_manager(resultSet.getInt("id_manager"));
                user.setNom(resultSet.getString("nom"));
                user.setPrenom(resultSet.getString("prenom"));

                user.setSite(resultSet.getString("id_site"));
                user.setSoldeCP(resultSet.getFloat("solde_cp"));
                user.setDroitAnnuelCP(resultSet.getFloat("droit_annuel_cp"));
                user.setCompteurAbsence(resultSet.getInt("compteur_absences"));

                RoleDAOModel roldeDAOModel = new RoleDAOModel();
                RoleBeanModel role = roldeDAOModel.findById(resultSet.getInt("id_role"));

                if(role != null) user.setRole(role.getNom());
                else user.setRole(null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void updateSolde(int user_id, float solde_disponible, float solde_annuelle, int compteur_absence) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();

        try {
            PreparedStatement statement = connexion.prepareStatement("UPDATE user SET solde_cp=?, droit_annuel_cp=?, compteur_absences=? WHERE id=?");
            statement.setString(1, Float.toString(solde_disponible));
            statement.setString(2, Float.toString(solde_annuelle));
            statement.setString(3, Float.toString(compteur_absence));
            statement.setString(4, Float.toString(user_id));

            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

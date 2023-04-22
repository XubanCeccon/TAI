import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public User findUserByEmailAndPassword(String email, String password) {
        Connection connection = ConnectionUtil.getConnection();
        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE mail = ? AND mdp = ?");
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(resultSet.getInt("id"), resultSet.getString("mail"), resultSet.getString("mdp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}

package dao;

import model.User;

import java.sql.*;

public class UserDao {

    private static UserDao instance;

    private Connection connection;

    public static UserDao getInstance() {
        if (instance == null)
            synchronized (UserDao.class) {
                if (instance == null)
                    instance = new UserDao();
            }
        return instance;
    }

    private UserDao() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/cocktailfactory?user=root&password=2412");
        } catch (Exception ignored) {
        }
    }

    public User add(User user) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(
                    "INSERT INTO user (username, password) VALUE (?, ?);",
                    Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getPassword());
            if (stm.executeUpdate() != 1) {
                throw new Exception("Could not add user");
            }
            ResultSet ids = stm.getGeneratedKeys();
            ids.next();
            user.setId(ids.getInt(1));
            return user;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return null;
    }

    public User getByUsername(String username) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(
                    "SELECT * FROM user WHERE username =?;");
            stm.setString(1, username);
            ResultSet res = stm.executeQuery();
            res.next();
            User user = new User(res.getInt(1),res.getString(2),res.getString(3));
            return user;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return null;
    }
}

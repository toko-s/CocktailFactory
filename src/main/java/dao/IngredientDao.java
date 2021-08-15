package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IngredientDao {
    private static IngredientDao instance;

    private Connection connection;

    public static IngredientDao getInstance() {
        if (instance == null)
            synchronized (UserDao.class) {
                if (instance == null)
                    instance = new IngredientDao();
            }
        return instance;
    }

    private IngredientDao() {
        try {
            Class.forName(DatabaseConstants.NAME);
            connection = DriverManager.getConnection(
                    DatabaseConstants.URL, DatabaseConstants.USER, DatabaseConstants.PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

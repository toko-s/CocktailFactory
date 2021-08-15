package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IngredientToCocktailDao {
    private static IngredientToCocktailDao instance;

    private Connection connection;

    public static IngredientToCocktailDao getInstance() {
        if (instance == null)
            synchronized (UserDao.class) {
                if (instance == null)
                    instance = new IngredientToCocktailDao();
            }
        return instance;
    }

    private IngredientToCocktailDao() {
        try {
            Class.forName(DatabaseConstants.NAME);
            connection = DriverManager.getConnection(
                    DatabaseConstants.URL, DatabaseConstants.USER, DatabaseConstants.PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

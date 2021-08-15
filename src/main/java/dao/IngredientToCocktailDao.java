package dao;

import model.Ingredient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Ingredient> getIngredientsByCocktailId(int id) throws SQLException {
        IngredientDao dao = IngredientDao.getInstance();

        List<Ingredient> ingredients = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM cocktail_to_ingredients where cocktailId = ?");

        statement.setInt(1, id);
        ResultSet resultConnector = statement.executeQuery();

        while (resultConnector.next()) {
            ingredients.add(dao.getById(resultConnector.getInt("ingredientID")));
        }

        return ingredients;
    }
}

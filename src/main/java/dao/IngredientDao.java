package dao;

import model.Ingredient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public Ingredient getById(int id) throws SQLException {
        Ingredient ingredient = new Ingredient();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM ingredients where ingredientID = ?");

        statement.setInt(1, id);

        ResultSet resultIngredient = statement.executeQuery();

        resultIngredient.next();

        ingredient.setName(resultIngredient.getString("name"));

        return ingredient;
    }

    public int addIngredient(Ingredient ingredient) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO ingredients (name) values(?)", Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, ingredient.getName());
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    public List<Ingredient> getAllIngredients() throws SQLException {
        List<Ingredient> result = new ArrayList<>();
        PreparedStatement st = connection.prepareStatement("SELECT * FROM ingredients");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            result.add(new Ingredient(rs.getString("name")));
        }
        return result;
    }

    public Ingredient getByName(String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM ingredients WHERE name = ?");
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();
        if (!rs.next())
            return null;
        return new Ingredient(rs.getInt(1), rs.getString(2));
    }
}

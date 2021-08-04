package dao;

import filter.CocktailFilter;
import model.Cocktail;
import model.Ingredient;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CocktailDao {

    private static CocktailDao instance;

    public Connection con;


    public static CocktailDao getInstance() {
        if (instance == null)
            synchronized (UserDao.class) {
                if (instance == null)
                    instance = new CocktailDao();
            }
        return instance;
    }

    private CocktailDao() {
        try {
            Class.forName(DatabaseConstants.NAME);
            con = DriverManager.getConnection(
                    DatabaseConstants.URL, DatabaseConstants.USER, DatabaseConstants.PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void AddCocktail(Cocktail cockTail) {

    }

    public List<Cocktail> getCocktails(CocktailFilter filter) throws SQLException {
        List<Cocktail> cocktails = new ArrayList<>();
        StringBuilder where = new StringBuilder();
        List<Object> params = new ArrayList<>();
        if (filter.getName() != null) {
            where.append(" AND name LIKE ?");
            params.add("%" + filter.getName() + "%");
        }
        if (filter.getRating() != null) {
            if (filter.getRatingType() != null) {
                switch (filter.getRatingType()){
                    case LOWER: where.append(" AND rating <= ?"); break;
                    case HIGHER: where.append(" AND rating >= ?"); break;
                }
            } else {
                where.append(" AND rating = ?");
            }
            params.add(filter.getRating());
        }
        PreparedStatement statement = con.prepareStatement("select * from cocktails WHERE 1 = 1 " + where);
        for(int i = 1 ; i < params.size() + 1; i++){
            statement.setString(i, String.valueOf(params.get(i -1)));
        }
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            cocktails.add(convertToCocktail(result));
        }
        System.out.println(cocktails);
        return cocktails;
    }

    public List<Cocktail> getUserFavouriteCocktails(int userID, int offset, int quantity){
        List<Cocktail> cocktails = new ArrayList<>();
        String userFavDrinks = "select cocktailID from users_fav_cocktails WHERE userID = ? limit ? offset ?" ;
        try {
            PreparedStatement statement = con.prepareStatement(userFavDrinks);
            statement.setInt(1, userID);
            statement.setInt(2, quantity);
            statement.setInt(3, offset);
            ResultSet result = statement.executeQuery();

            String getCocktailByID = "select * from cocktails WHERE cocktailID = ?";
            statement = con.prepareStatement(getCocktailByID);

            while(result.next()){
                int cocktailID = result.getInt("cocktailID");
                statement.setInt(1, cocktailID);
                ResultSet res = statement.executeQuery();
                res.next();
                cocktails.add(convertToCocktail(res));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cocktails;
    }

    private Cocktail convertToCocktail(ResultSet result) throws SQLException {
        Cocktail curr = new Cocktail();
        curr.setName(result.getString("name"));
        curr.setRating(result.getDouble("rating"));
        curr.setVoters(result.getInt("voters"));

        int id = result.getInt(1);
        curr.setIngredients(getIngredients(id));
        return curr;
    }

    private List<Ingredient> getIngredients(int id) throws SQLException {
        List<Ingredient> ingredients = new ArrayList<>();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM cocktail_to_ingredients where cocktailId = ?");

        statement.setInt(1, id);
        ResultSet resultConnector = statement.executeQuery();

        while (resultConnector.next()) {
            System.out.println(resultConnector);
            ingredients.add(collectIngredient(resultConnector));
        }

        return ingredients;
    }

    private Ingredient collectIngredient(ResultSet resultConnector) throws SQLException {
        Ingredient ingredient = new Ingredient();

        PreparedStatement statement = con.prepareStatement("SELECT * FROM ingredient where id = ?");
        int id = resultConnector.getInt("ingredientId");
        statement.setInt(1, id);

        ResultSet resultIngredient = statement.executeQuery();

        resultIngredient.next();

        ingredient.setName(resultIngredient.getString("name"));
        ingredient.setWeight(resultIngredient.getDouble("weight"));
        ingredient.setPrice(resultIngredient.getDouble("price"));

        ingredient.toString();

        return ingredient;
    }
}


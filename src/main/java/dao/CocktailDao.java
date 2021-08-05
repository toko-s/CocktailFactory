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
    private static final int TOP_DRINKS_NUM = 5;

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

    public void addCocktail(Cocktail cocktail) {
        String query = " insert into cocktails (userID, name, rating, voters)"
                + " values (?, ?, ?, ?)";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, cocktail.getUserID());
            statement.setString(2, cocktail.getName());
            statement.setDouble(3, cocktail.getRating());
            statement.setDouble(4, cocktail.getVoters());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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


    public List<Cocktail> getUsersFavouriteCocktails(int userID, int offset, int quantity){
        List<Cocktail> cocktails = new ArrayList<>();
        try {
            String userFavDrinks = "select cocktailID from users_fav_cocktails WHERE userID = ? limit ? offset ?" ;

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

    public List<Cocktail> getUsersCocktails(int userID, int offset, int quantity){
        List<Cocktail> cocktails = new ArrayList<>();
        try {
            String userDrinks = "select * from cocktails WHERE userID = ? limit ? offset ?";
            PreparedStatement statement = con.prepareStatement(userDrinks);
            statement.setInt(1, userID);
            statement.setInt(2, quantity);
            statement.setInt(3, offset);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                cocktails.add(convertToCocktail(result));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cocktails;
    }

    public List<Cocktail> getTopDrinks(){
        List<Cocktail> cocktails = new ArrayList<>();

        try {
            String topDrinks = "select * from cocktails order by rating desc limit ?";
            PreparedStatement statement = con.prepareStatement(topDrinks);
            statement.setInt(1, TOP_DRINKS_NUM);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                cocktails.add(convertToCocktail(result));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cocktails;
    }

    private Cocktail convertToCocktail(ResultSet result) throws SQLException {
        Cocktail curr = new Cocktail();
        curr.setUserID(result.getInt("userID"));
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


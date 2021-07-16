package dao;

import model.Cocktail;
import model.Ingredient;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class CocktailDao {

    public Connection con;

    public CocktailDao() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/CocktailFactory","root","Gamersaninja1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddCocktail(Cocktail cockTail) {

    }
    public ArrayList<Cocktail> getCocktails() throws SQLException {
        ArrayList<Cocktail> cocktails = new ArrayList<Cocktail>();
        PreparedStatement statement = con.prepareStatement("select * from cocktail");
        ResultSet result = statement.executeQuery();
        while(result.next()) {
            cocktails.add(convertToCocktail(result));
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

    private ArrayList<Ingredient> getIngredients(int id) throws SQLException {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM coctail_to_ingredient where cocktailId = ?");

        statement.setInt(1,id);
        ResultSet resultConnector = statement.executeQuery();

        while(resultConnector.next()) {
            System.out.println(resultConnector);
            ingredients.add(collectIngredient(resultConnector));
        }

        return ingredients;
    }

    private Ingredient collectIngredient(ResultSet resultConnector) throws SQLException {
        Ingredient ingredient = new Ingredient();

        PreparedStatement statement = con.prepareStatement("SELECT * FROM ingredient where id = ?");
        int id = resultConnector.getInt("ingredientId");
        statement.setInt(1,id);

        ResultSet resultIngredient = statement.executeQuery();

        resultIngredient.next();

        ingredient.setName(resultIngredient.getString("name"));
        ingredient.setWeight(resultIngredient.getDouble("weight"));
        ingredient.setPrice(resultIngredient.getDouble("price"));

        ingredient.toString();

        return ingredient;
    }
}


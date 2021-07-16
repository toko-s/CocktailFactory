package dao;

import model.Cocktail;
import model.Ingredient;

import java.sql.*;
import java.util.ArrayList;

public class sqlCocktailDao {

    public Connection con;

    public sqlCocktailDao() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/CoctailFactory","root","Gamersaninja1");
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
        PreparedStatement statement = con.prepareStatement("SELECT * FROM coctail_to_ingredient where coctailId = ?");

        statement.setInt(1,id);
        ResultSet resultIngredients = statement.executeQuery();

        while(resultIngredients.next()) {
            System.out.println(resultIngredients);
            //ingredients.add(convertToIngredient(resultIngredients));
        }

        return ingredients;
    }

    private Ingredient convertToIngredient(ResultSet resultIngredients) throws SQLException {
        Ingredient ingredient = new Ingredient();

        ingredient.setName(resultIngredients.getString("name"));
        ingredient.setWeight(resultIngredients.getDouble("weight"));
        ingredient.setPrice(resultIngredients.getDouble("price"));

        ingredient.toString();

        return ingredient;
    }


}


package dao;

import model.Cocktail;

import java.sql.SQLException;
import java.util.List;


public class testinDao {
    public static void main(String[] args) {
        sqlCocktailDao dao = new sqlCocktailDao();
        try {
            List<Cocktail> l = dao.getCocktails();
            for (Cocktail x : l ){
                System.out.println(x.toString());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
package service;

import dao.IngredientDao;
import dao.IngredientToCocktailDao;
import model.Ingredient;

import java.sql.SQLException;
import java.util.List;

public class IngredientService {
    public static List<Ingredient> getIngredients() throws SQLException {
        return IngredientDao.getInstance().getAllIngredients();
    }
    public static int addIngredient(Ingredient ingredient) throws SQLException {
        IngredientDao dao = IngredientDao.getInstance();
        Ingredient existing = dao.getByName(ingredient.getName());
        if(existing != null) {
            return existing.getId();
        }
        return dao.addIngredient(ingredient);
    }

    public static void addIngredientToConnector(int ingredientID, int cocktailID, String ingredientQuantity) throws SQLException {
        IngredientToCocktailDao dao = IngredientToCocktailDao.getInstance();
        dao.addIngredientToConnector(ingredientID,cocktailID, ingredientQuantity);
    }
}

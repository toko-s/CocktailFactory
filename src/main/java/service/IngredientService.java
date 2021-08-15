package service;

import dao.IngredientDao;
import model.Ingredient;

import java.sql.SQLException;
import java.util.List;

public class IngredientService {
    public static List<Ingredient> getIngredients() throws SQLException {
        return IngredientDao.getInstance().getAllIngredients();
    }

}

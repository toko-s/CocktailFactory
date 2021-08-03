package service;

import dao.CocktailDao;
import filter.CocktailFilter;
import model.Cocktail;

import java.sql.SQLException;
import java.util.List;

public class CocktailService {
    public static List<Cocktail> getCocktails(CocktailFilter filter) throws SQLException {
        CocktailDao dao = CocktailDao.getInstance();
        return dao.getCocktails(filter);
    }
}

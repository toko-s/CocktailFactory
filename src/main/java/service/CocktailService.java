package service;

import dao.CocktailDao;
import filter.CocktailFilter;
import lombok.SneakyThrows;
import model.Cocktail;

import java.sql.SQLException;
import java.util.List;

public class CocktailService {
    public static List<Cocktail> getCocktails(CocktailFilter filter) throws SQLException {
        CocktailDao dao = CocktailDao.getInstance();
        return dao.getCocktails(filter);
    }

    public static Cocktail getCocktailById(int id) throws SQLException {
        CocktailDao dao = CocktailDao.getInstance();
        return dao.getCocktailById(id);
    }

    public static int addCocktail(Cocktail cocktail) throws SQLException {
        CocktailDao dao = CocktailDao.getInstance();
        return dao.addCocktail(cocktail);
    }
}

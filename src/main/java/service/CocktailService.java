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

    public static boolean checkFavourite(int cocktailId, int userId) throws SQLException {
        CocktailDao dao = CocktailDao.getInstance();
        return dao.checkUsersFavouriteCocktail(cocktailId,userId);
    }

    public static void renewFavourite(int userId,int cocktailId, boolean val) throws SQLException {
        CocktailDao dao = CocktailDao.getInstance();
        dao.setUsersFavouriteCocktail(userId,cocktailId,val);
    }

    public static void voteFromUser(int id, int cocktailId, int vote) throws SQLException {
        CocktailDao dao = CocktailDao.getInstance();
        Cocktail cocktail = dao.getCocktailById(cocktailId);
        int voters = cocktail.getVoters();
        double rating = cocktail.getRating();
        rating = (rating * voters + vote)/(voters + 1);
        cocktail.setVoters(voters + 1);
        cocktail.setRating(rating);
        dao.saveCocktail(cocktail.getId(), rating, voters + 1);
    }
}

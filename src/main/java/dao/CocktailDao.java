package dao;

import filter.CocktailFilter;
import model.Cocktail;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CocktailDao {

    private static final int TOP_DRINKS_NUM = 5;

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

    public Cocktail getCocktailById(int cocktailId) throws SQLException {
        Cocktail cocktail;

        PreparedStatement statement = con.prepareStatement("SELECT * FROM cocktails where cocktailID = ?");
        statement.setInt(1,cocktailId);

        ResultSet result = statement.executeQuery();

        result.next();
        cocktail = convertToCocktail(result);
        return cocktail;
    }

    public List<Cocktail> getCocktails(CocktailFilter filter) throws SQLException {
        List<Cocktail> cocktails = new ArrayList<>();
        StringBuilder where = new StringBuilder();
        List<Object> params = new ArrayList<>();
        if (filter != null) {

            if (filter.getName() != null) {
                where.append(" AND name LIKE ?");
                params.add("%" + filter.getName() + "%");
            }
            if (filter.getRating() != null) {
                if (filter.getRatingType() != null) {
                    switch (filter.getRatingType()) {
                        case LOWER:
                            where.append(" AND rating <= ?");
                            break;
                        case HIGHER:
                            where.append(" AND rating >= ?");
                            break;
                    }
                } else {
                    where.append(" AND rating = ?");
                }
                params.add(filter.getRating());
            }
            if (filter.getOrder() != null) {
                where.append(" ORDER BY rating ");
                switch (filter.getOrder()) {
                    case ASCENDING:
                        where.append("ASC");
                        break;
                    case DESCENDING:
                        where.append("DESC");
                        break;
                }
            }
        }
        PreparedStatement statement = con.prepareStatement("select * from cocktails WHERE 1 = 1 " + where);
        for(int i = 1 ; i < params.size() + 1; i++){
            statement.setString(i, String.valueOf(params.get(i -1)));
        }
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            cocktails.add(convertToCocktail(result));
        }
        return cocktails;
    }


    public List<Cocktail> getUsersFavouriteCocktails(int userID){
        List<Cocktail> cocktails = new ArrayList<>();
        try {
            String userFavDrinks = "select cocktailID from users_fav_cocktails WHERE userID = ?" ;

            PreparedStatement statement = con.prepareStatement(userFavDrinks);
            statement.setInt(1, userID);
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

    public List<Cocktail> getUsersCocktails(int userID){
        List<Cocktail> cocktails = new ArrayList<>();
        try {
            String userDrinks = "select * from cocktails WHERE userID = ?";
            PreparedStatement statement = con.prepareStatement(userDrinks);
            statement.setInt(1, userID);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                cocktails.add(convertToCocktail(result));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cocktails;
    }

    public void updateUserInfo(User user){
        try {
            String userDrinks = "update users set username = ?, password = ?, name = ?, surname = ? WHERE userID = ?;";
            PreparedStatement statement = con.prepareStatement(userDrinks);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setInt(5, user.getId());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
        IngredientToCocktailDao dao = IngredientToCocktailDao.getInstance();
        Cocktail curr = new Cocktail();
        curr.setUserID(result.getInt("userID"));
        curr.setName(result.getString("name"));
        curr.setRating(result.getDouble("rating"));
        curr.setVoters(result.getInt("voters"));
        curr.setId(result.getInt("cocktailID"));
        curr.setIngredients(dao.getIngredientsByCocktailId(result.getInt(1)));
        return curr;
    }
}


package servlet;

import dao.CocktailDao;
import model.Cocktail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CocktailDao dao = new CocktailDao();
        Cocktail cocktail = new Cocktail();
        cocktail.setUserID(3);
        cocktail.setName("Mohito");
        cocktail.setRating(4.2);
        cocktail.setVoters(23);
        dao.AddCocktail(cocktail);

        List<Cocktail> cocktails = dao.getUsersCocktails(3, 0, 1);
        for(int i = 0; i < cocktails.size(); i++){
            System.out.println(cocktails.get(i));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

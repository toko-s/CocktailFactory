package servlet;

import dao.CocktailDao;
import model.Cocktail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/cocktailpage")
public class CocktailPageServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String currcocktailId = req.getParameter("id");

        CocktailDao dao = CocktailDao.getInstance();

        Cocktail cocktail = null;
        try {
            cocktail = dao.getCocktailById(Integer.valueOf(currcocktailId));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("cocktail", cocktail);

        req.setAttribute("cocktail", cocktail);
        req.getRequestDispatcher("/CocktailPage.jsp").forward(req, resp);
    }
}

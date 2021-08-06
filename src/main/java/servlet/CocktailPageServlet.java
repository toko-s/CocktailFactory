package servlet;

import dao.CocktailDao;
import filter.CocktailFilter;
import model.Cocktail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cocktailpage")
public class CocktailPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        String currcocktailId = req.getParameter("id");

        CocktailDao dao = CocktailDao.getInstance();

        Cocktail cocktail = dao.getCocktailById(Integer.valueOf(currcocktailId));

        req.setAttribute("cocktail",cocktail);

        System.out.println(currcocktailId);
        req.setAttribute("cocktail",cocktail);
        req.getRequestDispatcher("/CocktailPage.jsp").forward(req,resp);
    }




}

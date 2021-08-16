package servlet;

import service.CocktailService;

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
        try {
            req.setAttribute("cocktail", CocktailService.getCocktailById(Integer.parseInt(req.getParameter("id"))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/CocktailPage.jsp").forward(req, resp);
    }
}

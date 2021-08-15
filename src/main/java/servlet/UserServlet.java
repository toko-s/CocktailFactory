package servlet;

import dao.CocktailDao;
import model.Cocktail;
import model.User;

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
        CocktailDao dao = CocktailDao.getInstance();
        User user = (User)req.getServletContext().getAttribute("user");
        req.setAttribute("user", user);
        req.setAttribute("favDrinks", dao.getUsersFavouriteCocktails(user.getId(), 0, 5));
        req.setAttribute("addedDrinks", dao.getUsersCocktails(user.getId(), 0, 5));
        req.getRequestDispatcher("/user.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

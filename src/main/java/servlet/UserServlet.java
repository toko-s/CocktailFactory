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
        User user = (User)req.getServletContext().getAttribute("user");
        if(user==null){
            resp.sendRedirect("/login");
            return;
        }
        CocktailDao dao = CocktailDao.getInstance();
        List<Cocktail> addedDrinks = dao.getUsersCocktails(user.getId());
        List<Cocktail> favDrinks = dao.getUsersFavouriteCocktails(user.getId());
        req.setAttribute("addedCocktails", addedDrinks);
        req.setAttribute("favCocktails", favDrinks);
        req.getRequestDispatcher("/user.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

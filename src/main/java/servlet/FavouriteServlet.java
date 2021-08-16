package servlet;

import model.User;
import service.CocktailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/favourite")
public class FavouriteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isFav = Boolean.parseBoolean(req.getParameter("isFavourite"));
        int cocktailId = Integer.parseInt(req.getParameter("id"));
        User u = (User) req.getServletContext().getAttribute("user");
        if (u == null) {
            resp.sendRedirect("/login");
            return;
        }
        try {
            CocktailService.renewFavourite(u.getId(), cocktailId, isFav);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/main");
    }
}

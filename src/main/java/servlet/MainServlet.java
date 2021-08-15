package servlet;

import dao.CocktailDao;
import filter.CocktailFilter;
import lombok.SneakyThrows;
import model.Cocktail;
import service.CocktailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CocktailDao dao = CocktailDao.getInstance();
        List<Cocktail> cocktails = dao.getTopDrinks();
        req.setAttribute("cocktails", cocktails);
        req.getRequestDispatcher("/main.jsp").forward(req,resp);
    }
}

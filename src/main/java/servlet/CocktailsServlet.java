package servlet;


import dao.CocktailDao;
import dao.UserDao;
import filter.CocktailFilter;
import lombok.SneakyThrows;
import model.Cocktail;
import service.CocktailService;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cocktails")
public class CocktailsServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
//        CocktailFilter filter = CocktailFilter.builder().build();
        CocktailFilter filter = null;
        List<Cocktail> cocktails = CocktailService.getCocktails(filter);


        req.setAttribute("list",cocktails);
        req.getRequestDispatcher("/Cocktails.jsp").forward(req,resp);
    }

}

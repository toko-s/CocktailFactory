package servlet;

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
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        CocktailFilter filter = CocktailFilter.builder()
//                .name(req.getParameter("name"))
//                .rating(req.getParameter("rating"))
//                .ratingType(req.getParameter("type"))
//                .build();
//        List<Cocktail> cocktails= CocktailService.getCocktails(filter);
//        req.setAttribute("cocktails",cocktails);
        System.out.println(req.getServletContext().getAttribute("user"));
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getServletContext().getAttribute("user"));
        resp.sendRedirect("/index.jsp");
    }
}

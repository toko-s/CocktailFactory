package servlet;

import dao.CocktailDao;
import model.Cocktail;
import model.Ingredient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/addCoctail")
public class AddCoctailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Ingredient> ingredientList = new ArrayList<Ingredient>();

        ingredientList.add(new Ingredient("koka"));

        ingredientList.add(new Ingredient("shokoladi"));

        ingredientList.add(new Ingredient("brat"));

        ingredientList.add(new Ingredient("dzma"));

        ingredientList.add(new Ingredient("lomi"));

        ingredientList.add(new Ingredient("mgeli"));


        req.setAttribute("ings",ingredientList);
        req.getRequestDispatcher("/AddCocktail.jsp").forward(req,resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("zd");


    }
}

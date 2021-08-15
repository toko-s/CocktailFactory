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
import java.util.Enumeration;
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
        Cocktail currCocktail = new Cocktail();

        List<Ingredient> ingredientsBefore = new ArrayList<>();
        List<Ingredient> ingredientsForMyCocktail = new ArrayList<>();

        Enumeration parameterNames = req.getParameterNames();

        // es cesit saxelia
        String parameterName1 = (String) parameterNames.nextElement();
        currCocktail.setName(req.getParameter(parameterName1));

        //es cesit image
        String parameterName2 = (String) parameterNames.nextElement();
        String imageString = req.getParameter(parameterName2);
        handleParameterImage(imageString);

        while (parameterNames.hasMoreElements()) {

            String parameterName = (String) parameterNames.nextElement();
            String ingredient = req.getParameter(parameterName);
            int index = ingredient.indexOf(":");
            String ingredientQuantity = ingredient.substring(index);

            if (ingredientQuantity == "none") {
                continue;
            } else {
                String ingredientName = ingredient.substring(0, index);

                //ingredientQuantity
                //ingredientQuantity ageraa es quantitys stringi

                Ingredient newIngredient = new Ingredient(ingredientName);

                ingredientsForMyCocktail.add(newIngredient);

                if(currentBaseContainsIngrediet(newIngredient,ingredientsBefore)) {

                } else {
                    addIngredientToIngredientBase(newIngredient);
                }
            }
        }


        setUserIdToCocktail();

        CocktailDao.getInstance().addCocktail(currCocktail);
    }

    private void setUserIdToCocktail() {

    }

    private void handleParameterImage(String imageString) {

    }

    private void addIngredientToIngredientBase(Ingredient ingredient) {

    }

    private Boolean currentBaseContainsIngrediet(Ingredient ingredient, List<Ingredient> ingredientsBefore ) {
        for (Ingredient curr:
                ingredientsBefore) {
            if( curr.getName() == ingredient.getName()) {
                return true;
            }
        }
        return false;
    }

}

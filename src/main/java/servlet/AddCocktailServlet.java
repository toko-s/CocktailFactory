package servlet;

import lombok.SneakyThrows;
import model.Cocktail;
import model.Ingredient;
import model.User;
import service.CocktailService;
import service.IngredientService;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


@WebServlet("/addCocktail")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class AddCocktailServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (req.getServletContext().getAttribute("user") == null) {
            resp.sendRedirect("/login");
        } else {
            List<Ingredient> ingredientList = IngredientService.getIngredients();
            req.setAttribute("ings", ingredientList);
            req.getRequestDispatcher("/AddCocktail.jsp").forward(req, resp);
        }

    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cocktail cocktail = new Cocktail();

        Scanner sc = new Scanner(req.getPart("CocktailName").getInputStream());
        cocktail.setName(sc.nextLine());

        cocktail.setUserID(((User) req.getServletContext().getAttribute("user")).getId());

        int cocktailId = CocktailService.addCocktail(cocktail);

        Object[] array = req.getParts().toArray();
        for (int i = 2; i < array.length; i++) {
            Part part = (Part) array[i];
            sc = new Scanner(part.getInputStream());
            String ingredient = sc.nextLine();
            int index = greedyIndexOf(ingredient, ':');
            String ingredientQuantity = ingredient.substring(index + 2);

            if (!ingredientQuantity.equals("none")) {
                String ingredientName = ingredient.substring(0, index - 1);

                Ingredient newIngredient = new Ingredient(ingredientName);

                int ingredientId = IngredientService.addIngredient(newIngredient);

                IngredientService.addIngredientToConnector(ingredientId, cocktailId, ingredientQuantity);
            }
        }
        try {
            Part img = (Part) array[1];
            BufferedImage bufferedImage = ImageIO.read(img.getInputStream());
            ImageIO.write(bufferedImage, "jpg", new File("src/main/webapp/cocktail_images/" + cocktailId + ".jpg"));
        } catch (Exception ignored) {
        }
        resp.sendRedirect("/cocktails");
    }

    private int greedyIndexOf(String str, char c) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

}


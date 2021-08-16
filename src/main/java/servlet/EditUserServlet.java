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

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getServletContext().getAttribute("user");
        req.setAttribute("user", user);
        StringBuilder pass = new StringBuilder();
        int length = user.getPassword().length();
        for(int i = 0; i < length; i++){
            pass.append("*");
        }

        req.setAttribute("password", pass.toString());
        req.getRequestDispatcher("/editUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getServletContext().getAttribute("user");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        if (password.isEmpty()) password = user.getPassword();

        User userUpdated = new User(user.getId(), username, password);
        userUpdated.setName(name);
        userUpdated.setSurname(surname);

        CocktailDao dao = CocktailDao.getInstance();
        dao.updateUserInfo(userUpdated);

        resp.sendRedirect("/user");
    }
}

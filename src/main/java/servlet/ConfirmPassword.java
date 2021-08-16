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

@WebServlet("/confirmPassword")
public class ConfirmPassword extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/confirmPassword.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        User user = (User)req.getServletContext().getAttribute("user");
        if (password.equals(user.getPassword())) {
            resp.sendRedirect("/editUser");
        } else {
            req.setAttribute("message", "Wrong Password");
            req.getRequestDispatcher("/confirmPassword.jsp").forward(req,resp);
        }
    }
}

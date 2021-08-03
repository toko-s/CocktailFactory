package servlet;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO[TS] validate input, check for existing users, add field for error in registration form.
        User user = User.builder()
                .username(req.getParameter("username"))
                .password(req.getParameter("password"))
                .surname(req.getParameter("surname"))
                .name(req.getParameter("name"))
                .build();
        UserDao userDao = UserDao.getInstance();
        userDao.add(user);
        req.getRequestDispatcher("/").forward(req,resp);
    }
}

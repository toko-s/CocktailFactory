package servlet;

import dao.UserDao;
import model.User;
import response.UserResponse;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = User.builder()
                .username(req.getParameter("username"))
                .password(req.getParameter("password"))
                .surname(req.getParameter("surname"))
                .name(req.getParameter("name"))
                .build();
        UserResponse response = UserService.register(user);
        if (response.getType() != UserResponse.ResponseType.SUCCESS) {
            req.setAttribute("error", "User by the name '" + user.getUsername() + "' already exists!");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/main").forward(req, resp);
        }
    }
}

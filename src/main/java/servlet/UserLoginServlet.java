package servlet;


import model.User;
import response.UserResponse;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserResponse response = UserService.login(user);

        if (response.getType() == UserResponse.ResponseType.SUCCESS) {
            req.getServletContext().setAttribute("user", response.getUser());
            resp.sendRedirect("/main");
        } else {
            req.setAttribute("head", response.getType());
            req.setAttribute("username", username);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}

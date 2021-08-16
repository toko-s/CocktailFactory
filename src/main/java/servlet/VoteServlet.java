package servlet;

import lombok.SneakyThrows;
import model.User;
import service.CocktailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u = (User) req.getServletContext().getAttribute("user");
        if (u != null) {
            int vote = Integer.parseInt(req.getParameter("vote"));
            int cocktailId = Integer.parseInt(req.getParameter("id"));
            CocktailService.voteFromUser(u.getId(), cocktailId, vote);
        }else {
            resp.sendRedirect("/login");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/main");
    }
}

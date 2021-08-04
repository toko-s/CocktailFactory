package manager;

import model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;

@WebListener
public class UserManager implements ServletContextListener {
    private User user;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext sc = servletContextEvent.getServletContext();
        sc.setAttribute("user", user);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
package poe.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import poe.entity.Ranks;
import poe.entity.Users;
import poe.persistence.InfoGrabber;
import java.io.IOException;

@WebServlet (
        urlPatterns = {"/home"}
)
public class HomePortal extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InfoGrabber info = new InfoGrabber();

        String username = req.getRemoteUser();

        if (username != null) {
            Users user = info.grabUserByUsername(username);
            Ranks rank = info.grabRank(user);

            req.setAttribute("rank", rank);
            req.setAttribute("user", user);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }
    }
}

package poe.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import poe.entity.Builds;
import poe.entity.Ranks;
import poe.entity.Users;
import poe.persistence.InfoGrabber;
import java.io.IOException;

@WebServlet (
        urlPatterns = {"/addtask"}
)
public class AddTask extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InfoGrabber info = new InfoGrabber();
        String username = req.getRemoteUser();
        Users user;
        if (username != null) {
            user = info.grabUserByUsername(username);
            Ranks rank = info.grabRank(user);
            req.setAttribute("user", user);
            req.setAttribute("rank", rank);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/addTask.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }
    }
}

package poe.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import poe.entity.*;
import poe.persistence.InfoGrabber;

@WebServlet (
        urlPatterns = {"/error"}
)
public class Error extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        InfoGrabber info = new InfoGrabber();
        String username = req.getRemoteUser();
        Users user;
        if (username != null) {
            user = info.grabUserByUsername(username);
            Ranks rank = info.grabRank(user);
            req.setAttribute("user", user);
            req.setAttribute("rank", rank);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }
    }
}

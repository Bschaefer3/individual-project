package poe.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import poe.persistence.InfoGrabber;
import java.io.IOException;

@WebServlet (
        urlPatterns = {"/removePair"}
)
public class RemovePair extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getRemoteUser();

        if (username != null) {
            String id = req.getParameter("id");

            InfoGrabber info = new InfoGrabber();

            info.removePair(id);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("profile");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }

    }

}
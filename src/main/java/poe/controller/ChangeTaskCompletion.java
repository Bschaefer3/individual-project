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
        urlPatterns = {"/changetask"}
)

public class ChangeTaskCompletion extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        InfoGrabber info = new InfoGrabber();

        String id = req.getParameter("id");
        Tasks task = info.getTaskById(id);
        info.updateTaskCompletion(task);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/quests");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }
    }
}

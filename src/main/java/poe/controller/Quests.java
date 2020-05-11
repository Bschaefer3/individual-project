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

import java.util.List;

@WebServlet (
        urlPatterns = {"/quests"}
)

public class Quests extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        InfoGrabber info = new InfoGrabber();
        String username = req.getRemoteUser();
        Users user = new Users();
        if (username != null) {
            user = info.grabUserByUsername(username);
            Ranks rank = info.grabRank(user);
            req.setAttribute("user", user);
            req.setAttribute("rank", rank);
        }

        List<Tasks> taskList = info.grabTasksFromUser(user);
        req.setAttribute("tasks", taskList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/quests.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }
    }
}

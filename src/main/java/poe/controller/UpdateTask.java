package poe.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import poe.entity.Builds;
import poe.entity.Ranks;
import poe.entity.Users;
import poe.persistence.GenericDao;
import poe.persistence.InfoGrabber;

@WebServlet (
        urlPatterns = {"/taskadded"}
)
public class UpdateTask extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        final Logger logger = LogManager.getLogger(this.getClass());
        InfoGrabber info = new InfoGrabber();
        String username = req.getRemoteUser();
        Users user = new Users();
        if (username != null) {
            user = info.grabUserByUsername(username);
            Ranks rank = info.grabRank(user);
            req.setAttribute("user", user);
            req.setAttribute("rank", rank);
        }

        String newTask = req.getParameter("task");
        info.addTask(user, newTask);

        RequestDispatcher dispatcher = req.getRequestDispatcher("quests");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }

    }

}

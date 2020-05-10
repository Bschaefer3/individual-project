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
        urlPatterns = {"/build"}
)
public class Build extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InfoGrabber info = new InfoGrabber();

        String username = req.getRemoteUser();

        logger.info(username);

        Users user = info.grabUser(username);
        Builds build = info.grabBuild(username);
        Ranks rank = info.grabRank(user);

        req.setAttribute("rank", rank);
        req.setAttribute("user", user);
        req.setAttribute("build", build);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editBuild.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }
    }
}

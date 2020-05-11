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
import poe.entity.Users;
import poe.persistence.GenericDao;
import poe.persistence.InfoGrabber;
import java.io.IOException;

@WebServlet (
        urlPatterns = {"/updateBuild"}
)
public class UpdateBuild extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Logger logger = LogManager.getLogger(this.getClass());

        String newBuild = req.getParameter("build");
        logger.info(newBuild);

        InfoGrabber info = new InfoGrabber();

        String username = req.getRemoteUser();
        Users user = info.grabUserByUsername(username);
        Builds build = info.grabBuild(username);

        GenericDao<Builds> buildDao = new GenericDao<>(Builds.class);
        build.setBuild(newBuild);
        buildDao.saveOrUpdate(build);
        user.setBuild(build);

        RequestDispatcher dispatcher = req.getRequestDispatcher("profile");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }

    }

}

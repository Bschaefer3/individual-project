package poe.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import poe.entity.BuildItems;
import poe.entity.Builds;
import poe.entity.Items;
import poe.entity.Users;
import poe.persistence.GenericDao;
import java.io.IOException;
import java.util.List;

@WebServlet (
        urlPatterns = {"/profile"}
)
public class Profile extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Users> userDao = new GenericDao<>(Users.class);
        GenericDao<Builds> buildDao = new GenericDao<>(Builds.class);

        String username = req.getRemoteUser();
        List<Users> users = userDao.getByPropertyEqual("username", username);
        Users user = users.get(0);

        logger.info(username);

        List<Builds> builds;
        Builds build = new Builds();
        List<BuildItems> pairs;
        builds = buildDao.getByPropertyEqual("username", username);
        if (!builds.isEmpty()) {
            build = builds.get(0);
            logger.info(build);

            pairs  = build.getPairs();

            for (int i = 1; i < pairs.size(); i++) {
                String name = "item" + i;
                BuildItems pair = pairs.get(i);
                Items item = pair.getItem();

                logger.info("Item Grabbed (" + i + "): " + item.getName());

                req.setAttribute(name, item);
            }
        }

        req.setAttribute("user", user);
        req.setAttribute("build", build);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/account.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }
    }
}

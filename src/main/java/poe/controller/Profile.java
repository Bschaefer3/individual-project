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
import poe.persistence.InfoGrabber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (
        urlPatterns = {"/profile"}
)
public class Profile extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InfoGrabber info = new InfoGrabber();

        String username = req.getRemoteUser();
        Users user = info.grabUser(username);

        logger.info(username);

        GenericDao<Builds> buildDao = new GenericDao<>(Builds.class);
        List<Builds> builds = buildDao.getByPropertyEqual("username", username);
        Builds build = new Builds();
        List<BuildItems> pairs;
        if (!builds.isEmpty()) {
            build = builds.get(0);
            logger.info(build);

            pairs = build.getPairs();

            List<Items> itemList = new ArrayList<>();
            for (int i = 1; i < pairs.size(); i++) {
                BuildItems pair = pairs.get(i);
                Items item = pair.getItem();

                itemList.add(item);

                logger.info("Item Grabbed (" + i + "): " + item.getName());

                req.setAttribute("items", itemList);
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

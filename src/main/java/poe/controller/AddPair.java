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
import poe.entity.Items;
import poe.entity.Users;
import poe.persistence.InfoGrabber;
import java.io.IOException;

@WebServlet (
        urlPatterns = {"/addPair"}
)
public class AddPair extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getRemoteUser();

        Items item = new Items();
        Users user = new Users();
        if (username != null) {
            String itemName = req.getParameter("item");

            InfoGrabber info = new InfoGrabber();

            user = info.grabUserByUsername(username);

            Builds build = info.grabBuild(username);
            item = info.grabItemToPair(itemName, build);

            item.addPair(build);
            build.addPair(item);
        }

        req.setAttribute("user", user);
        req.setAttribute("item", item);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/addItemToList.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }

    }

}
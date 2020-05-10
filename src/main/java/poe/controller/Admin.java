package poe.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import poe.entity.*;
import poe.persistence.InfoGrabber;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet (
        urlPatterns = {"/admin"}
)
public class Admin extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InfoGrabber info = new InfoGrabber();

        Items displayItem = (Items)req.getSession().getAttribute("item");

        String username = req.getRemoteUser();
        Users user = info.grabUserByUsername(username);
        Ranks rank = info.grabRank(user);

        List<Users> userList = info.grabAllUsers();
        Iterator<Users> itr = userList.iterator();
        while (itr.hasNext()) {
            Users current = itr.next();
            if (current.equals(user)) {
                itr.remove();
            }
        }

        req.setAttribute("rank", rank);
        req.setAttribute("user", user);
        req.setAttribute("users", userList);
        req.setAttribute("item", displayItem);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }
    }
}

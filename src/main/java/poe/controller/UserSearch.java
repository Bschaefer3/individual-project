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
        urlPatterns = {"/userSearch"}
)
public class UserSearch extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        InfoGrabber info = new InfoGrabber();

        String username = req.getRemoteUser();
        String searchTerm = req.getParameter("search");
        Users user = new Users();
        if (username != null) {
            user = info.grabUserByUsername(username);
        }

        List<Users> userList = info.grabUsersByTerm(searchTerm);
        sendRequest(req, resp, info, user, userList);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        InfoGrabber info = new InfoGrabber();

        String username = req.getRemoteUser();
        Users user = new Users();
        if (username != null) {
            user = info.grabUserByUsername(username);
        }

        List<Users> userList = info.grabAllUsers();
        sendRequest(req, resp, info, user, userList);
    }

    private void sendRequest(HttpServletRequest req, HttpServletResponse resp, InfoGrabber info, Users user, List<Users> userList) {
        String username = req.getRemoteUser();
        if (username != null) {
            userList = info.removeMeFromList(userList, user);
            req.setAttribute("user", user);
        }

        req.setAttribute("users", userList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/userSearch.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }
    }
}

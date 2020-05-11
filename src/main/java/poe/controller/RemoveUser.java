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

import static java.lang.Integer.parseInt;

@WebServlet (
        urlPatterns = {"/removeuser"}
)
public class RemoveUser extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InfoGrabber info = new InfoGrabber();

        String username = req.getRemoteUser();
        if (username != null) {
            Users user = info.grabUserByUsername(username);
            req.setAttribute("user", user);
        }

        String userId = req.getParameter("id");
        Users userToDelete = info.grabUserById(parseInt(userId));
        Ranks rank = info.grabRank(userToDelete);
        req.setAttribute("deleteduser", userToDelete);
        req.setAttribute("rank", rank);
        info.removeUser(userToDelete);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/userDeleted.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }
    }
}

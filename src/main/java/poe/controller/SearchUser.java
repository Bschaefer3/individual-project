package poe.controller;

import poe.persistence.UsersDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Search for User by ID, First Name, Last Name, or get all users
 */
@WebServlet(
        urlPatterns = {"/searchUser"}
)
public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Logger logger = LogManager.getLogger(this.getClass());

        String searchTerm = req.getParameter("term");
        String searchProperty = req.getParameter("type");
        logger.debug(searchProperty + " " + searchTerm);
        UsersDao userSearch = new UsersDao();

        if (searchTerm.equals("")) {
            req.setAttribute("users", userSearch.getAll());
        } else {
            req.setAttribute("users", userSearch.getByPropertyLike(searchProperty, searchTerm));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
package poe.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import poe.entity.Items;
import poe.persistence.InfoGrabber;

import java.io.IOException;
import java.util.List;

@WebServlet (
        urlPatterns = {"/itemSearch"}
)
public class ItemSearch extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchTerm = req.getParameter("search");

        InfoGrabber info = new InfoGrabber();
        List<Items> itemList = info.grabItemsByName(searchTerm);
        req.removeAttribute("items");
        req.setAttribute("items", itemList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/searchItems.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }

    }
}

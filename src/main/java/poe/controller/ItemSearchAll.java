package poe.controller;

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
        urlPatterns = {"/itemSearchAll"}
)
public class ItemSearchAll extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        InfoGrabber info = new InfoGrabber();
        List<Items> itemList = info.grabAllItems();
        ItemSearch.setUserAttribute(req, resp, info, itemList, logger);

    }
}

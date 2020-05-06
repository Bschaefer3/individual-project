package poe.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import poe.entity.BuildItems;
import poe.entity.Builds;
import poe.entity.Users;
import poe.persistence.GenericDao;

import java.io.IOException;

@WebServlet (
        urlPatterns = {"/profile"}
)
public class Profile extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao userDao = new GenericDao(Users.class);
        GenericDao buildDao = new GenericDao(Builds.class);
        GenericDao pairDao = new GenericDao(BuildItems.class);




    }
}
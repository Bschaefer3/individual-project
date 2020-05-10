package poe.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import poe.entity.Ranks;
import poe.entity.Users;
import poe.persistence.GenericDao;
import poe.persistence.InfoGrabber;

import java.util.List;

@WebServlet (
        urlPatterns = {"/signup"}
)
public class SignUp extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        InfoGrabber info = new InfoGrabber();

        String typedname  = req.getParameter("username");
        String username   = typedname.toLowerCase();
        String firstName  = req.getParameter("fname");
        String lastName   = req.getParameter("lname");
        String password1  = req.getParameter("password1");
        String password2  = req.getParameter("password2");
        String rank       = req.getParameter("rank");
        Boolean usernameAvailable = true;

        GenericDao<Users> userDao = new GenericDao<>(Users.class);
        List<Users> userList = userDao.getAll();

        RequestDispatcher dispatcher = req.getRequestDispatcher("/signup.jsp");

        if (!typedname.equals("") && !firstName.equals("") && !lastName.equals("") && !password1.equals("") && !password2.equals("")) {
            if (password1.equals(password2)) {
                for (Users user : userList) {
                    if (user.getUsername().equals(username)) {
                        usernameAvailable = false;
                    }
                }

                if (Boolean.TRUE.equals(usernameAvailable)) {
                    Users newUser = new Users(0, username, password1, firstName, lastName);
                    int id = info.addUser(newUser);
                    Users user = info.grabUserById(id);

                    Ranks newRank = new Ranks(rank, user.getUsername(), user);

                    user.addRank(newRank);
                    info.addRank(newRank);

                    dispatcher = req.getRequestDispatcher("/newUser.jsp");
                } else {
                    req.setAttribute("errorMessage", "Username already taken!");
                }
            } else {
                req.setAttribute("errorMessage", "Passwords do not match!");
            }
        } else {
            req.setAttribute("errorMessage", "Please fill in all fields!");
        }

        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/signup.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("context", e);
        }
    }
}

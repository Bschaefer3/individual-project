package poe.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import poe.entity.Users;
import poe.persistence.GenericDao;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/searchUsersById")
public class SearchUsersById {

    @GET
    @Produces("application/html")
    public Response getMessage( @FormParam("term") String term, @FormParam("type") String type) {

        final Logger logger = LogManager.getLogger(this.getClass());

        StringBuilder output = new StringBuilder();

        logger.debug(type + " " + term);
        GenericDao userSearch = new GenericDao(Users.class);

        List<Users> userList;

        if (term.equals("")) {
            userList = userSearch.getAll();
        } else {
            userList = userSearch.getByPropertyLike(type, term);
        }

        logger.debug(userList);

        for(Object user : userList) {
            output.append(user.toString());
            output.append("\n");
        }

        return Response.status(200).entity("Users Retrieved: <br />" + output.toString()).build();
    }
}
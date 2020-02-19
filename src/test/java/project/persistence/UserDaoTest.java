package project.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.entity.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test Class for UserDao, Tests Database methods
 */
public class UserDaoTest {

    UserDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Resets the Database back to it's normal state
     */
    @BeforeEach
    void setUp() {

        project.test.util.Database database = project.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new UserDao();
    }


    /**
     * Checks to see if getById works
     */
    @Test
    void getByIdSuccess() {

        User retrievedUser = dao.getById(3);
        assertEquals("Arsim", retrievedUser.getFirstname());
        assertEquals("Odza", retrievedUser.getLastname());
        assertEquals("Kurumu", retrievedUser.getUsername());

    }

    /**
     * Checks to see if the database updates correctly
     */
    @Test
    void saveOrUpdateSuccess() {
        User userToUpdate = dao.getById(3);
        String newLastName = "Bungus";
        userToUpdate.setLastname(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getById(3);
        assertEquals(newLastName, retrievedUser.getLastname());

    }

    /**
     * Checks to see if inserting into the database works
     */
    @Test
    void insertSuccess() {
        User newUser = new User();
        newUser.setId(1);
        newUser.setUsername("Meaty");
        newUser.setPassword("shakeshacc");
        newUser.setFirstname("Cameron");
        newUser.setLastname("Coomer");
        dao.insert(newUser);
        User retrievedUser = dao.getById(4);
        assertEquals("Coomer", retrievedUser.getLastname());

    }

    /**
     * Checks to see if you can delete from the database successfully
     */
    @Test
    void deleteSuccess() {
        User toBeDeleted = dao.getById(1);
        dao.delete(toBeDeleted);
        User retrievedUser = dao.getById(1);
        assertNull(retrievedUser);

    }

    /**
     * Checks to see if you can grab all users in the database
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(3, users.size());

    }

}
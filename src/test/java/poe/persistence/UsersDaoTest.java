package poe.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import poe.entity.Tasks;
import poe.entity.Users;
import poe.test.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test Class for UserDao, Tests Database methods
 */
public class UsersDaoTest {

    UsersDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Resets the Database back to it's normal state
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new UsersDao();
    }


    /**
     * Checks to see if getById works
     */
    @Test
    void getByIdSuccess() {

        Users retrievedUser = dao.getById(3);
        assertEquals("Arsim", retrievedUser.getFirstname());
        assertEquals("Odza", retrievedUser.getLastname());
        assertEquals("Kurumu", retrievedUser.getUsername());

    }

    /**
     * Checks to see if the database updates correctly
     */
    @Test
    void saveOrUpdateSuccess() {
        Users userToUpdate = dao.getById(3);
        String newLastName = "Bungus";
        userToUpdate.setLastname(newLastName);
        dao.saveOrUpdate(userToUpdate);
        Users retrievedUser = dao.getById(3);
        assertEquals(newLastName, retrievedUser.getLastname());

    }

    /**
     * Checks to see if inserting into the database works
     */
    @Test
    void insertSuccess() {
        Users newUser = new Users();
        newUser.setId(1);
        newUser.setUsername("Meaty");
        newUser.setPassword("shakeshacc");
        newUser.setFirstname("Cameron");
        newUser.setLastname("Coomer");
        dao.insert(newUser);
        Users retrievedUser = dao.getById(4);
        assertEquals("Coomer", retrievedUser.getLastname());

    }

    /**
     * Checks to see if you can delete from the database successfully
     */
    @Test
    void deleteSuccess() {
        Users toBeDeleted = dao.getById(1);
        dao.delete(toBeDeleted);
        Users retrievedUser = dao.getById(1);
        assertNull(retrievedUser);

    }

    /**
     * Checks to see if you can grab all users in the database
     */
    @Test
    void getAllSuccess() {
        List<Users> users = dao.getAll();
        assertEquals(3, users.size());

    }

    @Test
    void insertWithOrderSuccess() {
        Users newUser = new Users();
        newUser.setId(1);
        newUser.setUsername("Meaty");
        newUser.setPassword("shakeshacc");
        newUser.setFirstname("Cameron");
        newUser.setLastname("Coomer");

        String description = "Get to level 100";
        int taskComplete = 0;
        Tasks task = new Tasks(newUser, description, taskComplete);
        newUser.addTask(task);

        TasksDao tasksDao = new TasksDao();

        dao.insert(newUser);
        Users retrievedUser = dao.getById(4);
        assertEquals(1, retrievedUser.getTasks().size());
        assertEquals(3, tasksDao.getAll().size());

    }

}
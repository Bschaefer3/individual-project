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
 * Test Class for Users, Tests Database methods
 */
public class UsersDaoTest {

    GenericDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Resets the Database back to it's normal state
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao(Users.class);
    }


    /**
     * Checks to see if getById works
     */
    @Test
    void getByIdSuccess() {

        Users retrievedUser = (Users)dao.getById(3);
        assertEquals("Arsim", retrievedUser.getFirstname());
        assertEquals("Odza", retrievedUser.getLastname());
        assertEquals("kurumu", retrievedUser.getUsername());

    }

    /**
     * Checks to see if the database updates correctly
     */
    @Test
    void saveOrUpdateSuccess() {
        Users userToUpdate = (Users)dao.getById(3);
        String newLastName = "Bungus";
        userToUpdate.setLastname(newLastName);
        dao.saveOrUpdate(userToUpdate);
        Users retrievedUser = (Users)dao.getById(3);
        assertEquals(userToUpdate, retrievedUser);

    }

    /**
     * Checks to see if inserting into the database works
     */
    @Test
    void insertSuccess() {
        Users newUser = new Users();
        newUser.setId(1);
        newUser.setUsername("meaty");
        newUser.setPassword("password4");
        newUser.setFirstname("Cameron");
        newUser.setLastname("Coomer");
        dao.insert(newUser);

        Users retrievedUser = (Users)dao.getById(4);
        assertEquals(newUser, retrievedUser);

    }

    /**
     * Checks to see if you can delete from the database successfully
     */
    @Test
    void deleteSuccess() {
        Users toBeDeleted = (Users)dao.getById(1);
        dao.delete(toBeDeleted);
        Users retrievedUser = (Users)dao.getById(1);
        assertNull(retrievedUser);

    }

    /**
     * Checks to see if you can grab all users in the database
     */
    @Test
    void getAllSuccess() {
        List<Users> users = (List<Users>)dao.getAll();
        assertEquals(3, users.size());

    }

    @Test
    void insertWithOrderSuccess() {
        Users newUser = new Users();
        newUser.setId(1);
        newUser.setUsername("meaty");
        newUser.setPassword("password4");
        newUser.setFirstname("Cameron");
        newUser.setLastname("Coomer");

        String description = "Get to level 100";
        int taskComplete = 0;
        Tasks task = new Tasks(newUser, description, taskComplete);
        newUser.addTask(task);

        GenericDao tasksDao = new GenericDao(Tasks.class);

        dao.insert(newUser);
        Users retrievedUser = (Users)dao.getById(4);
        assertEquals(1, retrievedUser.getTasks().size());
        assertEquals(3, tasksDao.getAll().size());
        assertEquals(newUser, retrievedUser);

    }

}
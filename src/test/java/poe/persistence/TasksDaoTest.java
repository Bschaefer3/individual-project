package poe.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import poe.entity.Tasks;
import poe.entity.Users;
import poe.test.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for Tasks, Tests Database methods
 */
public class TasksDaoTest {

    GenericDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Resets the Database back to it's normal state
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao(Tasks.class);
    }


    /**
     * Checks to see if getById works
     */
    @Test
    void getByIdSuccess() {

        Tasks retrievedTask = (Tasks)dao.getById(1);
        assertEquals(1, retrievedTask.getId());
        assertEquals("Talk to Piety", retrievedTask.getTask());
        assertEquals(0, retrievedTask.getCompletion());

    }

    /**
     * Checks to see if the database updates correctly
     */
    @Test
    void saveOrUpdateSuccess() {
        int taskComplete = 1;

        Tasks taskToUpdate = (Tasks)dao.getById(2);
        taskToUpdate.setCompletion(taskComplete);
        dao.saveOrUpdate(taskToUpdate);

        Tasks retrievedTask = (Tasks)dao.getById(2);
        assertEquals(taskToUpdate, retrievedTask);

    }

    /**
     * Checks to see if inserting into the database works
     */
    @Test
    void insertSuccess() {

        GenericDao userDao = new GenericDao(Users.class);
        Users retrievedUser = (Users)userDao.getById(2);

        Tasks newTask = new Tasks();
        newTask.setId(0);
        newTask.setTask("Reach act 6");
        newTask.setCompletion(0);
        newTask.setUser(retrievedUser);
        retrievedUser.addTask(newTask);

        int id = dao.insert(newTask);

        Tasks insertedTask = (Tasks)dao.getById(id);

        assertNotEquals(0, id);
        assertEquals(newTask, insertedTask);

    }

    /**
     * Checks to see if you can delete from the database successfully
     */
    @Test
    void deleteSuccess() {
        Tasks toBeDeleted = (Tasks)dao.getById(1);
        dao.delete(toBeDeleted);
        Tasks retrievedTask = (Tasks)dao.getById(1);
        assertNull(retrievedTask);

    }

    /**
     * Checks to see if you can grab all tasks in the database
     */
    @Test
    void getAllSuccess() {
        List<Tasks> tasks = (List<Tasks>)dao.getAll();
        assertEquals(3, tasks.size());

    }

}
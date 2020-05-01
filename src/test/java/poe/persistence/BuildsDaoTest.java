package poe.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import poe.entity.Builds;
import poe.entity.Users;
import poe.test.util.Database;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BuildsDaoTest {
    GenericDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Resets the Database back to it's normal state
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao(Builds.class);
    }

    /**
     * Checks to see if getById works
     */
    @Test
    void getByIdSuccess() {

        Builds retrievedBuild = (Builds) dao.getById(1);
        String description = "My build will be a critical based cleave build! It will work like this...";
        assertEquals(1, retrievedBuild.getId());
        assertEquals(description, retrievedBuild.getBuild());

        GenericDao userDao = new GenericDao(Users.class);
        Users retrievedUser = retrievedBuild.getUser();
        Users user = (Users)userDao.getById(1);

        assertEquals(user, retrievedUser);
    }

    /**
     * Checks to see if the database updates correctly
     */
    @Test
    void saveOrUpdateSuccess() {
        Builds buildToUpdate = (Builds)dao.getById(2);
        buildToUpdate.setBuild("I'm going to do a cast-on-critical bleed build!");
        dao.saveOrUpdate(buildToUpdate);

        Builds retrievedBuild = (Builds) dao.getById(2);
        assertEquals(buildToUpdate, retrievedBuild);
    }

    /**
     * Checks to see if inserting into the database works
     */
    @Test
    void insertSuccess() {

        GenericDao userDao = new GenericDao(Users.class);
        Users retrievedUser = (Users)userDao.getById(2);

        Builds newBuild = new Builds();
        newBuild.setId(0);
        newBuild.setBuild("I'm going to use a Starforge!");
        newBuild.setUser(retrievedUser);
        newBuild.setUsername(retrievedUser.getUsername());

        retrievedUser.setBuild(newBuild);
        int id = dao.insert(newBuild);

        Builds insertedBuild = (Builds)dao.getById(id);

        assertEquals(retrievedUser.getBuild(), newBuild);
        assertNotEquals(0, id);
        assertEquals(newBuild, insertedBuild);
    }

    /**
     * Checks to see if you can delete from the database successfully
     */
    @Test
    void deleteSuccess() {
        Builds toBeDeleted = (Builds) dao.getById(1);
        dao.delete(toBeDeleted);
        Builds retrievedBuild = (Builds) dao.getById(1);
        assertNull(retrievedBuild);

    }

    /**
     * Checks to see if you can grab all tasks in the database
     */
    @Test
    void getAllSuccess() {
        List<Builds> builds = (List<Builds>)dao.getAll();
        assertEquals(2, builds.size());
    }

    /**
     * Checks to see if you can grab ranks by user id
     */
    @Test
    void getBuildsByUserIdSuccess() {
        GenericDao userDao = new GenericDao(Users.class);
        Users retrievedUser = (Users)userDao.getById(1);

        List<Builds> builds = (List<Builds>)dao.getByPropertyEqual("username", retrievedUser.getUsername());

        logger.debug(builds);

        assertEquals("thadius", retrievedUser.getUsername());
        assertEquals(1, builds.size());
    }

    /**
     * Checks to see if you can grab data based on exact input
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Builds> buildsList = dao.getByPropertyEqual("username", "thadius");
        Builds retrievedBuild = buildsList.get(0);

        GenericDao userDao = new GenericDao(Users.class);
        Users retrievedUser = (Users)userDao.getById(1);

        logger.debug(retrievedBuild);

        Builds expectedBuild = (Builds) dao.getById(1);
        String description = "My build will be a critical based cleave build! It will work like this...";

        assertEquals("thadius", retrievedUser.getUsername());
        assertEquals(description, retrievedBuild.getBuild());
        assertEquals(expectedBuild, retrievedBuild);
    }

    /**
     * Checks to see if you can grab data based on like input
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Builds> buildList = dao.getByPropertyLike("build", "know");
        Builds retrievedBuild = buildList.get(0);

        logger.debug(retrievedBuild);

        Builds expectedBuild = (Builds) dao.getById(2);
        String description = "I don't know what my build will be just yet.";

        assertEquals(description, retrievedBuild.getBuild());
        assertEquals(expectedBuild, retrievedBuild);
    }

}

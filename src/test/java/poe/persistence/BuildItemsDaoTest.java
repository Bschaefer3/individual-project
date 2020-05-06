package poe.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import poe.api.ItemData;
import poe.entity.BuildItems;
import poe.entity.Builds;
import poe.entity.Items;
import poe.entity.Users;
import poe.test.util.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for Tasks, Tests Database methods
 */
public class BuildItemsDaoTest {

    GenericDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Resets the Database back to it's normal state
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao(BuildItems.class);
    }

    /**
     * Checks to see if getById works
     */
    @Test
    void getByIdSuccess() {
        BuildItems retrievedPair = (BuildItems) dao.getById(1);

        GenericDao buildDao = new GenericDao(Builds.class);
        Builds expectedBuild = (Builds)buildDao.getById(1);
        GenericDao itemsDao = new GenericDao(Items.class);
        Items expectedItem = (Items)itemsDao.getById(1);

        assertEquals(1, retrievedPair.getId());
        assertEquals(expectedBuild, retrievedPair.getBuild());
        assertEquals(expectedItem, retrievedPair.getItem());
    }

    /**
     * Checks to see if the database updates correctly
     */
    @Test
    void saveOrUpdateSuccess() {
        GenericDao buildDao = new GenericDao(Builds.class);
        Builds newBuild = (Builds)buildDao.getById(1);

        BuildItems pairToUpdate = (BuildItems) dao.getById(2);
        pairToUpdate.setBuild(newBuild);
        dao.saveOrUpdate(pairToUpdate);

        BuildItems pair = (BuildItems) dao.getById(2);
        assertEquals(newBuild, pair.getBuild());
    }

    /**
     * Checks to see if inserting into the database works
     */
    @Test
    void insertSuccess() {

        GenericDao buildDao = new GenericDao(Builds.class);
        Builds build = (Builds)buildDao.getById(1);

        ItemsDao itemsApiDao = new ItemsDao();
        GenericDao itemsDao = new GenericDao(Items.class);
        int id = itemsApiDao.addItemToDatabase(13);
        Items newItem = (Items)itemsDao.getById(id);

        BuildItems newPair = new BuildItems();
        newPair.setId(0);
        newPair.setBuild(build);
        newPair.setItem(newItem);
        build.addPair(newItem);
        newItem.addPair(build);

        int newId = dao.insert(newPair);

        BuildItems insertedPair = (BuildItems) dao.getById(newId);

        assertNotEquals(0, newId);
        assertEquals(newPair, insertedPair);
    }

    /**
     * Checks to see if you can delete from the database successfully
     */
    @Test
    void deleteSuccess() {
        BuildItems toBeDeleted = (BuildItems) dao.getById(1);
        dao.delete(toBeDeleted);
        BuildItems retrievedPair = (BuildItems) dao.getById(1);
        assertNull(retrievedPair);
    }

    /**
     * Checks to see if you can grab all tasks in the database
     */
    @Test
    void getAllSuccess() {
        List<BuildItems> items = (List<BuildItems>)dao.getAll();
        assertEquals(2, items.size());

    }


}

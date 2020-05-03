package poe.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import poe.api.ItemData;
import poe.entity.Items;
import poe.test.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for Items, Tests Database methods
 */
public class ItemsDaoTest {

    ItemsDao itemsDao = new ItemsDao();
    GenericDao dao = new GenericDao(Items.class);
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Checks to see if getItemById works correctly
     */
    @Test
    void getItemByIdFromApiSuccess() {
        String expectedItemName = "Voidforge";
        String wrongItemName = "Flicker Strike";
        ItemData returnedItem = itemsDao.getItemById(259);
        String itemName = returnedItem.getName();
        assertNotEquals(wrongItemName, itemName);
        assertEquals(expectedItemName, itemName);
    }

    /**
     * Checks to see if getById works
     */
    @Test
    void getByIdSuccess() {

        //Items retrievedItem = (Items)dao.getById(1);
        List<Items> items = (List<Items>)dao.getAll();
        Items retrievedItem = items.get(0);

        logger.info(retrievedItem);

        assertEquals(1, retrievedItem.getId());
        ItemData returnedItemData = itemsDao.getItemById(259);
        assertEquals(returnedItemData.getName(), retrievedItem.getName());
    }

    /**
     * Checks to see if the database updates correctly
     */
    @Test
    void saveOrUpdateSuccess() {
        Items itemToUpdate = (Items) dao.getById(1);
        itemToUpdate.setImage("No Image");
        dao.saveOrUpdate(itemToUpdate);

        Items retrievedItem = (Items) dao.getById(1);
        assertEquals(itemToUpdate, retrievedItem);
    }

    /**
     * Checks to see if inserting into the database works
     */
    @Test
    void insertSuccess() {

        int id = itemsDao.addItemToDatabase(1300);
        Items insertedItem = (Items)dao.getById(id);

        Items item = (Items)dao.getById(2);

        assertNotEquals(0, id);
        assertEquals(insertedItem, item);

    }

    /**
     * Checks to see if you can delete from the database successfully
     */
    @Test
    void deleteSuccess() {
        Items toBeDeleted = (Items) dao.getById(1);
        dao.delete(toBeDeleted);
        Items retrievedItem = (Items)dao.getById(1);
        assertNull(retrievedItem);

    }

    /**
     * Checks to see if you can grab all tasks in the database
     */
    @Test
    void getAllSuccess() {
        List<Items> items = (List<Items>)dao.getAll();
        assertEquals(1, items.size());

    }

    /**
     * Checks to see if you can grab data based on exact input
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Items> itemList = dao.getByPropertyEqual("type", "twosword");
        Items retrievedItem = itemList.get(0);

        logger.debug(retrievedItem);

        Items expectedItem = (Items) dao.getById(1);

        assertEquals(expectedItem, retrievedItem);
    }

    /**
     * Checks to see if you can grab data based on like input
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Items> itemList = dao.getByPropertyLike("name", "Void");
        Items retrievedItem = itemList.get(0);

        logger.debug(retrievedItem);

        Items expectedItem = (Items) dao.getById(1);

        assertEquals(expectedItem, retrievedItem);
    }

}
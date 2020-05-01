package poe.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import poe.api.ItemData;
import poe.entity.Items;
import poe.test.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
    public void getItemByIdFromApiSuccess() {
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
    public void getByIdSuccess() {

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
    public void saveOrUpdateSuccess() {
        int taskComplete = 1;

        Items itemToUpdate = (Items) dao.getById(1);
        itemToUpdate.setName("Starforge");
        dao.saveOrUpdate(itemToUpdate);

        Items retrievedItem = (Items) dao.getById(1);
        assertEquals(itemToUpdate, retrievedItem);
    }

    /**
     * Checks to see if inserting into the database works
     */
    @Test
    public void insertSuccess() {

        int id = itemsDao.addItemToDatabase(1300);
        Items insertedItem = (Items)dao.getById(id);

        Items item = (Items)dao.getById(2);

        assertNotEquals(0, id);
        assertEquals(insertedItem, item);

    }



}
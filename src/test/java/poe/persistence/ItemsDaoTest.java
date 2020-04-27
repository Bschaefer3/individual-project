package poe.persistence;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import poe.api.Items;
import poe.test.util.Database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ItemsDaoTest {

    ItemsDao dao = new ItemsDao();

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    public void getItemByIdSuccess() throws Exception {
        String expectedItemName = "Voidforge";
        String wrongItemName = "Flicker Strike";
        Items returnedItem = dao.getItem(259);
        String itemName = returnedItem.getName();
        assertNotEquals(wrongItemName, itemName);
        assertEquals(expectedItemName, itemName);
    }

    @Test
    public void getItemByIdFailure() throws Exception {
        String wrongItemName = "Voidforge";
        Items returnedItem = dao.getItem(144);
        assertNotEquals(wrongItemName, returnedItem.getName());
    }

}
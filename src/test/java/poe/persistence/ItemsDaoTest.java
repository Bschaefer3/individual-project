package poe.persistence;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import poe.api.Items;
import poe.test.util.Database;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Items returnedItem = dao.getItem(259);
        assertEquals(expectedItemName, returnedItem.getName());
    }
}
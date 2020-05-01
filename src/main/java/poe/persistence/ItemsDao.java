package poe.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import poe.api.ItemData;
import poe.entity.Items;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

public class ItemsDao {

    private Client client;
    private String api;
    private final Logger logger = LogManager.getLogger(this.getClass());

    ItemsDao() {
        client = ClientBuilder.newClient();
        api = loadProperties();

    }

    /**
     * Loads the properties from the properties file
     */
    private String loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/api.properties"));
        } catch (IOException ioe) {
            logger.error("Database.loadProperties()...Cannot load the properties file");
        } catch (Exception e) {
            logger.error("Database.loadProperties()..." + e);
        }

        return properties.getProperty("api");
    }

    /**
     * Grabs the item data from the POE API
     * @param itemId ID of the item
     * @return All of the information about the item
     */
    public ItemData getItemById(int itemId) {
        client = ClientBuilder.newClient();
        WebTarget target =
                client.target(api + itemId);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ItemData itemData = null;

        ObjectMapper mapper = new ObjectMapper();
        try {
            itemData = mapper.readValue(response, ItemData.class);
        } catch (JsonProcessingException e) {
            logger.error(e);
        }

        return itemData;
    }

    public int addItemToDatabase(int itemId) {
        ItemData itemData = getItemById(itemId);
        GenericDao<Items> dao = new GenericDao<>(Items.class);

        String name = itemData.getName();
        String icon = itemData.getIcon();
        String category = itemData.getCategory();
        String group = itemData.getGroup();

        Items item = new Items
                (itemId, name, icon, category, group);

        return dao.insert(item);
    }



}
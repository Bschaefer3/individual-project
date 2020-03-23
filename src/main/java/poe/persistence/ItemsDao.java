package poe.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import poe.api.Item;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ItemsDao {

    Client client;
    private final Logger logger = LogManager.getLogger(this.getClass());

    ItemsDao() {
        client = ClientBuilder.newClient();
    }

    public Item getItem(int itemId) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://api.poe.watch/item?id=" + itemId);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        Item item = new Item();

        ObjectMapper mapper = new ObjectMapper();
        try {
            item = mapper.readValue(response, Item.class);
        } catch (JsonProcessingException e) {
            logger.error(e);
        }

        return item;
    }

}
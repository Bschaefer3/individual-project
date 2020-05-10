package poe.persistence;

import poe.entity.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static java.lang.Integer.parseInt;

public class InfoGrabber {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public Users grabUser(String username) {
        GenericDao<Users> userDao = new GenericDao<>(Users.class);
        List<Users> users = userDao.getByPropertyEqual("username", username);
        return users.get(0);
    }

    public Builds grabBuild(String username) {
        GenericDao<Builds> buildDao = new GenericDao<>(Builds.class);
        List<Builds> builds = buildDao.getByPropertyEqual("username", username);
        if (builds.isEmpty()) {
            Users user = grabUser(username);
            Builds build = new Builds();
            build.setId(0);
            build.setUser(user);
            build.setUsername(username);
            build.setBuild("");
            buildDao.insert(build);
            return build;
        } else {
            return builds.get(0);
        }
    }

    public Ranks grabRank(Users user) {
        Set<Ranks> ranks = user.getRanks();
        return ranks.iterator().next();
    }

    public List<Items> grabItemsByName(String searchTerm) {
        GenericDao<Items> itemsDao = new GenericDao<>(Items.class);
        return itemsDao.getByPropertyLike("name", searchTerm);
    }

    public List<Items> grabAllItems() {
        GenericDao<Items> itemsDao = new GenericDao<>(Items.class);
        return itemsDao.getAll();
    }

    public List<Items> grabItemsByPair(Builds build) {
        List<BuildItems> pairs = build.getPairs();
        List<Items> itemList = new ArrayList<>();

        Iterator<BuildItems> itr = pairs.iterator();
        while (itr.hasNext()) {
            BuildItems pair = itr.next();
            logger.info(pair.getBuild().getId());
            logger.info(build.getId());
            if (pair.getBuild().getId() != build.getId()) {
                itr.remove();
            }
        }

        logger.info(pairs.size());

        for (int i = 1; i < pairs.size(); i++) {
            BuildItems pair = pairs.get(i);
            Items item = pair.getItem();
            itemList.add(item);
            logger.info("Item Grabbed (" + i + "): " + item.getName());
        }

        return itemList;
    }

    public Items grabItemToPair(String itemName, Builds build) {
        GenericDao<Items> itemsDao = new GenericDao<>(Items.class);
        List<Items> items = itemsDao.getByPropertyEqual("name", itemName);
        Items item = items.get(0);

        GenericDao<BuildItems> pairDao = new GenericDao<>(BuildItems.class);

        BuildItems pair = new BuildItems(build, item);
        pairDao.insert(pair);

        return item;
    }

    public void removePair(String id) {
        GenericDao<BuildItems> pairsDao = new GenericDao<>(BuildItems.class);
        BuildItems pair = pairsDao.getById(parseInt(id));
        pairsDao.delete(pair);
    }

    public Items addItem(String id) {
        GenericDao<Items> dao = new GenericDao<>(Items.class);
        List<Items> items = dao.getByPropertyEqual("itemid", id);
        if (items.isEmpty()) {
            ItemsDao itemsDao = new ItemsDao();
            int itemId = itemsDao.addItemToDatabase(parseInt(id));
            return (Items)dao.getById(itemId);
        } else {
            return items.get(0);
        }
    }

    public void removeItem(String id) {
        GenericDao<Items> dao = new GenericDao<>(Items.class);
        Items itemToBeDeleted = dao.getById(parseInt(id));
        dao.delete(itemToBeDeleted);
    }
}

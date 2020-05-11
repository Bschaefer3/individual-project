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

    /**
     * Grabs the user from the database by their username
     * @param username username
     * @return user
     */
    public Users grabUserByUsername(String username) {
        GenericDao<Users> userDao = new GenericDao<>(Users.class);
        List<Users> users = userDao.getByPropertyEqual("username", username);
        return users.get(0);
    }

    /**
     * Grabs the user from the database by their id
     * @param id user id
     * @return user
     */
    public Users grabUserById(int id) {
        GenericDao<Users> userDao = new GenericDao<>(Users.class);
        return userDao.getById(id);
    }

    /**
     * Grabs all users from the database
     * @return user list
     */
    public List<Users> grabAllUsers() {
        GenericDao<Users> userDao = new GenericDao<>(Users.class);
        return userDao.getAll();
    }

    public List<Users> grabUsersByTerm(String searchTerm) {
        GenericDao<Users> userDao = new GenericDao<>(Users.class);
        return userDao.getByPropertyLike("username", searchTerm);
    }

    /**
     * Grabs the user's build idea from the database
     * @param username username
     * @return build
     */
    public Builds grabBuild(String username) {
        GenericDao<Builds> buildDao = new GenericDao<>(Builds.class);
        List<Builds> builds = buildDao.getByPropertyEqual("username", username);
        if (builds.isEmpty()) {
            Users user = grabUserByUsername(username);
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

    /**
     * Grabs the user's rank from the database
     * @param user user
     * @return rank
     */
    public Ranks grabRank(Users user) {
        Set<Ranks> ranks = user.getRanks();
        return ranks.iterator().next();
    }

    /**
     * Grabs the items from the database by a like search term
     * @param searchTerm search term
     * @return items list
     */
    public List<Items> grabItemsByName(String searchTerm) {
        GenericDao<Items> itemsDao = new GenericDao<>(Items.class);
        return itemsDao.getByPropertyLike("name", searchTerm);
    }

    /**
     * Grabs all items from the database
     * @return list of all items
     */
    public List<Items> grabAllItems() {
        GenericDao<Items> itemsDao = new GenericDao<>(Items.class);
        return itemsDao.getAll();
    }

    /**
     * Grabs items from the user's build list
     * @param build build
     * @return item list
     */
    public List<Items> grabItemsByPair(Builds build) {
        GenericDao<BuildItems> pairDao = new GenericDao<>(BuildItems.class);
        List<BuildItems> pairs = pairDao.getAll();
        List<Items> itemList = new ArrayList<>();

        Iterator<BuildItems> itr = pairs.iterator();
        while (itr.hasNext()) {
            BuildItems pair = itr.next();
            if (pair.getBuild().getId() != build.getId()) {
                itr.remove();
            }
        }

        for (int i = 0; i < pairs.size(); i++) {
            BuildItems pair = pairs.get(i);
            Items item = pair.getItem();
            itemList.add(item);
            logger.info("Item Grabbed (" + i + "): " + item.getName());
        }

        return itemList;
    }

    /**
     * Creates a pair from the name of an item and the user's build, then returns the item object
     * @param itemName name of the item
     * @param build build
     * @return item
     */
    public Items grabItemToPair(String itemName, Builds build) {
        GenericDao<Items> itemsDao = new GenericDao<>(Items.class);
        List<Items> items = itemsDao.getByPropertyEqual("name", itemName);
        Items item = items.get(0);

        GenericDao<BuildItems> pairDao = new GenericDao<>(BuildItems.class);

        BuildItems pair = new BuildItems(build, item);
        pairDao.insert(pair);

        return item;
    }

    /**
     * Deletes a pair from the database
     * @param id pair id
     */
    public void removePair(String id) {
        GenericDao<BuildItems> pairsDao = new GenericDao<>(BuildItems.class);
        BuildItems pair = pairsDao.getById(parseInt(id));
        pairsDao.delete(pair);
    }

    /**
     * Adds an item to the database
     * @param id item id
     * @return item object
     */
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

    /**
     * Deletes an item from the database
     * @param id item id
     */
    public void removeItem(String id) {
        GenericDao<Items> dao = new GenericDao<>(Items.class);
        Items itemToBeDeleted = dao.getById(parseInt(id));
        dao.delete(itemToBeDeleted);
    }

    /**
     * Adds a new user to the database
     * @param user user
     * @return user id
     */
    public int addUser(Users user) {
        GenericDao<Users> dao = new GenericDao<>(Users.class);
        return dao.insert(user);
    }

    /**
     * Adds a rank to the database
     * @param rank rank
     */
    public void addRank(Ranks rank) {
        GenericDao<Ranks> dao = new GenericDao<>(Ranks.class);
        dao.insert(rank);
    }

    /**
     * Grabs all user's except for the user that's logged in
     * @param userList list of users
     * @param user current user
     * @return updated list of users
     */
    public List<Users> removeMeFromList(List<Users> userList, Users user) {
        Iterator<Users> itr = userList.iterator();
        while (itr.hasNext()) {
            Users current = itr.next();
            if (current.equals(user)) {
                itr.remove();
            }
        }

        return userList;

    }

}

package poe.persistence;

import poe.controller.Build;
import poe.entity.BuildItems;
import poe.entity.Builds;
import poe.entity.Items;
import poe.entity.Users;

import java.util.List;

import static java.lang.Integer.parseInt;

public class InfoGrabber {

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

    public List<Items> grabItemsByName(String searchTerm) {
        GenericDao<Items> itemsDao = new GenericDao<>(Items.class);
        return itemsDao.getByPropertyLike("name", searchTerm);
    }

    public List<Items> grabAllItems() {
        GenericDao<Items> itemsDao = new GenericDao<>(Items.class);
        return itemsDao.getAll();
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
}

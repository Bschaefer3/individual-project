package poe.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import poe.entity.Ranks;
import poe.entity.Tasks;
import poe.entity.Users;
import poe.test.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for Ranks, Tests Database methods
 */
public class RanksDaoTest {

    GenericDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Resets the Database back to it's normal state
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao(Ranks.class);
    }

    /**
     * Checks to see if getById works
     */
    @Test
    void getByIdSuccess() {

        Ranks retrievedRank = (Ranks)dao.getById(1);
        assertEquals(1, retrievedRank.getId());
        assertEquals("admin", retrievedRank.getTitle());

        GenericDao userDao = new GenericDao(Users.class);
        Users retrievedUser = retrievedRank.getUser();
        Users user = (Users)userDao.getById(2);

        assertEquals(user, retrievedUser);
    }

    /**
     * Checks to see if the database updates correctly
     */
    @Test
    void saveOrUpdateSuccess() {
        Ranks rankToUpdate = (Ranks)dao.getById(1);
        rankToUpdate.setTitle("user");
        dao.saveOrUpdate(rankToUpdate);

        Ranks retrievedRank = (Ranks)dao.getById(1);
        assertEquals(rankToUpdate, retrievedRank);
    }

    /**
     * Checks to see if inserting into the database works
     */
    @Test
    void insertSuccess() {

        GenericDao userDao = new GenericDao(Users.class);
        Users retrievedUser = (Users)userDao.getById(2);

        Ranks newRank = new Ranks();
        newRank.setId(0);
        newRank.setTitle("user");
        newRank.setUser(retrievedUser);
        newRank.setUsername(retrievedUser.getUsername());
        retrievedUser.addRank(newRank);

        int id = dao.insert(newRank);

        Ranks insertedRank = (Ranks)dao.getById(id);

        assertNotEquals(0, id);
        assertEquals(newRank, insertedRank);
    }

    /**
     * Checks to see if you can delete from the database successfully
     */
    @Test
    void deleteSuccess() {
        Ranks toBeDeleted = (Ranks)dao.getById(1);
        dao.delete(toBeDeleted);
        Ranks retrievedRank = (Ranks)dao.getById(1);
        assertNull(retrievedRank);

    }

    /**
     * Checks to see if you can grab all tasks in the database
     */
    @Test
    void getAllSuccess() {
        List<Ranks> ranks = (List<Ranks>)dao.getAll();
        assertEquals(1, ranks.size());
    }

    /**
     * Checks to see if you can grab ranks by user id
     */
    @Test
    void getRanksByUserIdSuccess() {
        GenericDao userDao = new GenericDao(Users.class);
        Users retrievedUser = (Users)userDao.getById(2);

        List<Ranks> ranks = (List<Ranks>)dao.getByPropertyEqual("username", retrievedUser.getUsername());

        logger.debug(ranks);

        List<Ranks> allRanks = (List<Ranks>)dao.getAll();

        assertEquals("biggums", retrievedUser.getUsername());
        assertEquals(1, ranks.size());
        assertEquals(allRanks, ranks);
    }

    /**
     * Checks to see if you can grab data based on exact input
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Ranks> rankList = dao.getByPropertyEqual("username", "biggums");
        Ranks retrievedRank = rankList.get(0);

        logger.debug(retrievedRank);

        Ranks expectedRank = (Ranks) dao.getById(1);

        assertEquals("admin", retrievedRank.getTitle());
        assertEquals(expectedRank, retrievedRank);
    }

    /**
     * Checks to see if you can grab data based on like input
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Ranks> rankList = dao.getByPropertyLike("username", "big");
        Ranks retrievedRank = rankList.get(0);

        logger.debug(retrievedRank);

        Ranks expectedRank = (Ranks) dao.getById(1);

        assertEquals("admin", retrievedRank.getTitle());
        assertEquals(expectedRank, retrievedRank);
    }

}
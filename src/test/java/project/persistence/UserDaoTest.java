package project.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import project.entity.User;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

    UserDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());


    @BeforeEach
    void setUp() {

        project.test.util.Database database = project.test.util.Database.getInstance();
        database.runSQL("cleandb1.sql");
        database.runSQL("cleandb2.sql");
        database.runSQL("cleandb3.sql");
        dao = new UserDao();
    }


    @Test
    void getByIdSuccess() {

        User retrievedUser = dao.getById(3);
        assertEquals("Arsim", retrievedUser.getFirstname());
        assertEquals("Odza", retrievedUser.getLastname());
        assertEquals("Kurumu", retrievedUser.getUsername());

    }

    @Test
    void saveOrUpdateSuccess() {
        User userToUpdate = dao.getById(3);
        String newLastName = "Bungus";
        userToUpdate.setLastname(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getById(3);
        assertEquals(newLastName, retrievedUser.getLastname());

    }

    @Test
    void insertSuccess() {
        User newUser = new User();
        newUser.setId(1);
        newUser.setUsername("Meaty");
        newUser.setPassword("shakeshacc");
        newUser.setFirstname("Cameron");
        newUser.setLastname("Coomer");
        dao.insert(newUser);
        User retrievedUser = dao.getById(4);
        assertEquals("Coomer", retrievedUser.getLastname());

    }

    @Test
    void deleteSuccess() {
        User toBeDeleted = dao.getById(1);
        dao.delete(toBeDeleted);
        User newUser = new User();
        newUser.setId(1);
        newUser.setFirstname("Jake");
        dao.insert(newUser);
        User retrievedUser = dao.getById(1);
        assertEquals("Jake", retrievedUser.getFirstname());

    }

    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(3, users.size());

    }

}
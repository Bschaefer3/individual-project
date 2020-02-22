package poe.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import poe.entity.Tasks;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class TasksDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get task by id
     */
    public Tasks getById(int id) {
        Session session = sessionFactory.openSession();
        Tasks task = session.get( Tasks.class, id );
        session.close();
        return task;
    }

    /**
     * update task
     * @param task  Task to be inserted or updated
     */
    public void saveOrUpdate(Tasks task) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(task);
        transaction.commit();
        session.close();
    }

    /**
     * update task
     * @param task  Task to be inserted or updated
     */
    public int insert(Tasks task) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(task);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a task
     * @param task Task to be deleted
     */
    public void delete(Tasks task) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(task);
        transaction.commit();
        session.close();
    }


    /** Return a list of all tasks
     *
     * @return All tasks
     */
    public List<Tasks> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tasks> query = builder.createQuery( Tasks.class );
        Root<Tasks> root = query.from( Tasks.class );
        List<Tasks> tasks = session.createQuery( query ).getResultList();

        logger.debug("The list of tasks " + tasks);
        session.close();

        return tasks;
    }

    /**
     * Get task by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<Tasks> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for task with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tasks> query = builder.createQuery( Tasks.class );
        Root<Tasks> root = query.from( Tasks.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Tasks> tasks = session.createQuery( query ).getResultList();

        session.close();
        return tasks;
    }

    /**
     * Get task by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<Tasks> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for task with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tasks> query = builder.createQuery( Tasks.class );
        Root<Tasks> root = query.from( Tasks.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Tasks> tasks = session.createQuery( query ).getResultList();
        session.close();
        return tasks;
    }

}
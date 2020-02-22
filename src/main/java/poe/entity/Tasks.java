package poe.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The Tasks Table, Holds all of the user tasks
 */
@Entity(name = "Tasks")
@Table(name = "tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;
    @ManyToOne
    private Users user;
    private String task;
    private int completion;

    /**
     * Empty Constructor
     */
    public Tasks() {
    }

    /**
     * Instantiates a new Task
     *
     * @param user the user that created the task
     * @param task the task description
     * @param completion if the task is completed
     */
    public Tasks(Users user, String task, int completion) {
        this.user = user;
        this.task = task;
        this.completion = completion;
    }

    /**
     * Returns the Task ID
     * @return          the task id
     */
    public int getId() { return id; }

    /**
     * Sets the Task ID
     * @param id         the task id
     */
    public void setId(int id) { this.id = id; }

    /**
     * returns the task description
     * @return task      the task description
     */
    public String getTask() { return task; }

    /**
     * Sets the task description
     * @param task       the task description
     */
    public void setTask(String task) { this.task = task; }

    /**
     * Returns the completion check
     * @return completion   completion mark
     */
    public int getCompletion() { return completion; }

    /**
     * Sets if the task is completed
     * @param completion    completion mark
     */
    public void setCompletion(int completion) { this.completion = completion; }

    /**
     * Returns the task's owner
     * @return user         the task owner
     */
    public Users getUser() { return user; }

    /**
     * Sets the user for the current task
     * @param user          the task owner
     */
    public void setUser(Users user) { this.user = user; }

    /**
     * ToString method, creates an output with all of the variables
     * @return String containing all variables
     */
    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", user=" + user +
                ", task='" + task + '\'' +
                ", completion=" + completion +
                '}';
    }

}
package poe.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A class to represent the user in my POETracker application
 *
 * @author Ben Schaefer
 */
@Entity(name = "Users")
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Tasks> tasks = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Ranks> ranks = new HashSet<>();
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Builds build;

    /**
     * Instantiates a new User object
     */
    public Users() {
    }

    /**
     * Instantiates a new User object
     *
     * @param id        the unique id
     * @param username  the username
     * @param password  the password
     * @param firstname the user's first name
     * @param lastname  the user's last name
     */
    public Users(int id, String username, String password, String firstname, String lastname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * returns the unique id
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * sets the unique id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * returns the username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * sets the username
     *
     * @param username      the user's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * returns the password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets the password
     *
     * @param password      the user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * returns the first name of the user
     *
     * @return firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * sets the first name of the user
     *
     * @param firstname     the user's firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * returns the last name of the user
     *
     * @return lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * sets the last name of the user
     *
     * @param lastname      the user's lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * returns the tasks list
     *
     * @return tasks
     */
    public Set<Tasks> getTasks() {
        return tasks;
    }

    /**
     * sets the tasks list
     *
     * @param tasks     the user's list of tasks
     */
    public void setTasks(Set<Tasks> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the user's task list
     * @param task user task
     */
    public void addTask(Tasks task) {
        tasks.add(task);
        task.setUser(this);
    }

    /**
     * Removes a task from the user's task list
     * @param task user task
     */
    public void removeTask(Tasks task) {
        tasks.remove(task);
        task.setUser(null);
    }

    /**
     * Returns the user's ranks
     * @return ranks list
     */
    public Set<Ranks> getRanks() {
        return ranks;
    }

    /**
     * Sets the user's ranks
     * @param ranks rank list
     */
    public void setRanks(Set<Ranks> ranks) {
        this.ranks = ranks;
    }

    /**
     * Adds a task to the user's rank list
     * @param rank user task
     */
    public void addRank(Ranks rank) {
        ranks.add(rank);
        rank.setUser(this);
    }

    /**
     * Removes a task from the user's rank list
     * @param rank user rank
     */
    public void removeRank(Ranks rank) {
        ranks.remove(rank);
        rank.setUser(null);
    }

    /**
     * Returns the user's build
     * @return build object
     */
    public Builds getBuild() { return this.build; }

    /**
     * Sets the user's build
     * @param build build object
     */
    public void setBuild(Builds build) { this.build = build; }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                username.equals(users.username) &&
                password.equals(users.password) &&
                firstname.equals(users.firstname) &&
                lastname.equals(users.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstname, lastname);
    }
}

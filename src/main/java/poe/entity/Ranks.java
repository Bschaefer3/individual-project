package poe.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * Ranks Table, stores all of the user's ranks
 *
 * @author Ben Schaefer
 */
@Entity(name = "Ranks")
@Table(name = "ranks")
public class Ranks {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;
    private String title;
    private String username;
    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "ranks_users_id_fk")
    )
    private Users user;

    /**
     * Instantiates a new Ranks object
     */
    public Ranks() {
    }

    /**
     * Instantiates a new Ranks Object
     *
     * @param title Rank Name
     * @param username User's Username
     * @param user User ID
     */
    public Ranks(String title, String username, Users user) {
        this.title = title;
        this.username = username;
        this.user = user;
    }

    /**
     * Returns the Rank ID
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the Rank ID
     * @param id rank id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the rank title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the rank title
     * @param title rank title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * returns the user's username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * sets the user's username
     * @param username user's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * returns the user's id
     * @return user id
     */
    public Users getUser() {
        return user;
    }

    /**
     * sets the user's id
     * @param user user's id
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * ToString method, creates an output with all of the variables
     * @return String containing all variables
     */
    @Override
    public String toString() {
        return "Ranks{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranks ranks = (Ranks) o;
        return id == ranks.id &&
                title.equals(ranks.title) &&
                username.equals(ranks.username) &&
                user.equals(ranks.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, username, user);
    }
}
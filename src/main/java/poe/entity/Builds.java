package poe.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * Buiilds Table, stores the user's build idea
 *
 * @author Ben Schaefer
 */
@Entity(name = "Builds")
@Table(name = "builds")
public class Builds {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;
    @OneToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "builds_users_id_fk")
    )
    private Users user;
    private String username;
    private String build;

    /**
     * Instantiates a new Build object
     */
    public Builds() {
    }

    /**
     * Instantiates a new Build object
     *
     * @param user User Object
     * @param username User's Name
     * @param build Build Description
     */
    public Builds(Users user, String username, String build) {
        this.user = user;
        this.username = username;
        this.build = build;
    }

    /**
     * Gets the build ID
     * @return id
     */
    public int getId() { return id; }

    /**
     * Sets the build ID
     * @param id unique build id
     */
    public void setId(int id) { this.id = id; }

    /**
     * Gets the build's User
     * @return user
     */
    public Users getUser() { return user; }

    /**
     * Sets the build's user
     * @param user build's user
     */
    public void setUser(Users user) { this.user = user; }

    /**
     * Gets the build's user's username
     * @return username
     */
    public String getUsername() { return username; }

    /**
     * Sets the build's username
     * @param username user's username
     */
    public void setUsername(String username) { this.username = username; }

    /**
     * Gets the build description
     * @return build description
     */
    public String getBuild() { return build; }

    /**
     * Sets the build description
     * @param build build description
     */
    public void setBuild(String build) { this.build = build; }

    @Override
    public String toString() {
        return "Builds{" +
                "id=" + id +
                ", user=" + user +
                ", username='" + username + '\'' +
                ", build='" + build + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Builds builds = (Builds) o;
        return id == builds.id &&
                user.equals(builds.user) &&
                Objects.equals(username, builds.username) &&
                Objects.equals(build, builds.build);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, username, build);
    }
}
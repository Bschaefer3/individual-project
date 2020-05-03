package poe.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

/**
 * Builds Items Table, stores the build / item pairs for the user
 *
 * @author Ben Schaefer
 */

@Entity(name = "BuildItems")
@Table(name = "items_builds_join")
public class BuildItems {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @ManyToOne
    @JoinColumn(name = "buildid",
            foreignKey = @ForeignKey(name = "join_builds_id_fk")
    )
    private Builds build;

    @ManyToOne
    @JoinColumn(name = "itemid",
            foreignKey = @ForeignKey(name = "join_items_id_fk")
    )
    private Items item;

    /**
     * Instantiates a new Build + Item object
     */
    public BuildItems() {
    }

    /**
     * Instantiates a new Build + Item object
     *
     * @param build build object
     * @param item item object
     */
    public BuildItems(Builds build, Items item) {
        this.build = build;
        this.item = item;
    }

    /**
     * Returns the BuildItem pair unique ID
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the BuildItem pair unique ID
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the build object
     * @return build
     */
    public Builds getBuild() {
        return build;
    }

    /**
     * Sets the build object
     * @param build build
     */
    public void setBuild(Builds build) {
        this.build = build;
    }

    /**
     * Returns the item
     * @return item
     */
    public Items getItem() {
        return item;
    }

    /**
     * Sets the item
     * @param item item
     */
    public void setItem(Items item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "BuildItems{" +
                "id=" + id +
                ", build=" + build +
                ", item=" + item +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildItems that = (BuildItems) o;
        return id == that.id &&
                Objects.equals(build, that.build) &&
                Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, build, item);
    }
}

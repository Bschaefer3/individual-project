package poe.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

/**
 * Ranks Table, stores all of the user's ranks
 *
 * @author Ben Schaefer
 */
@Entity(name = "Items")
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;
    @Column(name = "item_id")
    private int itemid;
    private String name;
    private String image;
    private String category;
    private String group;

    /**
     * Instantiates a new Ranks object
     */
    public Items() {
    }

    /**
     * Instantiates a new Ranks object
     */
    public Items(int itemid, String name, String image, String category, String group) {
        this.itemid = itemid;
        this.name = name;
        this.image = image;
        this.category = category;
        this.group = group;
    }

    /**
     * Returns the unique database Id of the item
     * @return database Id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique database Id of the item
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the item id
     * @return item id
     */
    public int getItemid() {
        return itemid;
    }

    /**
     * Sets the item id
     * @param itemid in-game id of the item
     */
    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    /**
     * Returns the name of the item
     * @return item name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the item
     * @param name item name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the image link of the item
     * @return image link
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the image link of the item
     * @param image image link
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Returns the item category
     * @return item category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the item category
     * @param category item category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Returns the item group
     * @return item group
     */
    public String getGroup() {
        return group;
    }

    /**
     * Sets the item group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", itemid=" + itemid +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", category='" + category + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return id == items.id &&
                itemid == items.itemid &&
                Objects.equals(name, items.name) &&
                Objects.equals(image, items.image) &&
                Objects.equals(category, items.category) &&
                Objects.equals(group, items.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemid, name, image, category, group);
    }
}

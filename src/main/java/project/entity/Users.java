package project.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * A class to represent the user in my POETracker application
 *
 * @author Ben Schaefer
 */
@Entity(name = "Users")
@Table(name = "users")
public class Users {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
  @GenericGenerator(name = "native",strategy = "native")
  private int id;
  private String username;
  private String password;
  private String firstname;
  private String lastname;

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
   * @return id
   */
  public long getId() {
    return id;
  }

  /**
   * sets the unique id
   * @param id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * returns the username
   * @return username
   */
  public String getUsername() {
    return username;
  }

  /**
   * sets the username
   * @param username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * returns the password
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * sets the password
   * @param password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * returns the first name of the user
   * @return firstname
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * sets the first name of the user
   * @param firstname
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   * returns the last name of the user
   * @return lastname
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * sets the last name of the user
   * @param lastname
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

}

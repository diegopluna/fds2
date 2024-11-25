package cesar.school.raycharge.authentication.domain.user;

import org.jmolecules.ddd.types.AggregateRoot;

public class User implements Cloneable, AggregateRoot<User, UserId> {
  private final UserId id;
  private String login;
  private String password;
  private UserRole role;

  public User(String login, String password, UserRole role) {
    this.id = null;
    this.login = login;
    this.password = password;
    this.role = role;
  }

  public User(UserId id, String login, String password, UserRole role) {
    this.id = id;
    this.login = login;
    this.password = password;
    this.role = role;
  }

  @Override
  public UserId getId() {
    return id;
  }

  @Override
  public User clone() {
    try {
      return (User) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String toString() {
    return login;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserRole getRole() {
    return role;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }
}

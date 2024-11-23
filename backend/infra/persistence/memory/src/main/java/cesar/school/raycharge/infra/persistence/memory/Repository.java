package cesar.school.raycharge.infra.persistence.memory;

import cesar.school.raycharge.authentication.domain.user.User;
import cesar.school.raycharge.authentication.domain.user.UserId;
import cesar.school.raycharge.authentication.domain.user.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Repository implements UserRepository {
  /*-----------------------------------------------------------------------*/
  /* UserRepository                                                        */
  private Map<UserId, User> users = new HashMap<>();

  @Override
  public User save(User user) {
    Objects.requireNonNull(user, "user must not be null");
    if (users.containsKey(user.getId())) {
      return null;
    }
    for (User u : users.values()) {
      if (u.getLogin().equals(user.getLogin())) {
        return null;
      }
    }
    users.put(user.getId(), user);
    return user;
  }

  @Override
  public User findByLogin(String login) {
    Objects.requireNonNull(login, "login must not be null");
    for (User u : users.values()) {
      if (u.getLogin().equals(login)) {
        return u;
      }
    }
    return null;
  }

  /*-----------------------------------------------------------------------*/
}

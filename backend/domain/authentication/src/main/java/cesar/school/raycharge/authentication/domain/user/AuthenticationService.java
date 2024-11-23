package cesar.school.raycharge.authentication.domain.user;

import cesar.school.raycharge.authentication.domain.security.PasswordHasher;
import org.jmolecules.ddd.annotation.Service;

import static org.apache.commons.lang3.Validate.notNull;

@Service
public class AuthenticationService {
  private final UserRepository userRepository;
  private final PasswordHasher passwordHasher;

  public AuthenticationService(UserRepository userRepository, PasswordHasher passwordHasher) {
    this.passwordHasher = passwordHasher;
    this.userRepository = userRepository;
  }

  public User createUser(User user) {
    notNull(user, "User cannot be null");

    String hashedPassword = passwordHasher.hashPassword(user.getPassword());
    user.setPassword(hashedPassword);
    if (user.getId() == null) {
      UserId newId = new UserId();
      User insertedUser = new User(newId, user.getLogin(), user.getPassword(), user.getRole());
      return userRepository.save(insertedUser);
    }
    return userRepository.save(user);
  }

  public boolean login(String login, String password) {
    notNull(login, "Login cannot be null");
    notNull(password, "Password cannot be null");

    User user = userRepository.findByLogin(login);
    if (user == null) {
      return false;
    }

    return passwordHasher.verifyPassword(password, user.getPassword());
  }
}

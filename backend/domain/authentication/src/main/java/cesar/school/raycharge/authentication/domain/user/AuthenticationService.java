package cesar.school.raycharge.authentication.domain.user;

import cesar.school.raycharge.authentication.domain.security.PasswordHasher;

import static org.apache.commons.lang3.Validate.notNull;

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
}

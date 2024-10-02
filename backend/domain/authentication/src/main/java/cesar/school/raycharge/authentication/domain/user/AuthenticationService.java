package cesar.school.raycharge.authentication.domain.user;

import static org.apache.commons.lang3.Validate.notNull;

public class AuthenticationService {
  private final UserRepository userRepository;

  public AuthenticationService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(User user) {
    notNull(user, "User cannot be null");
    if (user.getId() == null) {
      UserId newId = new UserId();
      User insertedUser = new User(newId, user.getLogin(), user.getPassword(), user.getRole());
      return userRepository.save(insertedUser);
    }
    return userRepository.save(user);
  }
}

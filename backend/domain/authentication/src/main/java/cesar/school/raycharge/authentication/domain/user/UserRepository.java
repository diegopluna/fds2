package cesar.school.raycharge.authentication.domain.user;

public interface UserRepository {
  User save(User user);
  User findByLogin(String login);
  User findById(UserId id);
}

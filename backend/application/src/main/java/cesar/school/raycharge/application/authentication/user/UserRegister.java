package cesar.school.raycharge.application.authentication.user;

import cesar.school.raycharge.authentication.domain.security.PasswordHasher;
import cesar.school.raycharge.authentication.domain.user.User;
import cesar.school.raycharge.authentication.domain.user.UserAlreadyExists;
import cesar.school.raycharge.authentication.domain.user.UserRepository;
import cesar.school.raycharge.authentication.domain.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegister {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordHasher passwordHasher;

    public void register(final UserRegisterRequest userRegisterRequest) {
        final User user = userRepository.findByLogin(userRegisterRequest.getLogin());
        ensureUserDoesNotExist(user, userRegisterRequest.getLogin());
        final UserRole role = UserRole.valueOf(userRegisterRequest.getRole());
        User newUser = new User(userRegisterRequest.getLogin(), userRegisterRequest.getPassword(), role);
        newUser.setPassword(passwordHasher.hashPassword(userRegisterRequest.getPassword()));
        userRepository.save(newUser);
    }

    private void ensureUserDoesNotExist(final User user, final String login) {
        if (user != null) {
            throw new UserAlreadyExists(login);
        }
    }
}

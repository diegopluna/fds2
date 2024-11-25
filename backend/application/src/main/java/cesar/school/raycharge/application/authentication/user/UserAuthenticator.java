package cesar.school.raycharge.application.authentication.user;

import cesar.school.raycharge.authentication.domain.security.PasswordHasher;
import cesar.school.raycharge.authentication.domain.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticator {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthTokenCreator authTokenCreator;

    @Autowired
    private PasswordHasher passwordHasher;

    public Token authenticate(UserAuthRequest userAuthRequest) {
        final User user = userRepository.findByLogin(userAuthRequest.getLogin());
        ensureUserExist(user, userAuthRequest.getLogin());
        ensureCredentialsAreValid(user, userAuthRequest.getPassword());
        return authTokenCreator.createToken(user.getLogin());
    }

    private void ensureUserExist(final User user, final String login) {
        if (user == null) {
            throw new InvalidAuthLogin(login);
        }
    }

    private void ensureCredentialsAreValid(final User user, final String password) {
        if (!passwordHasher.verifyPassword(password, user.getPassword())) {
            throw new InvalidAuthPassword(user.getLogin());
        }
    }

}

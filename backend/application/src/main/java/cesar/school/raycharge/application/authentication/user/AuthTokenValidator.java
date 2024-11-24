package cesar.school.raycharge.application.authentication.user;

import cesar.school.raycharge.authentication.domain.user.AuthenticationTokenProvider;
import cesar.school.raycharge.authentication.domain.user.Token;
import cesar.school.raycharge.authentication.domain.user.User;
import cesar.school.raycharge.authentication.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenValidator {
    @Autowired
    AuthenticationTokenProvider authenticationTokenProvider;
    @Autowired
    UserRepository userRepository;

    public User validateToken(final String token) {
        String login = authenticationTokenProvider.validateToken(new Token(token));
        return userRepository.findByLogin(login);
    }
}

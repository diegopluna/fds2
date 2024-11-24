package cesar.school.raycharge.application.authentication.user;

import cesar.school.raycharge.authentication.domain.user.AuthenticationTokenProvider;
import cesar.school.raycharge.authentication.domain.user.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenCreator {
    @Autowired
    AuthenticationTokenProvider authenticationTokenProvider;

    public Token createToken(final String login) {
        return authenticationTokenProvider.createToken(login);
    }
}

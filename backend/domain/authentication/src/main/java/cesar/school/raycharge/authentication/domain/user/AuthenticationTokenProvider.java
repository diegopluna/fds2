package cesar.school.raycharge.authentication.domain.user;

public interface AuthenticationTokenProvider {
    Token createToken(final String login);
    String validateToken(final Token token);
}

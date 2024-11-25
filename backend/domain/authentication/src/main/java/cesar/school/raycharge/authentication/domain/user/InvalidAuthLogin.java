package cesar.school.raycharge.authentication.domain.user;

public final class InvalidAuthLogin extends RuntimeException {
    public InvalidAuthLogin(final String login) {
        super(String.format("The user <%s> does not exist", login));
    }
}

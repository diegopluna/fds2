package cesar.school.raycharge.authentication.domain.user;

public final class InvalidAuthPassword extends RuntimeException {
    public InvalidAuthPassword(final String login) {
        super(String.format("The credentials for user <%s> is invalid", login));
    }
}

package cesar.school.raycharge.authentication.domain.user;

public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists(final String login) {

        super(String.format("The user <%s> already exists", login));
    }
}

package cesar.school.raycharge.application.authentication.user;

public class UserAuthRequest {
    public String login;
    public String password;

    public UserAuthRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

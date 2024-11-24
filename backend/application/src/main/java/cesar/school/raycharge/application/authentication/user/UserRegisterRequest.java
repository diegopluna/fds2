package cesar.school.raycharge.application.authentication.user;

public class UserRegisterRequest {
    public String login;
    public String password;
    public String role;

    public UserRegisterRequest(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}

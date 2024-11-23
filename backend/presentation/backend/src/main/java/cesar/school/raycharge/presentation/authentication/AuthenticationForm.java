package cesar.school.raycharge.presentation.authentication;

import cesar.school.raycharge.authentication.domain.user.UserRole;

public class AuthenticationForm {
    public UserDto user;

    public AuthenticationForm(UserDto user) {
        this.user = user;
    }

    public static class UserDto {
        public String login;
        public String password;
        public UserRole role;
    }
}

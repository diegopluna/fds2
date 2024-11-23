package cesar.school.raycharge.authentication.domain.user;

import cesar.school.raycharge.authentication.domain.AuthenticationUseCase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginUseCase extends AuthenticationUseCase {
    User existingUser;
    boolean loginResult;

    @Given("a user with login {string} and password {string}")
    public void a_user_with_login_and_password(String login, String password) {
        existingUser = new User(login, password, UserRole.DRIVER);
        authenticationService.createUser(existingUser);
    }

    @When("the user logs in with login {string} and password {string}")
    public void when_the_user_logs_in_with_login_and_password(String login, String password) {
        loginResult = authenticationService.login(login, password);
    }

    @Then("the user is logged in")
    public void the_user_is_logged_in() {
        assert loginResult;
    }

    @Then("the user is not logged in")
    public void the_user_is_not_logged_in() {
        assert !loginResult;
    }
}

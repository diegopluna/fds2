package cesar.school.raycharge.authentication.domain.user;

import cesar.school.raycharge.authentication.domain.AuthenticationUseCase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountUseCase extends AuthenticationUseCase {
    User user;
    User createdUser;
    User existingUser;

    @Given("a user with login {string}, password {string}, and role {string}")
    public void a_user_with_login_password_and_role(String login, String password, String role) {
        UserRole userRole = UserRole.valueOf(role);
        user = new User(login, password, userRole);
    }

    @When("I create the user")
    public void i_create_the_user() {
        createdUser = authenticationService.createUser(user);
    }

    @Then("the user should be saved successfully")
    public void the_user_should_be_saved_successfully() {
        assert createdUser != null;
    }

    @Then("the user should have a hashed password")
    public void the_user_should_have_a_hashed_password() {
        assert createdUser.getPassword() != null;
        assert createdUser.getPassword().endsWith("-hashed");
    }

    @Then("a user already exists with login {string}")
    public void a_user_already_exists_with_login(String login) {
        existingUser = new User(login, "password", UserRole.DRIVER);
        existingUser = authenticationService.createUser(existingUser);
        assert existingUser != null;
    }

    @Then("the user creation should fail")
    public void the_user_creation_should_fail() {
        assert createdUser == null;
    }

}

package cesar.school.raycharge.authentication.domain;

import cesar.school.raycharge.authentication.domain.security.FakePasswordHasher;
import cesar.school.raycharge.authentication.domain.security.PasswordHasher;
import cesar.school.raycharge.authentication.domain.user.AuthenticationService;
import cesar.school.raycharge.authentication.domain.user.UserRepository;
import cesar.school.raycharge.infra.persistence.memory.Repository;

public class AuthenticationUseCase {
    protected AuthenticationService authenticationService;

    public AuthenticationUseCase() {
        UserRepository userRepository = new Repository();
        PasswordHasher passwordHasher = new FakePasswordHasher();
        authenticationService = new AuthenticationService(userRepository, passwordHasher);
    }
}

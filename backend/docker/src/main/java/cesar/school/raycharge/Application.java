package cesar.school.raycharge;

import cesar.school.raycharge.authentication.domain.security.PasswordHasher;
import cesar.school.raycharge.authentication.domain.user.AuthenticationService;
import cesar.school.raycharge.authentication.domain.user.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class Application {
    @Bean
    public AuthenticationService authenticationService(UserRepository userRepository, PasswordHasher hasher) {
        return new AuthenticationService(userRepository, hasher);
    }
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
    }
}

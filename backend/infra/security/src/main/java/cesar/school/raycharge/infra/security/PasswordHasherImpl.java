package cesar.school.raycharge.infra.security;

import cesar.school.raycharge.authentication.domain.security.PasswordHasher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class PasswordHasherImpl implements PasswordHasher {

    private final BCryptPasswordEncoder passwordEncoder;

    public PasswordHasherImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
    }

    @Override
    public String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean verifyPassword(String plainPassword, String hashedPassword) {
        return passwordEncoder.matches(plainPassword, hashedPassword);
    }
}

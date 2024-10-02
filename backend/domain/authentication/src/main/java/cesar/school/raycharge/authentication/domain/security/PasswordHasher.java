package cesar.school.raycharge.authentication.domain.security;

public interface PasswordHasher {
    String hashPassword(String password);
    boolean verifyPassword(String plainPassword, String hashedPassword);
}

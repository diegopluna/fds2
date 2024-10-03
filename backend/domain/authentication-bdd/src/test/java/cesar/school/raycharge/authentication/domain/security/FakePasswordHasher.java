package cesar.school.raycharge.authentication.domain.security;

public class FakePasswordHasher implements PasswordHasher{
    @Override
    public String hashPassword(String password) {
        return password.concat("-hashed");
    }

    @Override
    public boolean verifyPassword(String plainPassword, String hashedPassword) {
        String hashedPlainPassword = hashPassword(plainPassword);
        return hashedPlainPassword.equals(hashedPassword);
    }
}

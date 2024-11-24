package cesar.school.raycharge.authentication.domain.user;

import org.jmolecules.ddd.types.ValueObject;

import static org.apache.commons.lang3.Validate.isTrue;

public class Token implements ValueObject {
    private final String token;

    public Token(String token) {
        isTrue(!token.isEmpty(), "Token must not be empty");
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Token token) {
            return this.token.equals(token.token);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }

    @Override
    public String toString() {
        return token;
    }
}

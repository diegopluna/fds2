package cesar.school.raycharge.infra.security;

import cesar.school.raycharge.authentication.domain.user.AuthenticationTokenProvider;
import cesar.school.raycharge.authentication.domain.user.Token;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;

@Service
public class AuthenticationTokenProviderImpl implements AuthenticationTokenProvider {
    private String secretKey = "secret";

    public void JwtTokenProvider(String secretKey) {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    @Override
    public Token createToken(String login) {
        final Date now = new Date();
        final Date validity = new Date(now.getTime() + 3600000);

        final Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return new Token(
                JWT.create()
                        .withSubject(login)
                        .withIssuedAt(now)
                        .withExpiresAt(validity)
                        .sign(algorithm)
        );
    }

    @Override
    public String validateToken(Token token) {
        final Algorithm algorithm = Algorithm.HMAC256(secretKey);
        final JWTVerifier verifier = JWT.require(algorithm).build();
        final DecodedJWT decoded = verifier.verify(token.getToken());
        return decoded.getSubject();
    }
}

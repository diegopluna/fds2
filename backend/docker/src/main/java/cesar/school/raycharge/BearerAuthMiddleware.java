package cesar.school.raycharge;

import cesar.school.raycharge.application.authentication.user.AuthTokenValidator;
import cesar.school.raycharge.authentication.domain.user.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class BearerAuthMiddleware extends OncePerRequestFilter {
    private final AuthTokenValidator authTokenValidator;

    public BearerAuthMiddleware(final AuthTokenValidator authTokenValidator) {
        this.authTokenValidator = authTokenValidator;
    }

    @Override
    protected void doFilterInternal(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader != null) {
            final String[] authElements = authHeader.split(" ");
            if (authElements.length == 2 && authElements[0].equals("Bearer")) {
                try {
                    final User user = authTokenValidator.validateToken(authElements[1]);
                    SecurityContextHolder.getContext().setAuthentication(
                            new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList())
                    );
                } catch (final RuntimeException e) {
                    SecurityContextHolder.clearContext();
                    throw e;
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}

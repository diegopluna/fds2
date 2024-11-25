package cesar.school.raycharge.presentation.authentication;

import cesar.school.raycharge.application.common.ErrorResponse;
import cesar.school.raycharge.application.authentication.user.UserAuthRequest;
import cesar.school.raycharge.application.authentication.user.UserAuthenticator;
import cesar.school.raycharge.application.authentication.user.UserRegister;
import cesar.school.raycharge.application.authentication.user.UserRegisterRequest;
import cesar.school.raycharge.authentication.domain.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @Autowired
    private UserAuthenticator userAuthenticator;
    @Autowired
    private UserRegister userRegister;

    @RequestMapping(method = RequestMethod.POST, path = "/sign-up")
    public ResponseEntity<?> signup(@RequestBody final UserRegisterRequest userRegisterRequest) {
        try {
            userRegister.register(userRegisterRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (final UserAlreadyExists e) {
            final HttpStatus httpStatus = HttpStatus.CONFLICT;
            final ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), e.getMessage());
            return ResponseEntity.status(httpStatus).body(errorResponse);
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity<?> login(@RequestBody final UserAuthRequest userAuthRequest) {
        try {
            final Token token = userAuthenticator.authenticate(userAuthRequest);
            return ResponseEntity.ok(token);
        } catch (final InvalidAuthLogin | InvalidAuthPassword e) {
            final HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
            final ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), e.getMessage());
            return ResponseEntity.status(httpStatus).body(errorResponse);
        }
    }
}

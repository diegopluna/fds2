package cesar.school.raycharge.presentation.authentication;

import cesar.school.raycharge.authentication.domain.user.AuthenticationService;
import cesar.school.raycharge.authentication.domain.user.User;
import cesar.school.raycharge.presentation.BackendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    private @Autowired AuthenticationService authenticationService;
    private @Autowired BackendMapper mapper;

    @RequestMapping(method = RequestMethod.POST, path = "/sign-up")
    public ResponseEntity<Void> signup(@RequestBody AuthenticationForm.UserDto dto) {
        var newUser = mapper.map(dto, User.class);
        var createdUser = authenticationService.createUser(newUser);
        if (createdUser == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<Void> hello() {
        return ResponseEntity.ok().build();
    }
}

package cesar.school.raycharge.presentation;

import cesar.school.raycharge.authentication.domain.user.User;
import cesar.school.raycharge.presentation.authentication.AuthenticationForm;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BackendMapper extends ModelMapper {
    BackendMapper() {
        
        addConverter(new AbstractConverter<AuthenticationForm.UserDto, User>() {
            @Override
            protected User convert(AuthenticationForm.UserDto source) {
                return new User(
                        source.login,
                        source.password,
                        source.role
                );
            }
        });
    }

    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        return source != null ? super.map(source, destinationType) : null;
    }
}

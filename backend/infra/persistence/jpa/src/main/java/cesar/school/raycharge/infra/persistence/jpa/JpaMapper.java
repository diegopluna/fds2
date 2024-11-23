package cesar.school.raycharge.infra.persistence.jpa;

import cesar.school.raycharge.authentication.domain.user.User;
import cesar.school.raycharge.authentication.domain.user.UserId;
import cesar.school.raycharge.authentication.domain.user.UserRole;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class JpaMapper extends ModelMapper {
    JpaMapper() {
        var config = getConfiguration();
        config.setFieldMatchingEnabled(true);
        ((Configuration) config).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        addConverter(new AbstractConverter<UserJpa, User>() {
            @Override
            protected User convert(UserJpa source) {
                var id = map(source.id, UserId.class);
                var userRole = map(source.role, UserRole.class);
                return new User(id, source.login, source.password, userRole);
            }
        });

    }
}

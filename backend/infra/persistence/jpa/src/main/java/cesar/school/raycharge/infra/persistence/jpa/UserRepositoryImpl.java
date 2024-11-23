package cesar.school.raycharge.infra.persistence.jpa;

import cesar.school.raycharge.authentication.domain.user.User;
import cesar.school.raycharge.authentication.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    UserJpaRepository repository;

    @Autowired
    JpaMapper mapper;

    @Override
    public User save(User user) {
        var userJpa = mapper.map(user, UserJpa.class);
        repository.save(userJpa);
        return user;
    }

    @Override
    public User findByLogin(String login) {
        java.util.Optional<UserJpa> userJpa = repository.findUserJpaByLogin(login);
        return userJpa.map(jpa -> mapper.map(jpa, User.class)).orElse(null);
    }
}

package cesar.school.raycharge.infra.persistence.jpa;

import cesar.school.raycharge.authentication.domain.user.User;
import cesar.school.raycharge.authentication.domain.user.UserRepository;
import cesar.school.raycharge.authentication.domain.user.UserRole;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Entity
@Table(name = "users")
public class UserJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(unique = true)
    String login;

    String password;

    @Enumerated(EnumType.STRING)
    UserRole role;
}

interface UserJpaRepository extends JpaRepository<UserJpa, String> {
    Optional<UserJpa> findUserJpaByLogin(String login);
}

@Repository
class UserRepositoryImpl implements UserRepository {
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
        Optional<UserJpa> userJpa = repository.findUserJpaByLogin(login);
        return userJpa.map(jpa -> mapper.map(jpa, User.class)).orElse(null);
    }
}


package cesar.school.raycharge.infra.persistence.jpa;

import cesar.school.raycharge.authentication.domain.user.User;
import cesar.school.raycharge.authentication.domain.user.UserId;
import cesar.school.raycharge.authentication.domain.user.UserRepository;
import cesar.school.raycharge.authentication.domain.user.UserRole;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(unique = true)
    String login;

    String password;

    @Enumerated(EnumType.STRING)
    UserRole role;

    public UserJpa() {
    }

    public UserJpa(UUID id, String login, String password, UserRole role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}

interface UserJpaRepository extends JpaRepository<UserJpa, UUID> {
    Optional<UserJpa> findUserJpaByLogin(String login);
    Optional<UserJpa> findById(UUID id);
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
        var saved = repository.save(userJpa);
        return mapper.map(saved, User.class);
    }

    @Override
    public User findByLogin(String login) {
        Optional<UserJpa> userJpa = repository.findUserJpaByLogin(login);
        return userJpa.map(jpa -> mapper.map(jpa, User.class)).orElse(null);
    }

    @Override
    public User findById(UserId id) {
        Optional<UserJpa> userJpa = repository.findById(UUID.fromString(id.toString()));
        return userJpa.map(jpa -> mapper.map(jpa, User.class)).orElse(null);
    }

}


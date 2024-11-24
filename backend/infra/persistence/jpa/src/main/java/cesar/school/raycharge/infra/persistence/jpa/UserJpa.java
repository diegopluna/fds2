package cesar.school.raycharge.infra.persistence.jpa;

import cesar.school.raycharge.authentication.domain.user.UserRole;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;
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


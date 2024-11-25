package cesar.school.raycharge.infra.persistence.jpa;

import cesar.school.raycharge.authentication.domain.user.UserId;
import cesar.school.raycharge.driver.domain.driver.Driver;
import cesar.school.raycharge.driver.domain.driver.DriverId;
import cesar.school.raycharge.driver.domain.driver.DriverRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "drivers")
public class DriverJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    UserJpa user;

    @Column(nullable = false)
    String name;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = true)
    List<VehicleJpa> vehicles;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ScheduleJpa> scheduleHistory;
}

interface DriverJpaRepository extends JpaRepository<DriverJpa, String> {
    Optional<DriverJpa> findById(String id);
    Optional<DriverJpa> findByUser_Id(String userId);
    Optional<DriverJpa> findByUser_Login(String userLogin);
}

@Repository
class DriverRepositoryImpl implements DriverRepository {
    @Autowired
    DriverJpaRepository repository;

    @Autowired
    JpaMapper mapper;

    @Override
    public Driver findByDriverId(DriverId driverId) {
        Optional<DriverJpa> driverJpa = repository.findById(driverId.getId());
        return driverJpa.map(jpa -> mapper.map(jpa, Driver.class)).orElse(null);
    }

    @Override
    public Driver findByUserId(UserId userId) {
        Optional<DriverJpa> driverJpa = repository.findByUser_Id(userId.getId());
        return driverJpa.map(jpa -> mapper.map(jpa, Driver.class)).orElse(null);
    }

    @Override
    public Driver save(Driver driver) {
        var driverJpa = mapper.map(driver, DriverJpa.class);
        return mapper.map(repository.save(driverJpa), Driver.class);
    }

    @Override
    public Driver findByUserLogin(String login) {
        Optional<DriverJpa> driverJpa = repository.findByUser_Login(login);
        return driverJpa.map(jpa -> mapper.map(jpa, Driver.class)).orElse(null);
    }
}

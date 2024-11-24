package cesar.school.raycharge.infra.persistence.jpa;

import cesar.school.raycharge.driver.domain.vehicle.Vehicle;
import cesar.school.raycharge.driver.domain.vehicle.VehicleId;
import cesar.school.raycharge.driver.domain.vehicle.VehicleRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "vehicles")
public class VehicleJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String name;

    String licensePlate;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    DriverJpa driver;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ScheduleJpa> scheduleHistory;
}

interface VehicleJpaRepository extends JpaRepository<VehicleJpa, String> {
    Optional<VehicleJpa> findVehicleJpaById(String id);
}

@Repository
class VehicleRepositoryImpl implements VehicleRepository {
    @Autowired
    VehicleJpaRepository repository;

    @Autowired
    JpaMapper mapper;

    @Override
    public Vehicle findById(VehicleId id) {
        Optional<VehicleJpa> vehicleJpa = repository.findVehicleJpaById(id.toString());
        return vehicleJpa.map(jpa -> mapper.map(jpa, Vehicle.class)).orElse(null);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        var vehicleJpa = mapper.map(vehicle, VehicleJpa.class);
        repository.save(vehicleJpa);
        return vehicle;
    }
}

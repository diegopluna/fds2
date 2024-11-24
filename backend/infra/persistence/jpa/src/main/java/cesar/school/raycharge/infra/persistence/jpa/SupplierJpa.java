package cesar.school.raycharge.infra.persistence.jpa;

import cesar.school.raycharge.supplier.domain.supplier.SupplierRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Entity
@Table(name = "suppliers")
public class SupplierJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String name;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ChargingStationJpa> chargingStations;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ScheduleJpa> usageHistory;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    UserJpa user;
}

interface SupplierJpaRepository extends JpaRepository<SupplierJpa, String> {}
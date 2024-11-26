package cesar.school.raycharge.infra.persistence.jpa;

import cesar.school.raycharge.supplier.domain.supplier.Supplier;
import cesar.school.raycharge.supplier.domain.supplier.SupplierId;
import cesar.school.raycharge.supplier.domain.supplier.SupplierRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "suppliers")
public class SupplierJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String name;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ChargingStationJpa> chargingStations;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ScheduleJpa> usageHistory;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    UserJpa user;

    public SupplierJpa() {
    }

    public SupplierJpa(UUID id, String name, List<ChargingStationJpa> chargingStations, List<ScheduleJpa> usageHistory, UserJpa user) {
        this.id = id;
        this.name = name;
        this.chargingStations = chargingStations;
        this.usageHistory = usageHistory;
        this.user = user;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChargingStationJpa> getChargingStations() {
        return chargingStations;
    }

    public void setChargingStations(List<ChargingStationJpa> chargingStations) {
        this.chargingStations = chargingStations;
    }

    public List<ScheduleJpa> getUsageHistory() {
        return usageHistory;
    }

    public void setUsageHistory(List<ScheduleJpa> usageHistory) {
        this.usageHistory = usageHistory;
    }

    public UserJpa getUser() {
        return user;
    }

    public void setUser(UserJpa user) {
        this.user = user;
    }
}

interface SupplierJpaRepository extends JpaRepository<SupplierJpa, UUID> {}

@Repository
class SupplierRepositoryImpl implements SupplierRepository {
    @Autowired
    SupplierJpaRepository repository;

    @Autowired
    JpaMapper mapper;

    @Override
    public Supplier save(Supplier supplier) {
        var supplierJpa = mapper.map(supplier, SupplierJpa.class);
        repository.save(supplierJpa);
        return supplier;
    }
}
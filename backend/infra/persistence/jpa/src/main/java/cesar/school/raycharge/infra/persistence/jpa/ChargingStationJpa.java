package cesar.school.raycharge.infra.persistence.jpa;

import cesar.school.raycharge.supplier.domain.station.ChargingStation;
import cesar.school.raycharge.supplier.domain.station.ChargingStationRepository;
import cesar.school.raycharge.supplier.domain.station.StationId;
import cesar.school.raycharge.supplier.domain.station.StationStatus;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "charging_stations")
public class ChargingStationJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    SupplierJpa supplier;

    String name;

    int numberOfChargers;

    @Embedded
    AvailableDateJpa workingHours;

    @Embedded
    AddressJpa address;

    @Enumerated(EnumType.STRING)
    StationStatus status;

    int minimumPrice;

    int pricePerKwh;

    double longitude;

    double latitude;

    int timePerSchedule;

    @ElementCollection
    @CollectionTable(
            name = "available_dates",
            joinColumns = @JoinColumn(name = "schedule_id")
    )
    List<AvailableDateJpa> availableDates;

    @OneToMany(mappedBy = "chargingStation", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ScheduleJpa> usageHistory;
}

interface ChargingStationJpaRepository extends JpaRepository<ChargingStationJpa, String> {
    Optional<ChargingStationJpa> findById(String id);
}

@Repository
class ChargingStationRepositoryImpl implements ChargingStationRepository {
    @Autowired
    ChargingStationJpaRepository repository;

    @Autowired
    JpaMapper mapper;

    @Override
    public List<ChargingStation> fetchAll() {
        List<ChargingStationJpa> stations = repository.findAll();
        var stationsList = new ArrayList<ChargingStation>();
        for (var station : stations) {
            stationsList.add(mapper.map(station, ChargingStation.class));
        }
        return stationsList;
    }

    @Override
    public ChargingStation save(ChargingStation station) {
        var stationJpa = mapper.map(station, ChargingStationJpa.class);
        return mapper.map(repository.save(stationJpa), ChargingStation.class);
    }

    @Override
    public ChargingStation findById(StationId id) {
        Optional<ChargingStationJpa> stationJpa = repository.findById(id.getId());
        return stationJpa.map(jpa -> mapper.map(jpa, ChargingStation.class)).orElse(null);
    }
}

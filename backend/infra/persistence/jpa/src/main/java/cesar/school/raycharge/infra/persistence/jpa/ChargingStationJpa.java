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
import java.util.UUID;

@Entity
@Table(name = "charging_stations")
public class ChargingStationJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

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
    @CollectionTable(name = "available_dates", joinColumns = @JoinColumn(name = "charging_station_id"))
    List<AvailableDateJpa> availableDates;

    @OneToMany(mappedBy = "chargingStation", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ScheduleJpa> usageHistory;

    public ChargingStationJpa() {
    }


    public ChargingStationJpa(UUID id, SupplierJpa supplier, String name, int numberOfChargers, AvailableDateJpa workingHours, AddressJpa address, StationStatus status, int minimumPrice, int pricePerKwh, double longitude, double latitude, int timePerSchedule, List<AvailableDateJpa> availableDates, List<ScheduleJpa> usageHistory) {
        this.id = id;
        this.supplier = supplier;
        this.name = name;
        this.numberOfChargers = numberOfChargers;
        this.workingHours = workingHours;
        this.address = address;
        this.status = status;
        this.minimumPrice = minimumPrice;
        this.pricePerKwh = pricePerKwh;
        this.longitude = longitude;
        this.latitude = latitude;
        this.timePerSchedule = timePerSchedule;
        this.availableDates = availableDates;
        this.usageHistory = usageHistory;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SupplierJpa getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierJpa supplier) {
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfChargers() {
        return numberOfChargers;
    }

    public void setNumberOfChargers(int numberOfChargers) {
        this.numberOfChargers = numberOfChargers;
    }

    public AvailableDateJpa getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(AvailableDateJpa workingHours) {
        this.workingHours = workingHours;
    }

    public AddressJpa getAddress() {
        return address;
    }

    public void setAddress(AddressJpa address) {
        this.address = address;
    }

    public StationStatus getStatus() {
        return status;
    }

    public void setStatus(StationStatus status) {
        this.status = status;
    }

    public int getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(int minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public int getPricePerKwh() {
        return pricePerKwh;
    }

    public void setPricePerKwh(int pricePerKwh) {
        this.pricePerKwh = pricePerKwh;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getTimePerSchedule() {
        return timePerSchedule;
    }

    public void setTimePerSchedule(int timePerSchedule) {
        this.timePerSchedule = timePerSchedule;
    }

    public List<AvailableDateJpa> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<AvailableDateJpa> availableDates) {
        this.availableDates = availableDates;
    }

    public List<ScheduleJpa> getUsageHistory() {
        return usageHistory;
    }

    public void setUsageHistory(List<ScheduleJpa> usageHistory) {
        this.usageHistory = usageHistory;
    }
}

interface ChargingStationJpaRepository extends JpaRepository<ChargingStationJpa, UUID> {
    Optional<ChargingStationJpa> findById(UUID id);
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
        Optional<ChargingStationJpa> stationJpa = repository.findById(UUID.fromString(id.toString()));
        return stationJpa.map(jpa -> mapper.map(jpa, ChargingStation.class)).orElse(null);
    }
}

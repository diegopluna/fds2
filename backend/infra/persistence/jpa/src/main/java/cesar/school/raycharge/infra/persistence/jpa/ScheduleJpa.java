package cesar.school.raycharge.infra.persistence.jpa;

import cesar.school.raycharge.driver.domain.driver.DriverId;
import cesar.school.raycharge.recharge.domain.schedule.Schedule;
import cesar.school.raycharge.recharge.domain.schedule.ScheduleId;
import cesar.school.raycharge.recharge.domain.schedule.ScheduleRepository;
import cesar.school.raycharge.recharge.domain.schedule.ScheduleStatus;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "schedules")
public class ScheduleJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    int chargerLiberationTime;

    @Embedded
    AvailableDateJpa scheduleDate;

    @Enumerated(EnumType.STRING)
    ScheduleStatus status;

    float totalRechargeValue;

    @Embedded
    ReviewJpa review;

    @ManyToOne
    @JoinColumn(name = "charging_station_id", nullable = false)
    ChargingStationJpa chargingStation;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    DriverJpa driver;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    VehicleJpa vehicle;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    SupplierJpa supplier;
}

interface ScheduleJpaRepository extends JpaRepository<ScheduleJpa, String> {
    List<ScheduleJpa> findAllByDriver_Id(String driverId);
    Optional<ScheduleJpa> findByDriver_Id(String driverId);
    Optional<ScheduleJpa> findById(String id);

}

@Repository
class ScheduleRepositoryImpl implements ScheduleRepository {
    @Autowired
    ScheduleJpaRepository repository;

    @Autowired
    JpaMapper mapper;


    @Override
    public List<Schedule> findAllByDriverId(DriverId driverId) {
        var schedulesJpa = repository.findAllByDriver_Id(driverId.toString());
        var schedules = new ArrayList<Schedule>();
        for (var scheduleJpa : schedulesJpa) {
            var schedule = mapper.map(scheduleJpa, Schedule.class);
            schedules.add(schedule);
        }
        return schedules;
    }

    @Override
    public Schedule findScheduleByDriverId(DriverId driverId) {
        Optional<ScheduleJpa> scheduleJpa = repository.findByDriver_Id(driverId.toString());
        return scheduleJpa.map(jpa -> mapper.map(jpa, Schedule.class)).orElse(null);
    }

    @Override
    public Schedule save(Schedule schedule) {
        var scheduleJpa = mapper.map(schedule, ScheduleJpa.class);
        repository.save(scheduleJpa);
        return schedule;
    }

    @Override
    public Schedule findById(ScheduleId scheduleId) {
        Optional<ScheduleJpa> scheduleJpa = repository.findById(scheduleId.toString());
        return scheduleJpa.map(jpa -> mapper.map(jpa, Schedule.class)).orElse(null);
    }

    @Override
    public Schedule update(Schedule schedule) {
        if (repository.existsById(schedule.getId().toString())) {
            var scheduleJpa = mapper.map(schedule, ScheduleJpa.class);
            repository.save(scheduleJpa);
            return schedule;
        }
        return null;
    }
}

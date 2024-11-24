package cesar.school.raycharge.recharge.domain.schedule;

import cesar.school.raycharge.driver.domain.driver.Driver;
import cesar.school.raycharge.driver.domain.driver.DriverRepository;
import cesar.school.raycharge.driver.domain.driver.DriverId;
import cesar.school.raycharge.driver.domain.vehicle.Vehicle;
import cesar.school.raycharge.driver.domain.vehicle.VehicleId;
import cesar.school.raycharge.driver.domain.vehicle.VehicleNotFound;
import cesar.school.raycharge.driver.domain.vehicle.VehicleRepository;
import cesar.school.raycharge.supplier.domain.station.*;
import org.jmolecules.ddd.annotation.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final DriverRepository driverRepository;
    private final ChargingStationRepository chargingStationRepository;
    private final VehicleRepository vehicleRepository;

    public ScheduleService(
            ScheduleRepository scheduleRepository,
            DriverRepository driverRepository,
            ChargingStationRepository chargingStationRepository,
            VehicleRepository vehicleRepository
    ) {
        Objects.requireNonNull(scheduleRepository, "scheduleRepository must not be null");
        Objects.requireNonNull(driverRepository, "driverRepository must not be null");
        Objects.requireNonNull(chargingStationRepository, "chargingStationRepository must not be null");
        Objects.requireNonNull(vehicleRepository, "vehicleRepository must not be null");
        this.scheduleRepository = scheduleRepository;
        this.driverRepository = driverRepository;
        this.chargingStationRepository = chargingStationRepository;
        this.vehicleRepository = vehicleRepository;
    }

    private void ensureDriverExists(Driver driver) {
        if (driver == null) {
            throw new DriverNotFound();
        }
    }

    private void ensureStationExists(ChargingStation station) {
        if (station == null) {
            throw new StationNotFound();
        }
    }

    private void ensureDriverHasNoActiveSchedule(Driver driver) {
        List<Schedule> allDriverSchedules = scheduleRepository.findAllByDriverId(driver.getId());
        List<Schedule> activeSchedules = allDriverSchedules.stream()
                .filter(schedule -> schedule.getScheduleStatus().equals(ScheduleStatus.ACTIVE))
                .toList();
        if (!activeSchedules.isEmpty()) {
            throw new ActiveScheduleFound();
        }
    }

    private void ensureStationIsAvailableOnScheduleDate(ChargingStation station, AvailableDate scheduleDate) {
        if (!station.getAvailableDates().contains(scheduleDate)) {
            throw new StationNotAvailable();
        }
    }

    private void ensureVehicleExists(Vehicle vehicle) {
        if (vehicle == null) {
            throw new VehicleNotFound();
        }
    }

    //HISTÓRIA 2
    public Schedule createSchedule(DriverId driverId, StationId stationId, AvailableDate scheduleDate, VehicleId vehicleId) {
        Driver driver = driverRepository.findByDriverId(driverId); // Revisar essa parte, possivelmente vai depender de UserID
        ensureDriverExists(driver);
        ensureDriverHasNoActiveSchedule(driver);

        ChargingStation station = chargingStationRepository.findById(stationId);
        ensureStationExists(station);
        ensureStationIsAvailableOnScheduleDate(station, scheduleDate);

        Vehicle vehicle = vehicleRepository.findById(vehicleId);
        ensureVehicleExists(vehicle);

        Schedule newSchedule = new Schedule(
                new ScheduleId(),
                null,
                scheduleDate,
                ScheduleStatus.ACTIVE,
                station.getMinimumPrice(),
                null,
                station.getId(),
                driver.getId(),
                vehicle.getId()
        );

        return scheduleRepository.save(newSchedule);
    }
}

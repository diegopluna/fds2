package cesar.school.raycharge.infra.persistence.memory;

import cesar.school.raycharge.authentication.domain.user.User;
import cesar.school.raycharge.authentication.domain.user.UserId;
import cesar.school.raycharge.authentication.domain.user.UserRepository;
import cesar.school.raycharge.driver.domain.driver.Driver;
import cesar.school.raycharge.driver.domain.driver.DriverId;
import cesar.school.raycharge.driver.domain.driver.DriverRepository;
import cesar.school.raycharge.driver.domain.vehicle.Vehicle;
import cesar.school.raycharge.driver.domain.vehicle.VehicleId;
import cesar.school.raycharge.driver.domain.vehicle.VehicleRepository;
import cesar.school.raycharge.recharge.domain.schedule.Schedule;
import cesar.school.raycharge.recharge.domain.schedule.ScheduleId;
import cesar.school.raycharge.recharge.domain.schedule.ScheduleRepository;
import cesar.school.raycharge.supplier.domain.station.ChargingStation;
import cesar.school.raycharge.supplier.domain.station.ChargingStationRepository;
import cesar.school.raycharge.supplier.domain.station.StationId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Repository implements UserRepository, ChargingStationRepository, ScheduleRepository, DriverRepository, VehicleRepository {
  /*-----------------------------------------------------------------------*/
  /* UserRepository                                                        */
  private Map<UserId, User> users = new HashMap<>();

  @Override
  public User save(User user) {
    Objects.requireNonNull(user, "user must not be null");
    if (users.containsKey(user.getId())) {
      return null;
    }
    for (User u : users.values()) {
      if (u.getLogin().equals(user.getLogin())) {
        return null;
      }
    }
    users.put(user.getId(), user);
    return user;
  }

  @Override
  public User findByLogin(String login) {
    Objects.requireNonNull(login, "login must not be null");
    for (User u : users.values()) {
      if (u.getLogin().equals(login)) {
        return u;
      }
    }
    return null;
  }

  /*-----------------------------------------------------------------------*/
  /* ChargingStationRepository                                             */
  private Map<StationId, ChargingStation> chargingStations = new HashMap<>();

  @Override
  public List<ChargingStation> fetchAll() {
    return List.copyOf(chargingStations.values());
  }

  @Override
  public ChargingStation save(ChargingStation station) {
    Objects.requireNonNull(station, "station must not be null");
    if (chargingStations.containsKey(station.getId())) {
      return null;
    }

    for (ChargingStation s : chargingStations.values()) {
      if (s.getName().equals(station.getName())) {
        return null;
      }
    }
    chargingStations.put(station.getId(), station);
    return station;
  }

  @Override
  public ChargingStation findById(StationId id) {
      Objects.requireNonNull(id, "id must not be null");
      return chargingStations.get(id);
  }
  /*-----------------------------------------------------------------------*/
  /* ScheduleRepository                                                    */
  private Map<ScheduleId, Schedule> schedules = new HashMap<>();


  @Override
  public List<Schedule> findAllByDriverId(DriverId driverId) {
    Objects.requireNonNull(driverId, "driverId must not be null");
    return schedules.values().stream()
        .filter(schedule -> schedule.getDriver().equals(driverId))
        .toList();
  }

  @Override
  public Schedule save(Schedule schedule) {
    Objects.requireNonNull(schedule, "schedule must not be null");
    if (schedules.containsKey(schedule.getId())) {
      return null;
    }
    schedules.put(schedule.getId(), schedule);
    return schedule;
  }

  @Override
  public Schedule findById(ScheduleId scheduleId) {
    Objects.requireNonNull(scheduleId, "scheduleId must not be null");
    return schedules.get(scheduleId);
  }

  @Override
  public Schedule update(Schedule schedule) {
    Objects.requireNonNull(schedule, "schedule must not be null");
    if (!schedules.containsKey(schedule.getId())) {
      return null;
    }
    schedules.put(schedule.getId(), schedule);
    return schedule;
  }
  /*-----------------------------------------------------------------------*/
  /* DriverRepository                                                      */
  private Map<DriverId, Driver> drivers = new HashMap<>();

  @Override
  public Driver findByDriverId(DriverId driverId) {
    Objects.requireNonNull(driverId, "driverId must not be null");
    return drivers.get(driverId);
  }

  @Override
  public Driver save(Driver driver) {
    Objects.requireNonNull(driver, "driver must not be null");
    if (drivers.containsKey(driver.getId())) {
      return null;
    }
    drivers.put(driver.getId(), driver);
    return driver;
  }

  /*-----------------------------------------------------------------------*/
  /* VehicleRepository                                                     */
  private Map<VehicleId, Vehicle> vehicles = new HashMap<>();

  @Override
  public Vehicle findById(VehicleId id) {
    Objects.requireNonNull(id, "id must not be null");
    return vehicles.get(id);
  }

  @Override
  public Vehicle save(Vehicle vehicle) {
      Objects.requireNonNull(vehicle, "vehicle must not be null");
      if (vehicles.containsKey(vehicle.getId())) {
          return null;
      }
      vehicles.put(vehicle.getId(), vehicle);
      return vehicle;
  }
}

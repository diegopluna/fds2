package cesar.school.raycharge.driver.domain.driver;

import cesar.school.raycharge.authentication.domain.user.UserId;
import cesar.school.raycharge.driver.domain.vehicle.VehicleId;
import cesar.school.raycharge.recharge.domain.schedule.ScheduleId;
import org.jmolecules.ddd.types.AggregateRoot;

import java.util.List;

public class Driver implements Cloneable, AggregateRoot<Driver, DriverId> {
    private final UserId userId;
    private final DriverId driverId;
    private String name;
    private List<VehicleId> vehicles;
    private List<ScheduleId> scheduleHistory;

    public Driver(UserId userId, DriverId driverId, String name, List<VehicleId> vehicles, List<ScheduleId> scheduleHistory) {
        this.userId = userId;
        this.driverId = driverId;
        this.name = name;
        this.vehicles = vehicles;
        this.scheduleHistory = scheduleHistory;
    }

    @Override
    public DriverId getId() {
        return this.driverId;
    }

    public UserId getUserId() {
        return userId;
    }

    @Override
    public Driver clone() {
        try {
            return (Driver) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

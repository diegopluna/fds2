package cesar.school.raycharge.driver.domain.vehicle;

import cesar.school.raycharge.driver.domain.driver.DriverId;
import cesar.school.raycharge.recharge.domain.schedule.ScheduleId;
import org.jmolecules.ddd.types.AggregateRoot;

import java.util.List;

public class Vehicle implements Cloneable, AggregateRoot<Vehicle, VehicleId> {
    private final DriverId driver;
    private final VehicleId vehicleId;
    private String name;
    private String licensePlate;
    private List<ScheduleId> scheduleHistory;

    public Vehicle(DriverId driver, VehicleId vehicleId, String name, String licensePlate, List<ScheduleId> scheduleHistory) {
        this.driver = driver;
        this.vehicleId = vehicleId;
        this.name = name;
        this.licensePlate = licensePlate;
        this.scheduleHistory = scheduleHistory;
    }

    @Override
    public VehicleId getId() {
        return this.vehicleId;
    }

    @Override
    public Vehicle clone() {
        try {
            return (Vehicle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}

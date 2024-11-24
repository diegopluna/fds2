package cesar.school.raycharge.recharge.domain.schedule;

import cesar.school.raycharge.driver.domain.driver.DriverId;
import cesar.school.raycharge.driver.domain.vehicle.VehicleId;
import cesar.school.raycharge.supplier.domain.station.AvailableDate;
import cesar.school.raycharge.supplier.domain.station.StationId;
import org.jmolecules.ddd.types.AggregateRoot;

public class Schedule implements Cloneable, AggregateRoot<Schedule, ScheduleId> {
    private final ScheduleId scheduleId;
    private int chargerLiberationCode;
    private AvailableDate scheduleDate;
    private ScheduleStatus scheduleStatus;
    private float totalRechargeValue;
    private Review review;
    private StationId chargingStation;
    private DriverId driver;
    private VehicleId vehicle;

    public ScheduleStatus getScheduleStatus() {
        return scheduleStatus;
    }

    public Schedule(ScheduleId scheduleId, Integer chargerLiberationCode, AvailableDate scheduleDate, ScheduleStatus scheduleStatus, float totalRechargeValue, Review review, StationId chargingStation, DriverId driver, VehicleId vehicle) {
        this.scheduleId = scheduleId;
        this.chargerLiberationCode = chargerLiberationCode;
        this.scheduleDate = scheduleDate;
        this.scheduleStatus = scheduleStatus;
        this.totalRechargeValue = totalRechargeValue;
        this.review = review;
        this.chargingStation = chargingStation;
        this.driver = driver;
        this.vehicle = vehicle;
    }


    @Override
    public ScheduleId getId() {
        return scheduleId;
    }

    @Override
    public Schedule clone() {
        try {
            return (Schedule) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


}

package cesar.school.raycharge.recharge.domain.schedule;

import cesar.school.raycharge.authentication.domain.user.UserId;
import cesar.school.raycharge.driver.domain.driver.Driver;
import cesar.school.raycharge.driver.domain.vehicle.Vehicle;
import cesar.school.raycharge.driver.domain.vehicle.VehicleId;
import cesar.school.raycharge.recharge.domain.RechargeUseCase;
import cesar.school.raycharge.supplier.domain.station.AvailableDate;
import cesar.school.raycharge.supplier.domain.station.ChargingStation;
import cesar.school.raycharge.supplier.domain.station.StationId;
import cesar.school.raycharge.supplier.domain.station.StationStatus;
import cesar.school.raycharge.supplier.domain.supplier.SupplierId;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CreateScheduleUseCase extends RechargeUseCase {
    UserId userId;
    Driver driver;
    ChargingStation chargingStation;
    Vehicle vehicle;
    Schedule schedule;
    Schedule previousSchedule;
    ScheduleNotFound scheduleNotFound;

    @Given("a driver with name {string}")
    public void a_driver_with_name(String driverName) {
        userId = new UserId();
        driver =driverService.createDriver(userId, driverName);
    }

    @Given("a station with name {string}")
    public void a_station_with_name(String stationName) {
        chargingStation = new ChargingStation(
                new StationId(),
                new SupplierId(),
                stationName,
                10,
                new AvailableDate(LocalDateTime.of(2021, 1, 1, 0, 0), LocalDateTime.of(2021, 1, 1, 23, 59)),
                null,
                StationStatus.ACTIVE,
                10,
                1,
                10.0,
                10.0,
                2,
                List.of(new AvailableDate(LocalDateTime.of(2021, 1, 1, 0, 0), LocalDateTime.of(2021, 1, 1, 23, 59))),
                new ArrayList<ScheduleId>()
        );
        chargingStationService.addStation(chargingStation);
    }

    @Given("a vehicle with name {string} and license plate {string}")
    public void a_vehicle_with_name_and_license_plate(String vehicleName, String licensePlate) {
        vehicle = new Vehicle(
                driver.getId(),
                new VehicleId(),
                vehicleName,
                licensePlate,
                new ArrayList<ScheduleId>()
        );
        vehicleService.addVehicle(vehicle);
    }

    @Given("a schedule already created")
    public void a_schedule_already_created() {
        previousSchedule = scheduleService.createSchedule(
                driver.getId(),
                chargingStation.getId(),
                new AvailableDate(LocalDateTime.of(2021, 1, 1, 0, 0), LocalDateTime.of(2021, 1, 1, 23, 59)),
                vehicle.getId()
        );
    }

    @When("I create the schedule in an available time slot")
    public void i_create_the_schedule_in_an_available_time_slot() {
        try {
            schedule =scheduleService.createSchedule(
                    driver.getId(),
                    chargingStation.getId(),
                    new AvailableDate(LocalDateTime.of(2021, 1, 1, 0, 0), LocalDateTime.of(2021, 1, 1, 23, 59)),
                    vehicle.getId()
            );
        } catch (ActiveScheduleFound e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("the schedule should be created")
    public void the_schedule_should_be_created() {
        assert schedule != null;
    }

    @Then("the schedule should not be created")
    public void the_schedule_should_not_be_created() {
        assert schedule == null;
    }

    @When("I cancel the schedule")
    public void i_cancel_the_schedule() {
        if (previousSchedule != null) {
            schedule = scheduleService.cancelSchedule(previousSchedule.getId(), false);
        } else {
            ScheduleId scheduleId = new ScheduleId();
            try {
                schedule = scheduleService.cancelSchedule(scheduleId, false);
            } catch (ScheduleNotFound e) {
                scheduleNotFound = e;
            }
        }
    }

    @Then("the schedule should be cancelled")
    public void the_schedule_should_be_cancelled() {
        assert schedule.getScheduleStatus().equals(ScheduleStatus.CANCELLED);
    }

    @Then("the schedule should not be cancelled")
    public void the_schedule_should_not_be_cancelled() {
        assert scheduleNotFound != null;
    }
}

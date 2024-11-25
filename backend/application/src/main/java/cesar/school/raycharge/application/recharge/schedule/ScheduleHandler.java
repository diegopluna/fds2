package cesar.school.raycharge.application.recharge.schedule;

import cesar.school.raycharge.driver.domain.driver.Driver;
import cesar.school.raycharge.driver.domain.driver.DriverService;
import cesar.school.raycharge.driver.domain.vehicle.VehicleId;
import cesar.school.raycharge.recharge.domain.schedule.DriverNotFound;
import cesar.school.raycharge.recharge.domain.schedule.Schedule;
import cesar.school.raycharge.recharge.domain.schedule.ScheduleService;
import cesar.school.raycharge.supplier.domain.station.StationId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleHandler {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private DriverService driverService;

    public Schedule scheduleRecharge(final CreateScheduleRequest request, final String login) {
        Driver driver = driverService.getDriverFromUserLogin(login);
        return scheduleService.createSchedule(
                driver.getId(),
                new StationId(request.getStationId()),
                request.getScheduleDate(),
                new VehicleId(request.getVehicleId())
        );
    }
}

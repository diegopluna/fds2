package cesar.school.raycharge.recharge.domain;

import cesar.school.raycharge.driver.domain.driver.DriverRepository;
import cesar.school.raycharge.driver.domain.driver.DriverService;
import cesar.school.raycharge.driver.domain.vehicle.VehicleRepository;
import cesar.school.raycharge.driver.domain.vehicle.VehicleService;
import cesar.school.raycharge.infra.persistence.memory.Repository;
import cesar.school.raycharge.recharge.domain.schedule.ScheduleRepository;
import cesar.school.raycharge.recharge.domain.schedule.ScheduleService;
import cesar.school.raycharge.supplier.domain.station.ChargingStationRepository;
import cesar.school.raycharge.supplier.domain.station.ChargingStationService;

public class RechargeUseCase {
    protected ScheduleService scheduleService;
    protected DriverService driverService;
    protected ChargingStationService chargingStationService;
    protected VehicleService vehicleService;

    public RechargeUseCase() {
        ScheduleRepository scheduleRepository = new Repository();
        DriverRepository driverRepository = new Repository();
        ChargingStationRepository chargingStationRepository = new Repository();
        VehicleRepository vehicleRepository = new Repository();
        scheduleService = new ScheduleService(
                scheduleRepository,
                driverRepository,
                chargingStationRepository,
                vehicleRepository
        );
        driverService = new DriverService(driverRepository);
        chargingStationService = new ChargingStationService(chargingStationRepository);
        vehicleService = new VehicleService(vehicleRepository);
    }
}

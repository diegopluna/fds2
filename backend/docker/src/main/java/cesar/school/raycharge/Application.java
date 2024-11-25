package cesar.school.raycharge;

import cesar.school.raycharge.driver.domain.driver.DriverRepository;
import cesar.school.raycharge.driver.domain.driver.DriverService;
import cesar.school.raycharge.driver.domain.vehicle.VehicleRepository;
import cesar.school.raycharge.recharge.domain.schedule.ScheduleRepository;
import cesar.school.raycharge.recharge.domain.schedule.ScheduleService;
import cesar.school.raycharge.supplier.domain.station.ChargingStationRepository;
import cesar.school.raycharge.supplier.domain.station.ChargingStationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class Application {

    @Bean
    public ScheduleService scheduleService(
            ScheduleRepository scheduleRepository,
            DriverRepository driverRepository,
            ChargingStationRepository chargingStationRepository,
            VehicleRepository vehicleRepository
    ) {
        return new ScheduleService(
                scheduleRepository,
                driverRepository,
                chargingStationRepository,
                vehicleRepository
        );
    }

    @Bean
    public ChargingStationService chargingStationService(ChargingStationRepository chargingStationRepository) {
        return new ChargingStationService(chargingStationRepository);
    }

    @Bean
    public DriverService driverService(DriverRepository driverRepository) {
        return new DriverService(driverRepository);
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
    }
}

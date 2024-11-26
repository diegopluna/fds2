package cesar.school.raycharge.infra.persistence.jpa;

import cesar.school.raycharge.authentication.domain.security.PasswordHasher;
import cesar.school.raycharge.authentication.domain.user.User;
import cesar.school.raycharge.authentication.domain.user.UserId;
import cesar.school.raycharge.authentication.domain.user.UserRepository;
import cesar.school.raycharge.authentication.domain.user.UserRole;
import cesar.school.raycharge.recharge.domain.schedule.ScheduleId;
import cesar.school.raycharge.supplier.domain.station.StationId;
import cesar.school.raycharge.supplier.domain.station.StationStatus;
import cesar.school.raycharge.supplier.domain.supplier.Supplier;
import cesar.school.raycharge.supplier.domain.supplier.SupplierId;
import cesar.school.raycharge.supplier.domain.supplier.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Configuration
public class DatabaseSeeder {
    @Autowired
    private UserJpaRepository userRepository;

    @Autowired
    private PasswordHasher passwordHasher;

    @Autowired
    private SupplierJpaRepository supplierRepository;

    @Autowired
    private ChargingStationJpaRepository stationRepository;


    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            System.out.println("Seeding database...");

            System.out.println("Creating users...");
            UserJpa voltPointUserJpa = new UserJpa(UUID.randomUUID(), "VoltPoint", passwordHasher.hashPassword("senha"), UserRole.SUPPLIER);
            UserJpa greenPlugUserJpa = new UserJpa(UUID.randomUUID(), "GreenPlug", passwordHasher.hashPassword("senha"), UserRole.SUPPLIER);
            UserJpa powerFlowUserJpa = new UserJpa(UUID.randomUUID(), "PowerFlow", passwordHasher.hashPassword("senha"), UserRole.SUPPLIER);
            UserJpa chargeUpUserJpa = new UserJpa(UUID.randomUUID(), "ChargeUp", passwordHasher.hashPassword("senha"), UserRole.SUPPLIER);

            voltPointUserJpa = userRepository.save(voltPointUserJpa);
            System.out.println("Saved User ID: " + voltPointUserJpa.getId());

            greenPlugUserJpa = userRepository.save(greenPlugUserJpa);
            System.out.println("Saved User ID: " + greenPlugUserJpa.getId());

            powerFlowUserJpa = userRepository.save(powerFlowUserJpa);
            System.out.println("Saved User ID: " + powerFlowUserJpa.getId());

            chargeUpUserJpa = userRepository.save(chargeUpUserJpa);
            System.out.println("Saved User ID: " + chargeUpUserJpa.getId());

            System.out.println("Users created.");

            System.out.println("Creating suppliers...");

            SupplierJpa voltPoint = new SupplierJpa(UUID.randomUUID(), "VoltPoint", new ArrayList<ChargingStationJpa>(), new ArrayList<ScheduleJpa>(), voltPointUserJpa);
            SupplierJpa greenPlug = new SupplierJpa(UUID.randomUUID(), "GreenPlug", new ArrayList<ChargingStationJpa>(), new ArrayList<ScheduleJpa>(), greenPlugUserJpa);
            SupplierJpa powerFlow = new SupplierJpa(UUID.randomUUID(), "PowerFlow", new ArrayList<ChargingStationJpa>(), new ArrayList<ScheduleJpa>(), powerFlowUserJpa);
            SupplierJpa chargeUp = new SupplierJpa(UUID.randomUUID(), "ChargeUp", new ArrayList<ChargingStationJpa>(), new ArrayList<ScheduleJpa>(), chargeUpUserJpa);

            voltPoint = supplierRepository.save(voltPoint);
            System.out.println("Saved Supplier ID: " + voltPoint.getId());

            greenPlug = supplierRepository.save(greenPlug);
            System.out.println("Saved Supplier ID: " + greenPlug.getId());

            powerFlow = supplierRepository.save(powerFlow);
            System.out.println("Saved Supplier ID: " + powerFlow.getId());

            chargeUp = supplierRepository.save(chargeUp);
            System.out.println("Saved Supplier ID: " + chargeUp.getId());

            System.out.println("Suppliers created.");

            System.out.println("Creatint stations...");

            ChargingStationJpa station1 = new ChargingStationJpa();
            station1.setId(UUID.randomUUID());
            station1.setSupplier(voltPoint);
            station1.setName("Station 1");
            station1.setNumberOfChargers(10);
            station1.setWorkingHours(new AvailableDateJpa(LocalDateTime.now(), LocalDateTime.now().plusDays(1)));
            station1.setAddress(new AddressJpa("123456-678", "Rua 1", 500, "Bairro 1", "Cidade 1", "Estado 1"));
            station1.setStatus(StationStatus.ACTIVE);
            station1.setMinimumPrice(10);
            station1.setPricePerKwh(1);
            station1.setLongitude(-34.8728162);
            station1.setLatitude(-8.0589129);
            station1.setTimePerSchedule(2);
            station1.setAvailableDates(List.of(new AvailableDateJpa(LocalDateTime.now(), LocalDateTime.now().plusDays(1))));
            station1.setUsageHistory(new ArrayList<ScheduleJpa>());

            station1 = stationRepository.save(station1);
            System.out.println("Saved Station ID: " + station1.getId());

            ChargingStationJpa station2 = new ChargingStationJpa();
            station2.setId(UUID.randomUUID());
            station2.setSupplier(greenPlug);
            station2.setName("Station 2");
            station2.setNumberOfChargers(10);
            station2.setWorkingHours(new AvailableDateJpa(LocalDateTime.now(), LocalDateTime.now().plusDays(1)));
            station2.setAddress(new AddressJpa("123456-678", "Rua 1", 500, "Bairro 1", "Cidade 1", "Estado 1"));
            station2.setStatus(StationStatus.ACTIVE);
            station2.setMinimumPrice(10);
            station2.setPricePerKwh(1);
            station2.setLongitude(-34.8732673);
            station2.setLatitude(-8.0609049);
            station2.setTimePerSchedule(2);
            station2.setAvailableDates(List.of(new AvailableDateJpa(LocalDateTime.now(), LocalDateTime.now().plusDays(1))));
            station2.setUsageHistory(new ArrayList<ScheduleJpa>());

            station2 = stationRepository.save(station2);
            System.out.println("Saved Station ID: " + station2.getId());

            ChargingStationJpa station3 = new ChargingStationJpa();
            station3.setId(UUID.randomUUID());
            station3.setSupplier(powerFlow);
            station3.setName("Station 3");
            station3.setNumberOfChargers(10);
            station3.setWorkingHours(new AvailableDateJpa(LocalDateTime.now(), LocalDateTime.now().plusDays(1)));
            station3.setAddress(new AddressJpa("123456-678", "Rua 1", 500, "Bairro 1", "Cidade 1", "Estado 1"));
            station3.setStatus(StationStatus.ACTIVE);
            station3.setMinimumPrice(10);
            station3.setPricePerKwh(1);
            station3.setLongitude(-34.8737749);
            station3.setLatitude(-8.0602457);
            station3.setTimePerSchedule(2);
            station3.setAvailableDates(List.of(new AvailableDateJpa(LocalDateTime.now(), LocalDateTime.now().plusDays(1))));
            station3.setUsageHistory(new ArrayList<ScheduleJpa>());

            station3 = stationRepository.save(station3);
            System.out.println("Saved Station ID: " + station3.getId());

            ChargingStationJpa station4 = new ChargingStationJpa();
            station4.setId(UUID.randomUUID());
            station4.setSupplier(chargeUp);
            station4.setName("Station 4");
            station4.setNumberOfChargers(10);
            station4.setWorkingHours(new AvailableDateJpa(LocalDateTime.now(), LocalDateTime.now().plusDays(1)));
            station4.setAddress(new AddressJpa("123456-678", "Rua 1", 500, "Bairro 1", "Cidade 1", "Estado 1"));
            station4.setStatus(StationStatus.ACTIVE);
            station4.setMinimumPrice(10);
            station4.setPricePerKwh(1);
            station4.setLongitude(-34.8720132);
            station4.setLatitude(-8.0595472);
            station4.setTimePerSchedule(2);
            station4.setAvailableDates(List.of(new AvailableDateJpa(LocalDateTime.now(), LocalDateTime.now().plusDays(1))));
            station4.setUsageHistory(new ArrayList<ScheduleJpa>());

            station4 = stationRepository.save(station4);
            System.out.println("Saved Station ID: " + station4.getId());


            System.out.println("Stations created.");

        };
    }
}

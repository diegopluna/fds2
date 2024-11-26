package cesar.school.raycharge.infra.persistence.jpa;

import cesar.school.raycharge.authentication.domain.user.User;
import cesar.school.raycharge.authentication.domain.user.UserId;
import cesar.school.raycharge.authentication.domain.user.UserRepository;
import cesar.school.raycharge.authentication.domain.user.UserRole;
import cesar.school.raycharge.driver.domain.driver.Driver;
import cesar.school.raycharge.driver.domain.driver.DriverId;
import cesar.school.raycharge.driver.domain.vehicle.Vehicle;
import cesar.school.raycharge.driver.domain.vehicle.VehicleId;
import cesar.school.raycharge.recharge.domain.schedule.*;
import cesar.school.raycharge.supplier.domain.station.*;
import cesar.school.raycharge.supplier.domain.supplier.Supplier;
import cesar.school.raycharge.supplier.domain.supplier.SupplierId;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class JpaMapper extends ModelMapper {

    JpaMapper() {
        var config = getConfiguration();
        config.setFieldMatchingEnabled(true);
        ((Configuration) config).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        addConverter(new AbstractConverter<UserJpa, User>() {
            @Override
            protected User convert(UserJpa source) {
                var id = map(source.id, UserId.class);
                var userRole = map(source.role, UserRole.class);
                return new User(id, source.login, source.password, userRole);
            }
        });

        addConverter(new AbstractConverter<VehicleJpa, Vehicle>() {
            @Override
            protected Vehicle convert(VehicleJpa source) {
                var id = map(source.id, VehicleId.class);
                var driverId = map(source.driver.id, DriverId.class);
                List<ScheduleId> scheduleHistory = new ArrayList<>();
                for (var schedule : source.scheduleHistory) {
                    scheduleHistory.add(map(schedule.id, ScheduleId.class));
                }
                return new Vehicle(
                        driverId,
                        id,
                        source.name,
                        source.licensePlate,
                        scheduleHistory
                );
            }
        });

        addConverter(new AbstractConverter<ScheduleJpa, Schedule>() {
            @Override
            protected Schedule convert(ScheduleJpa source) {
                var id = map(source.id, ScheduleId.class);
                var scheduleDate = map(source.scheduleDate, AvailableDate.class);
                var scheduleStatus = map(source.status, ScheduleStatus.class);
                var review = map(source.review, Review.class);
                var stationId = map(source.chargingStation.id, StationId.class);
                var driverId = map(source.driver.id, DriverId.class);
                var vehicleId = map(source.vehicle.id, VehicleId.class);
                return new Schedule(
                        id,
                        source.chargerLiberationTime,
                        scheduleDate,
                        scheduleStatus,
                        source.totalRechargeValue,
                        review,
                        stationId,
                        driverId,
                        vehicleId
                );
            }
        });

        addConverter(new AbstractConverter<DriverJpa, Driver>() {
            @Override
            protected Driver convert(DriverJpa source) {
                var id = map(source.id, DriverId.class);
                var userId = map(source.user.id, UserId.class);
                List<VehicleId> vehicles = new ArrayList<>();
                for (var vehicle : source.vehicles) {
                    vehicles.add(map(vehicle.id, VehicleId.class));
                }
                List<ScheduleId> scheduleHistory = new ArrayList<>();
                for (var schedule : source.scheduleHistory) {
                    scheduleHistory.add(map(schedule.id, ScheduleId.class));
                }
                return new Driver(
                        userId,
                        id,
                        source.name,
                        vehicles,
                        scheduleHistory
                );
            }
        });

        addConverter(new AbstractConverter<ReviewJpa, Review>() {
            @Override
            protected Review convert(ReviewJpa source) {
                var reviewScore = map(source.score, ReviewScore.class);
                return new Review(
                        new ReviewId(),
                        reviewScore,
                        source.comment
                );
            }
        });

        addConverter(new AbstractConverter<AvailableDateJpa, AvailableDate>() {
            @Override
            protected AvailableDate convert(AvailableDateJpa source) {
                return new AvailableDate(
                        source.scheduleStart,
                        source.scheduleEnd
                );
            }
        });

        addConverter(new AbstractConverter<AddressJpa, Address>() {
            @Override
            protected Address convert(AddressJpa source) {
                return new Address(
                        source.cep,
                        source.street,
                        source.number,
                        source.neighborhood,
                        source.city,
                        source.state
                );
            }
        });

        addConverter(new AbstractConverter<ChargingStationJpa, ChargingStation>() {
            @Override
            protected ChargingStation convert(ChargingStationJpa source) {
                var id = map(source.id, StationId.class);
                var supplierId = map(source.supplier.id, SupplierId.class);
                var workingHours = map(source.workingHours, AvailableDate.class);
                var address = map(source.address, Address.class);
                var status = map(source.status, StationStatus.class);
                var availableDates = new ArrayList<AvailableDate>();
                for (var availableDate : source.availableDates) {
                    availableDates.add(map(availableDate, AvailableDate.class));
                }
                var usageHistory = new ArrayList<ScheduleId>();
                for (var schedule : source.usageHistory) {
                    usageHistory.add(map(schedule.id, ScheduleId.class));
                }
                return new ChargingStation(
                        id,
                        supplierId,
                        source.name,
                        source.numberOfChargers,
                        workingHours,
                        address,
                        status,
                        source.minimumPrice,
                        source.pricePerKwh,
                        source.longitude,
                        source.latitude,
                        source.timePerSchedule,
                        availableDates,
                        usageHistory
                );
            }
        });

        addConverter(new AbstractConverter<SupplierJpa, Supplier>() {
            @Override
            protected Supplier convert(SupplierJpa source) {
                var id = map(source.id, SupplierId.class);
                var userId = map(source.user.id, UserId.class);
                List<StationId> chargingStations = new ArrayList<>();
                for (var chargingStation : source.chargingStations) {
                    chargingStations.add(map(chargingStation.id, StationId.class));
                }
                List<ScheduleId> usageHistory = new ArrayList<>();
                for (var schedule : source.usageHistory) {
                    usageHistory.add(map(schedule.id, ScheduleId.class));
                }
                return new Supplier(
                        userId,
                        id,
                        source.name,
                        chargingStations,
                        usageHistory
                );
            }
        });
    }
}

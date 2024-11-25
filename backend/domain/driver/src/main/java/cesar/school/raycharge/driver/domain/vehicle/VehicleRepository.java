package cesar.school.raycharge.driver.domain.vehicle;

public interface VehicleRepository {
    Vehicle findById(VehicleId id);
    Vehicle save(Vehicle vehicle);
}

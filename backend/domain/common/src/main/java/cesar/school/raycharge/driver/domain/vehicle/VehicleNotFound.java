package cesar.school.raycharge.driver.domain.vehicle;

public class VehicleNotFound extends RuntimeException {
    public VehicleNotFound() {
        super("Vehicle not found");
    }
}

package cesar.school.raycharge.recharge.domain.schedule;

public class DriverNotFound extends RuntimeException {
    public DriverNotFound() {
        super(
                "Driver not found"
        );
    }
}

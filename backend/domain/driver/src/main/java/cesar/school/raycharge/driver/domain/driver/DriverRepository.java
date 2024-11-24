package cesar.school.raycharge.driver.domain.driver;

public interface DriverRepository {
    Driver findByDriverId(DriverId driverId);
    Driver save(Driver driver);
}

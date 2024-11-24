package cesar.school.raycharge.driver.domain.driver;

import cesar.school.raycharge.authentication.domain.user.UserId;

public class DriverService {
    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver createDriver(UserId userId, String name) {
        Driver driver = new Driver(userId, new DriverId(), name, null, null);
        driverRepository.save(driver);
        return driver;
    }
}

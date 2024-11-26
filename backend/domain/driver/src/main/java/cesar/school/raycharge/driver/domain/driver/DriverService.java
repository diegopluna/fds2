package cesar.school.raycharge.driver.domain.driver;

import cesar.school.raycharge.authentication.domain.user.UserId;

public class DriverService implements IDriverService {
    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver createDriver(UserId userId, String name) {
        Driver driver = new Driver(userId, new DriverId(), name, null, null);
        driverRepository.save(driver);
        return driver;
    }

    @Override
    public Driver getDriverFromUserId(UserId userId) {
        return driverRepository.findByUserId(userId);
    }

    @Override
    public Driver getDriverFromUserLogin(String login) {
        return driverRepository.findByUserLogin(login);
    }

}

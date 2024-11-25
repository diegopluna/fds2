package cesar.school.raycharge.driver.domain.driver;

import cesar.school.raycharge.authentication.domain.user.UserId;

public interface DriverRepository {
    Driver findByDriverId(DriverId driverId);
    Driver findByUserId(UserId userId);
    Driver save(Driver driver);
    Driver findByUserLogin(String login);
}

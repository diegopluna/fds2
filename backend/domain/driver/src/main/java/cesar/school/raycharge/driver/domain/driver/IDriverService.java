package cesar.school.raycharge.driver.domain.driver;

import cesar.school.raycharge.authentication.domain.user.UserId;

public interface IDriverService {
    Driver createDriver(UserId userId, String name);
    Driver getDriverFromUserId(UserId userId);
    Driver getDriverFromUserLogin(String login);
}

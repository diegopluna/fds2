package cesar.school.raycharge.application.recharge.schedule;

import cesar.school.raycharge.authentication.domain.user.User;
import cesar.school.raycharge.authentication.domain.user.UserId;
import cesar.school.raycharge.authentication.domain.user.UserRepository;
import cesar.school.raycharge.driver.domain.driver.Driver;
import cesar.school.raycharge.driver.domain.driver.DriverService;
import cesar.school.raycharge.driver.domain.driver.IDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceProxy implements IDriverService {
    @Autowired
    private DriverService driverService;

    @Autowired
    private UserRepository userRepository;

    private boolean checkAccess(User user) {
        return user != null && user.getRole().equals("driver");
    }


    @Override
    public Driver createDriver(UserId userId, String name) {
        User user = userRepository.findById(userId);

        if (checkAccess(user)) {
            return driverService.createDriver(userId, name);
        }
        return null;
    }

    @Override
    public Driver getDriverFromUserId(UserId userId) {
        User user = userRepository.findById(userId);
        if (checkAccess(user)) {
            return driverService.getDriverFromUserId(userId);
        }
        return null;
    }

    @Override
    public Driver getDriverFromUserLogin(String login) {
        User user = userRepository.findByLogin(login);
        if (checkAccess(user)) {
            return driverService.getDriverFromUserLogin(login);
        }
        return null;
    }
}

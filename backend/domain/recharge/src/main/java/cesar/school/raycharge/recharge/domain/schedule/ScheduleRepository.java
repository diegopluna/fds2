package cesar.school.raycharge.recharge.domain.schedule;

import cesar.school.raycharge.driver.domain.driver.DriverId;

import java.util.List;

public interface ScheduleRepository {
    List<Schedule> findAllByDriverId(DriverId driverId);
    Schedule findScheduleByDriverId(DriverId driverId);
    Schedule save(Schedule schedule);
    Schedule findById(ScheduleId scheduleId);
    Schedule update(Schedule schedule);
}

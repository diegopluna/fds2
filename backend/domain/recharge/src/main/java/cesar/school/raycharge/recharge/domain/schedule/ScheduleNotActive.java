package cesar.school.raycharge.recharge.domain.schedule;

public class ScheduleNotActive extends RuntimeException {
    public ScheduleNotActive() {
        super("Schedule is not active");
    }
}

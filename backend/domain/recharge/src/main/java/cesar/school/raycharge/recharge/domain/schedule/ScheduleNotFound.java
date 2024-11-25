package cesar.school.raycharge.recharge.domain.schedule;

public class ScheduleNotFound extends RuntimeException {
    public ScheduleNotFound() {
        super("Schedule not found");
    }
}

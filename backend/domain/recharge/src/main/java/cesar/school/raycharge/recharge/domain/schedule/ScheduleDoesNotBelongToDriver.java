package cesar.school.raycharge.recharge.domain.schedule;

public class ScheduleDoesNotBelongToDriver extends RuntimeException {
    public ScheduleDoesNotBelongToDriver() {
        super(
                "The schedule does not belong to the driver"
        );
    }
}

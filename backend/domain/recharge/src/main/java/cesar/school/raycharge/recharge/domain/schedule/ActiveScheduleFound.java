package cesar.school.raycharge.recharge.domain.schedule;

public class ActiveScheduleFound extends RuntimeException {
    public ActiveScheduleFound() {
        super("Driver has an active schedule");
    }
}

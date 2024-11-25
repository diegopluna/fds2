package cesar.school.raycharge.infra.persistence.jpa;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class AvailableDateJpa {

    LocalDateTime scheduleStart;
    LocalDateTime scheduleEnd;

    protected AvailableDateJpa() {
    }

    public AvailableDateJpa(LocalDateTime scheduleStart, LocalDateTime scheduleEnd) {
        this.scheduleStart = scheduleStart;
        this.scheduleEnd = scheduleEnd;
    }

    public LocalDateTime getScheduleDate() {
        return scheduleStart;
    }

    public LocalDateTime getScheduleEnd() {
        return scheduleEnd;
    }

    public void setScheduleStart(LocalDateTime scheduleStart) {
        this.scheduleStart = scheduleStart;
    }

    public void setScheduleEnd(LocalDateTime scheduleEnd) {
        this.scheduleEnd = scheduleEnd;
    }

}

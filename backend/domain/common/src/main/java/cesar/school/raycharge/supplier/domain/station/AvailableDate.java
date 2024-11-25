package cesar.school.raycharge.supplier.domain.station;

import org.jmolecules.ddd.types.ValueObject;

import java.time.LocalDateTime;

public class AvailableDate implements ValueObject {
    private final LocalDateTime scheduleStart;
    private final LocalDateTime scheduleEnd;

    public AvailableDate(LocalDateTime scheduleStart, LocalDateTime scheduleEnd) {
        this.scheduleStart = scheduleStart;
        this.scheduleEnd = scheduleEnd;
    }

    public LocalDateTime getScheduleStart() {
        return scheduleStart;
    }

    public LocalDateTime getScheduleEnd() {
        return scheduleEnd;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof AvailableDate) {
            var availableDate = (AvailableDate) obj;
            return scheduleStart.equals(availableDate.scheduleStart) && scheduleEnd.equals(availableDate.scheduleEnd);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return scheduleStart.hashCode() + scheduleEnd.hashCode();
    }

    @Override
    public String toString() {
        return scheduleStart.toString() + " - " + scheduleEnd.toString();
    }

    public int getDurationInMinutes() {
        return (int) (scheduleEnd.toEpochSecond(null) - scheduleStart.toEpochSecond(null)) / 60;
    }
}

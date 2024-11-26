package cesar.school.raycharge.application.supplier.station;

import java.io.Serializable;

public class AvailableDateResponse implements Serializable {
    private final String scheduleStart;
    private final String scheduleEnd;

    public AvailableDateResponse(String scheduleStart, String scheduleEnd) {
        this.scheduleStart = scheduleStart;
        this.scheduleEnd = scheduleEnd;
    }

    public String getScheduleStart() {
        return scheduleStart;
    }

    public String getScheduleEnd() {
        return scheduleEnd;
    }


}

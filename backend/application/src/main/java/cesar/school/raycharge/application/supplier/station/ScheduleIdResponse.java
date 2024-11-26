package cesar.school.raycharge.application.supplier.station;

import java.io.Serializable;

public class ScheduleIdResponse implements Serializable {
    private final String id;

    public ScheduleIdResponse(String scheduleId) {
        this.id = scheduleId;
    }

    public String getScheduleId() {
        return id;
    }
}

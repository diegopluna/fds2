package cesar.school.raycharge.application.recharge.schedule;

import cesar.school.raycharge.supplier.domain.station.AvailableDate;

public class CreateScheduleRequest {
    public String stationId;
    public AvailableDate scheduleDate;
    public String vehicleId;

    public CreateScheduleRequest(String stationId, AvailableDate scheduleDate, String vehicleId) {
        this.stationId = stationId;
        this.scheduleDate = scheduleDate;
        this.vehicleId = vehicleId;
    }

    public String getStationId() {
        return stationId;
    }

    public AvailableDate getScheduleDate() {
        return scheduleDate;
    }

    public String getVehicleId() {
        return vehicleId;
    }
}

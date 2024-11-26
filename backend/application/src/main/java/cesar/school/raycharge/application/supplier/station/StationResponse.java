package cesar.school.raycharge.application.supplier.station;

import cesar.school.raycharge.recharge.domain.schedule.ScheduleId;
import cesar.school.raycharge.supplier.domain.station.Address;
import cesar.school.raycharge.supplier.domain.station.AvailableDate;

import java.io.Serializable;
import java.util.List;

public class StationResponse implements Serializable {
    private final String stationId;
    private final String supplierId;
    private final String name;
    private final int numberOfChargers;
    private final AvailableDateResponse workingHours;
    private final Address stationAddress;
    private final String status;
    private final int minimumPrice;
    private final int pricePerKwh;
    private final double longitude;
    private final double latitude;
    private final int timePerSchedule;
    private final List<AvailableDateResponse> availableDates;
    private final List<ScheduleIdResponse> usageHistory;

    public StationResponse(String stationId, String supplierId, String name, int numberOfChargers, AvailableDateResponse workingHours, Address stationAddress, String status, int minimumPrice, int pricePerKwh, double longitude, double latitude, int timePerSchedule, List<AvailableDateResponse> availableDates, List<ScheduleIdResponse> usageHistory) {
        this.stationId = stationId;
        this.supplierId = supplierId;
        this.name = name;
        this.numberOfChargers = numberOfChargers;
        this.workingHours = workingHours;
        this.stationAddress = stationAddress;
        this.status = status;
        this.minimumPrice = minimumPrice;
        this.pricePerKwh = pricePerKwh;
        this.longitude = longitude;
        this.latitude = latitude;
        this.timePerSchedule = timePerSchedule;
        this.availableDates = availableDates;
        this.usageHistory = usageHistory;
    }

    public String getStationId() {
        return stationId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfChargers() {
        return numberOfChargers;
    }

    public AvailableDateResponse getWorkingHours() {
        return workingHours;
    }

    public Address getStationAddress() {
        return stationAddress;
    }

    public String getStatus() {
        return status;
    }

    public int getMinimumPrice() {
        return minimumPrice;
    }

    public int getPricePerKwh() {
        return pricePerKwh;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public int getTimePerSchedule() {
        return timePerSchedule;
    }

    public List<AvailableDateResponse> getAvailableDates() {
        return availableDates;
    }

    public List<ScheduleIdResponse> getUsageHistory() {
        return usageHistory;
    }
}

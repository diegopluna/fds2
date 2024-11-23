package cesar.school.raycharge.supplier.domain.station;

import cesar.school.raycharge.recharge.domain.schedule.ScheduleId;
import cesar.school.raycharge.supplier.domain.supplier.SupplierId;

import java.util.List;

public class ChargingStation {
    private final StationId stationId;
    private final SupplierId supplierId;
    private String name;
    private int numberOfChargers;
    private AvailableDate workingHours;
    private Address stationAddress;
    private StationStatus status;
    private int minimumPrice;
    private int pricePerKwh;
    private double longitude;
    private double latitude;
    private int timePerSchedule;
    private List<AvailableDate> availableDates;
    private List<ScheduleId> usageHistory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfChargers() {
        return numberOfChargers;
    }

    public void setNumberOfChargers(int numberOfChargers) {
        this.numberOfChargers = numberOfChargers;
    }

    public AvailableDate getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(AvailableDate workingHours) {
        this.workingHours = workingHours;
    }

    public Address getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(Address stationAddress) {
        this.stationAddress = stationAddress;
    }

    public StationStatus getStatus() {
        return status;
    }

    public void setStatus(StationStatus status) {
        this.status = status;
    }

    public int getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(int minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public int getPricePerKwh() {
        return pricePerKwh;
    }

    public void setPricePerKwh(int pricePerKwh) {
        this.pricePerKwh = pricePerKwh;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getTimePerSchedule() {
        return timePerSchedule;
    }

    public void setTimePerSchedule(int timePerSchedule) {
        this.timePerSchedule = timePerSchedule;
    }

    public List<AvailableDate> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<AvailableDate> availableDates) {
        this.availableDates = availableDates;
    }

    public List<ScheduleId> getUsageHistory() {
        return usageHistory;
    }

    public void setUsageHistory(List<ScheduleId> usageHistory) {
        this.usageHistory = usageHistory;
    }

    public ChargingStation(StationId stationId, SupplierId supplierId, String name, int numberOfChargers, AvailableDate workingHours, Address stationAddress, StationStatus status, int minimumPrice, int pricePerKwh, double longitude, double latitude, int timePerSchedule, List<AvailableDate> availableDates, List<ScheduleId> usageHistory) {
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


    public StationId getId() {
        return stationId;
    }

    public SupplierId getSupplierId() {
        return supplierId;
    }

    public boolean isInRadius(double latitude, double longitude, int radiusKm) {
        double SEMI_MAJOR_AXIS = 6378137.0;
        double FLATTENING = 1 / 298.257223563;
        double ECCENTRICITY_SQUARED = 2 * FLATTENING - FLATTENING * FLATTENING;

        double lat1Rad = Math.toRadians(this.latitude);
        double lat2Rad = Math.toRadians(latitude);
        double lon1Rad = Math.toRadians(this.longitude);
        double lon2Rad = Math.toRadians(longitude);

        double meanLat = (lat1Rad + lat2Rad) / 2;

        double K = SEMI_MAJOR_AXIS * (1 - ECCENTRICITY_SQUARED) / Math.pow(1 - ECCENTRICITY_SQUARED * Math.pow(Math.sin(meanLat), 2), 1.5);

        double d_lat = lat2Rad - lat1Rad;
        double d_lon = lon2Rad - lon1Rad;

        double X = K * d_lat;
        double Y = K * Math.cos(meanLat) * d_lon;

        double distance = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2)) / 1000;
        return distance <= radiusKm;

    }
}

package cesar.school.raycharge.application.supplier.station;

public class StationsByDistanceRequest {
    public Double latitude;
    public Double longitude;
    public int distance;

    public StationsByDistanceRequest(Double latitude, Double longitude, int distance) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public int getDistance() {
        return distance;
    }
}

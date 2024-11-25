package cesar.school.raycharge.supplier.domain.station;

public class StationNotFound extends RuntimeException {
    public StationNotFound() {
        super("Station not found");
    }
}

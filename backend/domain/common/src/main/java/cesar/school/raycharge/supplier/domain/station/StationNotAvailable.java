package cesar.school.raycharge.supplier.domain.station;

public class StationNotAvailable extends RuntimeException {
    public StationNotAvailable() {
        super(
                "Station is not available on the requested date. Please try another date or time."
        );
    }
}

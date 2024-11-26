package cesar.school.raycharge.application.supplier.station;

import cesar.school.raycharge.supplier.domain.station.ChargingStation;
import cesar.school.raycharge.supplier.domain.station.ChargingStationService;

import java.io.Serializable;
import java.util.List;

public class StationsResponse implements Serializable {
    private final List<StationResponse> chargingStations;

    public StationsResponse(List<StationResponse> chargingStations) {
        this.chargingStations = chargingStations;
    }

    public List<StationResponse> getChargingStations() {
        return chargingStations;
    }

}

package cesar.school.raycharge.application.supplier.station;

import cesar.school.raycharge.supplier.domain.station.ChargingStation;

import java.util.List;

public class StationsResponse {
    public List<ChargingStation> chargingStations;

    public StationsResponse(List<ChargingStation> chargingStations) {
        this.chargingStations = chargingStations;
    }

    public List<ChargingStation> getChargingStations() {
        return chargingStations;
    }
}

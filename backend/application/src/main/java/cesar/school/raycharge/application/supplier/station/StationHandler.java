package cesar.school.raycharge.application.supplier.station;

import cesar.school.raycharge.supplier.domain.station.ChargingStation;
import cesar.school.raycharge.supplier.domain.station.ChargingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationHandler {
    @Autowired
    private ChargingStationService chargingStationService;

    public StationsResponse fetchStationsByDistance(StationsByDistanceRequest request) {
        List<ChargingStation> stations = chargingStationService.fetchByDistance(request.getLatitude(), request.getLongitude(), request.getDistance());
        return new StationsResponse(stations);
    }
}

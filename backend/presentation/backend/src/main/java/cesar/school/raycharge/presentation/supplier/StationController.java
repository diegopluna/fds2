package cesar.school.raycharge.presentation.supplier;

import cesar.school.raycharge.application.supplier.station.StationHandler;
import cesar.school.raycharge.application.supplier.station.StationsByDistanceRequest;
import cesar.school.raycharge.application.supplier.station.StationsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier/station")
public class StationController {
    @Autowired
    private StationHandler stationHandler;

    @PostMapping("/fetch-by-distance")
    public ResponseEntity<?> fetchByDistance(@RequestBody final StationsByDistanceRequest request) {
        StationsResponse stationsResponse = stationHandler.fetchStationsByDistance(request);
        return ResponseEntity.ok(stationsResponse);
    }
}

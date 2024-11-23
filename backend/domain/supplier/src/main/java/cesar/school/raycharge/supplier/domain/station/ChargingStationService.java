package cesar.school.raycharge.supplier.domain.station;

import org.jmolecules.ddd.annotation.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ChargingStationService {
    private ChargingStationRepository chargingStationRepository;

    public ChargingStationService(ChargingStationRepository chargingStationRepository) {
        Objects.requireNonNull(chargingStationRepository, "ChargingStationRepository must not be null");
        this.chargingStationRepository = chargingStationRepository;
    }

    public List<ChargingStation> fetchAllStations() {
        return chargingStationRepository.fetchAll();
    }

    public List<ChargingStation> fetchByDistance(double latitude, double longitude, int radiusKm) {
        List<ChargingStation> stations = chargingStationRepository.fetchAll();
        System.out.println("Stations: " + stations);
        System.out.println("Latitude: " + latitude);
        System.out.println("Longitude: " + longitude);
        return stations.stream()
                .filter(station -> station.isInRadius(latitude, longitude, radiusKm))
                .toList();
    }

    public ChargingStation addStation(ChargingStation station) {
        return chargingStationRepository.save(station);
    }
}

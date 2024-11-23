package cesar.school.raycharge.supplier.domain.station;

import java.util.List;

public interface ChargingStationRepository {
    List<ChargingStation> fetchAll();
    ChargingStation save(ChargingStation station);
}

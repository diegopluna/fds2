package cesar.school.raycharge.supplier.domain;

import cesar.school.raycharge.infra.persistence.memory.Repository;
import cesar.school.raycharge.supplier.domain.station.ChargingStationRepository;
import cesar.school.raycharge.supplier.domain.station.ChargingStationService;


public class SupplierUseCase {
    protected ChargingStationService chargingStationService;

    public SupplierUseCase() {
        ChargingStationRepository chargingStationRepository = new Repository();
        chargingStationService = new ChargingStationService(chargingStationRepository);
    }
}

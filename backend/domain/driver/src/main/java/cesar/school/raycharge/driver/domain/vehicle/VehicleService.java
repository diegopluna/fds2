package cesar.school.raycharge.driver.domain.vehicle;

public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return vehicle;
    }


}

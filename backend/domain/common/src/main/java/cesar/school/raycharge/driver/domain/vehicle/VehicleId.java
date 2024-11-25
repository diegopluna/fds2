package cesar.school.raycharge.driver.domain.vehicle;

import org.jmolecules.ddd.types.Identifier;
import org.jmolecules.ddd.types.ValueObject;

import java.util.UUID;

import static org.apache.commons.lang3.Validate.isTrue;

public class VehicleId implements ValueObject, Identifier {
    private final String id;

    public VehicleId(String id) {
        isTrue(!id.isEmpty(), "Id must not be empty");
        this.id = id;
    }

    public VehicleId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof VehicleId) {
            var vehicleId = (VehicleId) obj;
            return id.equals(vehicleId.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

package cesar.school.raycharge.driver.domain.driver;

import org.jmolecules.ddd.types.Identifier;
import org.jmolecules.ddd.types.ValueObject;

import java.util.UUID;

public class DriverId implements ValueObject, Identifier {
    private final String id;

    public DriverId(String id) {
        this.id = id;
    }

    public DriverId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof DriverId) {
            var driverId = (DriverId) obj;
            return id.equals(driverId.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id;
    }

}

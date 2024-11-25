package cesar.school.raycharge.supplier.domain.station;

import org.jmolecules.ddd.types.Identifier;
import org.jmolecules.ddd.types.ValueObject;

import java.util.UUID;

import static org.apache.commons.lang3.Validate.isTrue;

public class StationId implements ValueObject, Identifier {
    private final String id;

    public StationId(String id) {
        isTrue(!id.isEmpty(), "Id must not be empty");
        this.id = id;
    }

    public StationId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StationId stationId) {
            return id.equals(stationId.id);
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
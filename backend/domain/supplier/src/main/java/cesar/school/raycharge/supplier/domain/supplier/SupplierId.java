package cesar.school.raycharge.supplier.domain.supplier;


import org.jmolecules.ddd.types.Identifier;
import org.jmolecules.ddd.types.ValueObject;

import java.util.UUID;

import static org.apache.commons.lang3.Validate.isTrue;

public class SupplierId implements ValueObject, Identifier {
    private final String id;

    public SupplierId(String id) {
        isTrue(!id.isEmpty(), "Id must not be empty");
        this.id = id;
    }

    public SupplierId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SupplierId supplierId) {
            return id.equals(supplierId.id);
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

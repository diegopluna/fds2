package cesar.school.raycharge.recharge.domain.schedule;

import org.jmolecules.ddd.types.Identifier;
import org.jmolecules.ddd.types.ValueObject;

import java.util.UUID;

public class ReviewId implements ValueObject, Identifier {
    private final String id;

    public ReviewId(String value) {
        this.id = value;
    }

    public ReviewId() {
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
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ReviewId reviewId) {
            return id.equals(reviewId.id);
        }
        return false;
    }

}

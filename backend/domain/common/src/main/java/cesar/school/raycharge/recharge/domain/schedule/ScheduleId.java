package cesar.school.raycharge.recharge.domain.schedule;

import org.jmolecules.ddd.types.Identifier;
import org.jmolecules.ddd.types.ValueObject;

import java.util.UUID;

import static org.apache.commons.lang3.Validate.isTrue;

public class ScheduleId implements ValueObject, Identifier {
    private final String id;

    public ScheduleId(String id) {
        isTrue(!id.isEmpty(), "Id must not be empty");
        this.id = id;
    }

    public ScheduleId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScheduleId scheduleIdId) {
            return id.equals(scheduleIdId.id);
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

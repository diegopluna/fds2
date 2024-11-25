package cesar.school.raycharge.event.domain;

import org.jmolecules.event.types.DomainEvent;

public interface EventObserver<E extends DomainEvent> {
    void observeEvent(E event);
}

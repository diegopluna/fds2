package cesar.school.raycharge.event.domain;

import org.jmolecules.event.types.DomainEvent;

public interface EventBus {
    <T extends DomainEvent> void add(EventObserver<T> observer);

    void publish(DomainEvent event);
}

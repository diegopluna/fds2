package cesar.school.raycharge;

import cesar.school.raycharge.event.domain.EventBus;
import cesar.school.raycharge.event.domain.EventObserver;
import org.jmolecules.event.types.DomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EventBusImpl implements EventBus {
    @Autowired
    private ApplicationEventMulticaster multicaster;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public <T extends DomainEvent> void add(EventObserver<T> observer) {
        Objects.requireNonNull(observer, "Observer must not be null");

        multicaster.addApplicationListener(new ApplicationListener<PayloadApplicationEvent<T>>() {
            public void onApplicationEvent(PayloadApplicationEvent<T> event) {
                observer.observeEvent(event.getPayload());
            }
        });
    }

    @Override
    public void publish(DomainEvent event) {
        publisher.publishEvent(event);
    }
}

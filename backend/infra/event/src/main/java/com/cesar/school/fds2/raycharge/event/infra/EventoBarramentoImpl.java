package com.cesar.school.fds2.raycharge.event.infra;

import com.cesar.school.fds2.raycharge.event.domain.EventoBarramento;
import com.cesar.school.fds2.raycharge.event.domain.EventoObservador;
import org.jmolecules.event.types.DomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EventoBarramentoImpl implements EventoBarramento {
  @Autowired
  private ApplicationEventMulticaster multicaster;

  @Autowired
  private ApplicationEventPublisher publicador;

  @Override
  public <T extends DomainEvent> void adicionar(EventoObservador<T> observador) {
    Objects.requireNonNull(observador, "Observador não pode ser nulo");

    multicaster.addApplicationListener(new ApplicationListener<PayloadApplicationEvent<T>>() {
      public void onApplicationEvent(PayloadApplicationEvent<T> evento) {
        observador.observarEvento(evento.getPayload());
      }
    });
  }

  @Override
  public void postar(DomainEvent evento) {
    publicador.publishEvent(evento);
  }
}

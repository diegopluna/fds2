package com.cesar.school.fds2.raycharge.event.domain;

import org.jmolecules.event.types.DomainEvent;

public interface EventoBarramento {
  <T extends DomainEvent> void adicionar(EventoObservador<T> observador);

  void postar(DomainEvent evento);
}

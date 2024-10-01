package com.cesar.school.fds2.raycharge.event.domain;

import org.jmolecules.event.types.DomainEvent;

public interface EventoObservador<E extends DomainEvent> {
  void observarEvento(E evento);
}

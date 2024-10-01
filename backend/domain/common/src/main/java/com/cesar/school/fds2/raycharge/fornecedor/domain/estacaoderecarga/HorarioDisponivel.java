package com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga;

import java.time.LocalDateTime;

import org.jmolecules.ddd.types.ValueObject;

public class HorarioDisponivel implements ValueObject {
  private final LocalDateTime inicioAgendamento;
  private final LocalDateTime fimAgendamento;

  public HorarioDisponivel(LocalDateTime inicioAgendamento, LocalDateTime fimAgendamento) {
    this.inicioAgendamento = inicioAgendamento;
    this.fimAgendamento = fimAgendamento;
  }

  public LocalDateTime getInicioAgendamento() {
    return inicioAgendamento;
  }

  public LocalDateTime getFimAgendamento() {
    return fimAgendamento;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj instanceof HorarioDisponivel) {
      var horarioDisponivel = (HorarioDisponivel) obj;
      return inicioAgendamento.equals(horarioDisponivel.inicioAgendamento) && fimAgendamento.equals(horarioDisponivel.fimAgendamento);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return inicioAgendamento.hashCode() + fimAgendamento.hashCode();
  }

  @Override
  public String toString() {
    return inicioAgendamento.toString() + " - " + fimAgendamento.toString();
  }

  public int getDurationInMinutes(HorarioDisponivel horario) {
    long diffInMinutes = java.time.Duration.between(horario.getInicioAgendamento(), horario.getFimAgendamento()).toMinutes();
    return (int) diffInMinutes;
  }
}

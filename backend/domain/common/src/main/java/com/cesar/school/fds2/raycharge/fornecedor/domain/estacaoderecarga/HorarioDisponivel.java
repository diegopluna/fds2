package com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga;

import java.util.Date;

import org.jmolecules.ddd.types.ValueObject;

public class HorarioDisponivel implements ValueObject {
  private final Date inicioAgendamento;
  private final Date fimAgendamento;

  public HorarioDisponivel(Date inicioAgendamento, Date fimAgendamento) {
    this.inicioAgendamento = inicioAgendamento;
    this.fimAgendamento = fimAgendamento;
  }

  public Date getInicioAgendamento() {
    return inicioAgendamento;
  }

  public Date getFimAgendamento() {
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
      // revisar
      long diffInMillies = Math.abs(horario.getFimAgendamento().getTime() - horario.getInicioAgendamento().getTime());
      return (int) diffInMillies;
    }
}

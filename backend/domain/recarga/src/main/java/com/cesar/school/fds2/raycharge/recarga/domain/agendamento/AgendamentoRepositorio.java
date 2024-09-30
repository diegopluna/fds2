package com.cesar.school.fds2.raycharge.recarga.domain.agendamento;

import java.util.List;

import com.cesar.school.fds2.raycharge.agendamento.domain.agendamento.IdAgendamento;

public interface AgendamentoRepositorio {
    void saveAgendamento(Agendamento agendamento);
    Agendamento findById(IdAgendamento idAgendamento);
    void deleteById(IdAgendamento idAgendamento);
    List<Agendamento> findAll();
}
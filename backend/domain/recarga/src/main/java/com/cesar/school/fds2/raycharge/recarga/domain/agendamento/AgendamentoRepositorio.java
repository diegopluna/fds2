package com.cesar.school.fds2.raycharge.recarga.domain.agendamento;

import java.util.List;
import java.util.Optional;

public interface AgendamentoRepositorio {
    void saveAgendamento(Agendamento agendamento);
    Optional<Agendamento> findById(IdAgendamento idAgendamento);
    void deleteById(IdAgendamento idAgendamento);
    List<Agendamento> findAll();
    void saveAvaliacao(IdAgendamento idAgendamento, Avaliacao avaliacao);
}
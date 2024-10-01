package com.cesar.school.fds2.raycharge.recarga.domain.agendamento;

import java.util.List;
import java.util.Optional;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.IdMotorista;
public interface AgendamentoRepositorio {
    void saveAgendamento(Agendamento agendamento);
    Optional<Agendamento> findById(IdAgendamento idAgendamento);
    List<Agendamento> buscarMotoristaPorId(IdMotorista idMotorista);
    void deleteById(IdAgendamento idAgendamento);
    List<Agendamento> findAll();
    void saveAvaliacao(IdAgendamento idAgendamento, Avaliacao avaliacao);
}
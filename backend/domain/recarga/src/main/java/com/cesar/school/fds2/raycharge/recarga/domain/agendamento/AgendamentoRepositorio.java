package com.cesar.school.fds2.raycharge.recarga.domain.agendamento;

import java.util.List;

import com.cesar.school.fds2.raycharge.agendamento.domain.agendamento.Avaliacao;
import com.cesar.school.fds2.raycharge.agendamento.domain.agendamento.IdAgendamento;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.IdMotorista;
public interface AgendamentoRepositorio {
    void saveAgendamento(Agendamento agendamento);
    Agendamento findById(IdAgendamento idAgendamento);
    List<Agendamento> buscarMotoristaPorId(IdMotorista idMotorista);
    void deleteById(IdAgendamento idAgendamento);
    List<Agendamento> findAll();
    void saveAvaliacao(IdAgendamento idAgendamento, Avaliacao avaliacao);
}
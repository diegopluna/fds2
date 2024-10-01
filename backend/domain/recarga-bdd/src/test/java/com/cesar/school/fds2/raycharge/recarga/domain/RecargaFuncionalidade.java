package com.cesar.school.fds2.raycharge.recarga.domain;

import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.AgendamentoRepositorio;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.ServicoAgendamento;
import com.cesar.school.fds2.raycharge.infra.persistence.memory.Repository;

public class RecargaFuncionalidade {

    private AgendamentoRepositorio agendamentoRepositorio;
    private ServicoAgendamento servicoAgendamento;
      
    public RecargaFuncionalidade() {
        this.agendamentoRepositorio = new Repository();
        this.servicoAgendamento = new ServicoAgendamento(agendamentoRepositorio);
    }
}

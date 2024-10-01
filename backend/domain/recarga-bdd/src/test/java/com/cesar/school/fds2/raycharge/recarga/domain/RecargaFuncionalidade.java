package com.cesar.school.fds2.raycharge.recarga.domain;

import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.EstacaoDeRecargaRepositorio;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.MotoristaRepositorio;
import com.cesar.school.fds2.raycharge.notificacao.domain.notificacao.NotificacaoRepositorio;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.AgendamentoRepositorio;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.ServicoAgendamento;
import com.cesar.school.fds2.raycharge.infra.persistence.memory.Repository;

public class RecargaFuncionalidade {

    private AgendamentoRepositorio agendamentoRepositorio;
    private NotificacaoRepositorio notificacaoRepositorio;
    private EstacaoDeRecargaRepositorio estacaoDeRecargaRepositorio;
    private MotoristaRepositorio motoristaRepositorio;
    private ServicoAgendamento servicoAgendamento;
      
    public RecargaFuncionalidade() {
        this.agendamentoRepositorio = new Repository();
        this.notificacaoRepositorio = new Repository();
        this.estacaoDeRecargaRepositorio = new Repository();
        this.motoristaRepositorio = new Repository();

        this.servicoAgendamento = new ServicoAgendamento(
            this.agendamentoRepositorio,
            this.notificacaoRepositorio,
            this.estacaoDeRecargaRepositorio,
            this.motoristaRepositorio
        );
    }
}

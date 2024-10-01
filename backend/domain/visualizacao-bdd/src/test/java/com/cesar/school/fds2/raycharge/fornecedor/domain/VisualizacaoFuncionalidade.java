package com.cesar.school.fds2.raycharge.recarga.domain;

import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.EstacaoDeRecargaRepositorio;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.MotoristaRepositorio;
import com.cesar.school.fds2.raycharge.notificacao.domain.notificacao.NotificacaoRepositorio;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.AgendamentoRepositorio;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.ServicoAgendamento;
import com.cesar.school.fds2.raycharge.infra.persistence.memory.Repository;

public class VisualizacaoFuncionalidade {

    private EstacaoDeRecargaRepositorio estacaoDeRecargaRepositorio;
    private List<EstacaoDeRecarga> estacoesRetornadas;
    private List<EstacaoDeRecarga> estacoesCadastradas;
      
    public VisualizacaoFuncionalidade() {
        this.estacaoDeRecargaRepositorio = new Repository();
        this.estacoesRetornadas = new Repository();
        this.estacoesCadastradas = new Repository();

        this.estacaoDeRecargaRepositorio = new EstacaoDeRecargaRepositorio(
            this.estacoesRetornadas,
            this.estacoesCadastradas
        );

    }
}

package com.cesar.school.fds2.raycharge.application.recarga.agendamento;

import java.util.Objects;

public class AgendamentoServicoAplicacao {
    private AgendamentoRepositorioAplicacao repositorio;

    public AgendamentoServicoAplicacao(AgendamentoRepositorioAplicacao repositorio) {
        Objects.requireNonNull(repositorio, "O repositório não pode ser nulo");

        this.repositorio = repositorio;
    }

    // Definir Metodos do Servico
}

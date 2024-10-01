package com.cesar.school.fds2.raycharge.application.notificacao.notificacao;

import java.util.Objects;

public class NotificacaoServicoAplicacao {
    private NotificacaoRepositorioAplicacao repositorio;

    public NotificacaoServicoAplicacao(NotificacaoRepositorioAplicacao repositorio) {
        Objects.requireNonNull(repositorio, "O repositório não pode ser nulo");

        this.repositorio = repositorio;
    }

    // Definir Metodos do Servico
}

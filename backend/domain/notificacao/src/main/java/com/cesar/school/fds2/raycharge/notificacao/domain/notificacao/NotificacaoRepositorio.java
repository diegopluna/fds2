package com.cesar.school.fds2.raycharge.notificacao.domain.notificacao;

import java.util.List;
import java.util.Optional;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;
import com.cesar.school.fds2.raycharge.notificacao.domain.notificacao.IdNotificacao;

public interface NotificacaoRepositorio {
    void saveNotificacao(Notificacao notificacao);
    Optional<Notificacao> findById(IdNotificacao id);
    List<Notificacao> findByDestinatario(IdUsuario idUsuario);
    void updateNotificacao(Notificacao notificacao);
    void deleteNotificacao(IdNotificacao id);
}

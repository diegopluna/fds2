package com.cesar.school.fds2.raycharge.notificacao.domain.notificacao;

import java.util.List;
import java.util.Optional;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;

public interface NotificacaoRepositorio {
    void saveNotificacao(Notificacao notificacao);
    Optional<Notificacao> findNotificacaoById(IdNotificacao id);
    List<Notificacao> findByDestinatario(IdUsuario idUsuario);
    void updateNotificacao(Notificacao notificacao);
    void deleteNotificacao(IdNotificacao id);
}

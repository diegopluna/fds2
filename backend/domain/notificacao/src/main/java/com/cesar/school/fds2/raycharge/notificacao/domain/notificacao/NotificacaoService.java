package com.cesar.school.fds2.raycharge.notificacao.domain.notificacao;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;
import com.cesar.school.fds2.raycharge.notificacao.domain.notificacao.IdNotificacao;

public class NotificacaoService {
    private final NotificacaoRepositorio notificacaoRepositorio;

    public NotificacaoService(NotificacaoRepositorio notificacaoRepositorio) {
        this.notificacaoRepositorio = Objects.requireNonNull(notificacaoRepositorio, "O repositório de notificações não pode ser nulo");
    }

    public int enviarNotificacao(IdNotificacao id, List<IdUsuario> destinatarios, IdUsuario origem, String mensagem) {
        Notificacao notificacao = new Notificacao(id, destinatarios, origem, mensagem);
        notificacaoRepositorio.saveNotificacao(notificacao);
        return notificacao.getId().getId();
    }

    public Notificacao buscarNotificacaoPorId(IdNotificacao id) {
        return notificacaoRepositorio.findById(id).orElse(null);
    }

    public List<Notificacao> buscarNotificacoesPorDestinatario(IdUsuario idUsuario) {
        return notificacaoRepositorio.findByDestinatario(idUsuario);
    }

    public void atualizarNotificacao(Notificacao notificacao) {
        notificacaoRepositorio.updateNotificacao(notificacao);
    }

    public void deletarNotificacao(IdNotificacao id) {
        notificacaoRepositorio.deleteNotificacao(id);
    }

    public int alterarMensagemNotificacao(IdNotificacao id, String novaMensagem) {
        Optional<Notificacao> notificacaoOpt = notificacaoRepositorio.findById(id);
        if (notificacaoOpt.isPresent()) {
            Notificacao notificacao = notificacaoOpt.get();
            notificacao.setMensagem(novaMensagem);
            notificacaoRepositorio.updateNotificacao(notificacao);
            return 1;
        }
        return -1;
    }
}

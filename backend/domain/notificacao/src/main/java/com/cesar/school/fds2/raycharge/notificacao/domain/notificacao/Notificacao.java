package com.cesar.school.fds2.raycharge.notificacao.domain.notificacao;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.Validate.notBlank;
import static org.apache.commons.lang3.Validate.notNull;
import org.jmolecules.ddd.types.AggregateRoot;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;

public class Notificacao implements Cloneable, AggregateRoot<Notificacao, IdNotificacao> {

    private final IdNotificacao id;
    private List<IdUsuario> destinatarios;
    private IdUsuario origem; // Pode ser nulo
    private String mensagem;

    // com origem
    public Notificacao(IdNotificacao id, List<IdUsuario> destinatarios, IdUsuario origem, String mensagem) {
        this.id = new IdNotificacao();
        this.destinatarios = new ArrayList<>(notNull(destinatarios, "A lista de destinatários não pode ser nula"));
        this.origem = origem; // Pode ser nulo
        this.mensagem = notBlank(mensagem, "A mensagem não pode ser vazia");
    }
    // sem origem
    public Notificacao(IdNotificacao id, List<IdUsuario> destinatarios, String mensagem) {
        this.id = notNull(id, "O ID da notificação não pode ser nulo");
        this.destinatarios = new ArrayList<>(notNull(destinatarios, "A lista de destinatários não pode ser nula"));
        this.mensagem = notBlank(mensagem, "A mensagem não pode ser vazia");
    }

    @Override
    public IdNotificacao getId() {
        return id;
    }

    public List<IdUsuario> getDestinatarios() {
        return new ArrayList<>(destinatarios);
    }

    public void setDestinatarios(List<IdUsuario> destinatarios) {
        this.destinatarios = new ArrayList<>(notNull(destinatarios, "A lista de destinatários não pode ser nula"));
    }

    public IdUsuario getOrigem() {
        return origem;
    }

    public void setOrigem(IdUsuario origem) {
        this.origem = origem; // Pode ser nulo
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = notBlank(mensagem, "A mensagem não pode ser vazia");
    }

    @Override
    public Notificacao clone() {
        try {
            Notificacao clone = (Notificacao) super.clone();
            clone.destinatarios = new ArrayList<>(this.destinatarios);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Erro ao clonar Notificacao", e);
        }
    }
}

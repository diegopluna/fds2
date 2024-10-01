package com.cesar.school.fds2.raycharge.recarga.domain.agendamento;

import java.util.Objects;

import org.jmolecules.ddd.types.ValueObject;

public class Avaliacao implements ValueObject{
    private final int idAvaliacao;
    private final Avaliacoes avaliacaoDada;
    private final String descricaoExperiencia;

    public Avaliacao(int idAvaliacao, Avaliacoes avaliacaoDada, String descricaoExperiencia) {
        this.idAvaliacao = Objects.requireNonNull(idAvaliacao);
        this.avaliacaoDada = Objects.requireNonNull(avaliacaoDada);
        this.descricaoExperiencia = descricaoExperiencia;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public Avaliacoes getAvaliacaoDada() {
        return avaliacaoDada;
    }

    public String getDescricaoExperiencia() {
        return descricaoExperiencia;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Avaliacao) {
            var avaliacao = (Avaliacao) obj;
        return idAvaliacao == avaliacao.idAvaliacao;
        }
        return false;
    }
  
    @Override
    public int hashCode() {
      return Integer.hashCode(idAvaliacao);
    }
  
    @Override
    public String toString() {
      return Integer.toString(idAvaliacao);
    }
}
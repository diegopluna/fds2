package com.cesar.school.fds2.raycharge.fornecedor.domain.fornecedor;

import com.cesar.school.fds2.raycharge.agendamento.domain.agendamento.IdAgendamento;
import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.IdEstacao;
import org.jmolecules.ddd.types.AggregateRoot;

import java.util.List;

public class Fornecedor implements Cloneable, AggregateRoot<Fornecedor, IdFornecedor> {
  private final IdUsuario usuarioFornecedor;
  private final IdFornecedor idFornecedor;
  private String nomeFornecedor;
  private List<IdEstacao> estacoesDeRecarga;
  private List<IdAgendamento> historicoDeUso;

  public Fornecedor(IdUsuario usuarioFornecedor, IdFornecedor idFornecedor, String nomeFornecedor, List<IdEstacao> estacoesDeRecarga, List<IdAgendamento> historicoDeUso) {
    this.usuarioFornecedor = usuarioFornecedor;
    this.idFornecedor = idFornecedor;
    this.nomeFornecedor = nomeFornecedor;
    this.estacoesDeRecarga = estacoesDeRecarga;
    this.historicoDeUso = historicoDeUso;
  }


  @Override
  public Fornecedor clone() {
    try {
      return (Fornecedor) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  public IdFornecedor getId() {
    return idFornecedor;
  }

  public String getNomeFornecedor() {
    return nomeFornecedor;
  }

  public void setNomeFornecedor(String nomeFornecedor) {
    this.nomeFornecedor = nomeFornecedor;
  }

  public List<IdEstacao> getEstacoesDeRecarga() {
    return estacoesDeRecarga;
  }

  public void setEstacoesDeRecarga(List<IdEstacao> estacoesDeRecarga) {
    this.estacoesDeRecarga = estacoesDeRecarga;
  }

  public List<IdAgendamento> getHistoricoDeUso() {
    return historicoDeUso;
  }

  public void setHistoricoDeUso(List<IdAgendamento> historicoDeUso) {
    this.historicoDeUso = historicoDeUso;
  }

  public IdUsuario getUsuarioFornecedor() {
    return usuarioFornecedor;
  }
}

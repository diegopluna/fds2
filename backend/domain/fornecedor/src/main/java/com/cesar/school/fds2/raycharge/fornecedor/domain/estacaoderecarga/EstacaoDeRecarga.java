package com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga;

import java.util.List;

import org.jmolecules.ddd.types.AggregateRoot;

import com.cesar.school.fds2.raycharge.agendamento.domain.agendamento.IdAgendamento;
import com.cesar.school.fds2.raycharge.fornecedor.domain.fornecedor.IdFornecedor;

public class EstacaoDeRecarga implements Cloneable, AggregateRoot<EstacaoDeRecarga, IdEstacao> {
  private final IdEstacao idEstacao;
  private final IdFornecedor idFornecedor;
  private String nomeDaEstacao;
  private int quantidadeDeCarregadores;
  private HorarioDisponivel horarioFuncionamento;
  private Endereco enderecoEstacao;
  private StatusEstacao statusEstacao;
  private int precoMinimo;
  private int precoPKwH;
  private int tempoPorAgendamento;
  private List<HorarioDisponivel> horarioDisponiveis;
  private List<IdAgendamento> historicoDeUso;


  public EstacaoDeRecarga(IdEstacao idEstacao, IdFornecedor idFornecedor, String nomeDaEstacao, int quantidadeDeCarregadores, HorarioDisponivel horarioFuncionamento, Endereco enderecoEstacao, StatusEstacao statusEstacao, int precoMinimo, int precoPKwH, int tempoPorAgendamento, List<HorarioDisponivel> horarioDisponiveis, List<IdAgendamento> historicoDeUso) {
    this.idEstacao = idEstacao;
    this.idFornecedor = idFornecedor;
    this.nomeDaEstacao = nomeDaEstacao;
    this.quantidadeDeCarregadores = quantidadeDeCarregadores;
    this.horarioFuncionamento = horarioFuncionamento;
    this.enderecoEstacao = enderecoEstacao;
    this.statusEstacao = statusEstacao;
    this.precoMinimo = precoMinimo;
    this.precoPKwH = precoPKwH;
    this.tempoPorAgendamento = tempoPorAgendamento;
    this.horarioDisponiveis = horarioDisponiveis;
    this.historicoDeUso = historicoDeUso;
  }

  @Override
  public IdEstacao getId() {
    return idEstacao;
  }

  public IdFornecedor getIdFornecedor() {
    return idFornecedor;
  }

  public String getNomeDaEstacao() {
    return nomeDaEstacao;
  }

  public void setNomeDaEstacao(String nomeDaEstacao) {
    this.nomeDaEstacao = nomeDaEstacao;
  }

  public int getQuantidadeDeCarregadores() {
    return quantidadeDeCarregadores;
  }

  public void setQuantidadeDeCarregadores(int quantidadeDeCarregadores) {
    this.quantidadeDeCarregadores = quantidadeDeCarregadores;
  }

  public HorarioDisponivel getHorarioFuncionamento() {
    return horarioFuncionamento;
  }

  public void setHorarioFuncionamento(HorarioDisponivel horarioFuncionamento) {
    this.horarioFuncionamento = horarioFuncionamento;
  }

  public Endereco getEnderecoEstacao() {
    return enderecoEstacao;
  }

  public void setEnderecoEstacao(Endereco enderecoEstacao) {
    this.enderecoEstacao = enderecoEstacao;
  }

  public StatusEstacao getStatusEstacao() {
    return statusEstacao;
  }

  public void setStatusEstacao(StatusEstacao statusEstacao) {
    this.statusEstacao = statusEstacao;
  }

  public int getPrecoMinimo() {
    return precoMinimo;
  }

  public void setPrecoMinimo(int precoMinimo) {
    this.precoMinimo = precoMinimo;
  }

  public int getPrecoPKwH() {
    return precoPKwH;
  }

  public void setPrecoPKwH(int precoPKwH) {
    this.precoPKwH = precoPKwH;
  }

  public int getTempoPorAgendamento() {
    return tempoPorAgendamento;
  }

  public void setTempoPorAgendamento(int tempoPorAgendamento) {
    this.tempoPorAgendamento = tempoPorAgendamento;
  }

  public List<HorarioDisponivel> getHorarioDisponiveis() {
    return horarioDisponiveis;
  }

  public void setHorarioDisponiveis(List<HorarioDisponivel> horarioDisponiveis) {
    this.horarioDisponiveis = horarioDisponiveis;
  }

  public List<IdAgendamento> getHistoricoDeUso() {
    return historicoDeUso;
  }

  public void setHistoricoDeUso(List<IdAgendamento> historicoDeUso) {
    this.historicoDeUso = historicoDeUso;
  }

  @Override
  public EstacaoDeRecarga clone() {
    try {
      return (EstacaoDeRecarga) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}

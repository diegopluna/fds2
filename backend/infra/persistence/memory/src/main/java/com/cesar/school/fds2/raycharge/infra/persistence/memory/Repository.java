package com.cesar.school.fds2.raycharge.infra.persistence.memory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.EstacaoDeRecarga;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.EstacaoDeRecargaRepositorio;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.IdEstacao;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.Avaliacao;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.IdAgendamento;
import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;
import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.Usuario;
import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.UsuarioRepositorio;
import com.cesar.school.fds2.raycharge.fornecedor.domain.fornecedor.Fornecedor;
import com.cesar.school.fds2.raycharge.fornecedor.domain.fornecedor.FornecedorRepositorio;
import com.cesar.school.fds2.raycharge.fornecedor.domain.fornecedor.IdFornecedor;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.IdMotorista;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.Motorista;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.MotoristaRepositorio;
import com.cesar.school.fds2.raycharge.motorista.domain.veiculo.IdVeiculo;
import com.cesar.school.fds2.raycharge.motorista.domain.veiculo.Veiculo;
import com.cesar.school.fds2.raycharge.motorista.domain.veiculo.VeiculoRepositorio;
import com.cesar.school.fds2.raycharge.notificacao.domain.notificacao.IdNotificacao;
import com.cesar.school.fds2.raycharge.notificacao.domain.notificacao.Notificacao;
import com.cesar.school.fds2.raycharge.notificacao.domain.notificacao.NotificacaoRepositorio;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.Agendamento;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.AgendamentoRepositorio;

public class Repository implements UsuarioRepositorio, FornecedorRepositorio, MotoristaRepositorio, VeiculoRepositorio, AgendamentoRepositorio, NotificacaoRepositorio, EstacaoDeRecargaRepositorio {
  /*-----------------------------------------------------------------------*/
  private Map<IdUsuario, Usuario> usuarios = new HashMap<>();

  @Override
  public void saveUsuario(Usuario usuario) {
    usuarios.put(usuario.getId(), usuario);
  }

  @Override
  public Optional<Usuario> findByLogin(String login) {
    return usuarios.values().stream()
        .filter(usuario -> usuario.getLogin().equals(login))
        .findFirst();
  }

  /*-----------------------------------------------------------------------*/

  private Map<IdFornecedor, Fornecedor> fornecedores = new HashMap<>();

  @Override
  public Optional<Fornecedor> findByUsuarioFornecedor(IdUsuario usuarioFornecedor) {
    return fornecedores.values().stream()
        .filter(fornecedor -> fornecedor.getUsuarioFornecedor().equals(usuarioFornecedor))
        .findFirst();
  }
  @Override
  public void deleteFornecedor(IdUsuario usuarioFornecedor) {
    fornecedores.values().removeIf(fornecedor -> fornecedor.getUsuarioFornecedor().equals(usuarioFornecedor));
    usuarios.values().removeIf(usuario -> usuario.getId().equals(usuarioFornecedor));
  }

  @Override
  public void updateFornecedor(Fornecedor fornecedor) {
    fornecedores.put(fornecedor.getId(), fornecedor);
  }

  /*-----------------------------------------------------------------------*/

  private Map<IdMotorista, Motorista> motoristas = new HashMap<>();

  @Override
  public void saveMotorista(Motorista motorista) {
    motoristas.put(motorista.getId(), motorista);
  }

  public Optional<Motorista> findById(IdMotorista idMotorista) {
    return Optional.ofNullable(motoristas.get(idMotorista));
  }

  @Override
  public Optional<Motorista> findByUsuarioMotorista(IdUsuario usuarioMotorista) {
    return motoristas.values().stream()
        .filter(motorista -> motorista.getUsuarioMotorista().equals(usuarioMotorista))
        .findFirst();
  }

  @Override
  public Optional<Motorista> updateMotorista(Motorista motorista) {
    return Optional.ofNullable(motoristas.put(motorista.getId(), motorista));
  }

  @Override
  public Optional<Motorista> deleteMotorista(IdMotorista idMotorista) {
    return Optional.ofNullable(motoristas.remove(idMotorista));
  }

  /*-----------------------------------------------------------------------*/

  private Map<IdVeiculo, Veiculo> veiculos = new HashMap<>();

  @Override
  public void saveVeiculo(Veiculo veiculo) {
    veiculos.put(veiculo.getId(), veiculo);
  }

  @Override
  public void deleteVeiculo(IdVeiculo idVeiculo) {
    veiculos.remove(idVeiculo);
  }

  @Override
  public Veiculo buscarPorId(IdVeiculo idVeiculo) {
    return veiculos.get(idVeiculo);
  }

  @Override
  public List<Veiculo> listarTodos() {
    return List.copyOf(veiculos.values());
  }

  /*-----------------------------------------------------------------------*/

  private Map<IdAgendamento, Agendamento> agendamentos = new HashMap<>();

  @Override
  public void saveAgendamento(Agendamento agendamento) {
    agendamentos.put(agendamento.getId(), agendamento);
  }

  @Override
  public Optional<Agendamento> findById(IdAgendamento idAgendamento) {
    return Optional.ofNullable(agendamentos.get(idAgendamento));
  }

  @Override
  public List<Agendamento> buscarMotoristaPorId(IdMotorista idMotorista) {
    return agendamentos.values().stream()
        .filter(agendamento -> agendamento.getMotorista().equals(idMotorista))
        .toList();
  }

  @Override
  public void deleteById(IdAgendamento idAgendamento) {
    agendamentos.remove(idAgendamento);
  }

  @Override
  public List<Agendamento> findAll() {
    return List.copyOf(agendamentos.values());
  }

  @Override
  public void saveAvaliacao(IdAgendamento idAgendamento, Avaliacao avaliacao) {
    Agendamento agendamento = agendamentos.get(idAgendamento);
    agendamento.getAvaliacao().add(avaliacao.getAvaliacaoDada());  }

  /*-----------------------------------------------------------------------*/

  private Map<IdNotificacao, Notificacao> notificacoes = new HashMap<>();

  public Optional<Notificacao> findById(IdNotificacao id) {
    return Optional.ofNullable(notificacoes.get(id));
  }

  @Override
  public void deleteNotificacao(IdNotificacao id) {
    notificacoes.remove(id);
  }

  @Override
  public void saveNotificacao(Notificacao notificacao) {
    notificacoes.put(notificacao.getId(), notificacao);
  }

  @Override
  public void updateNotificacao(Notificacao notificacao) {
    notificacoes.put(notificacao.getId(), notificacao);
  }

  @Override
  public List<Notificacao> findByDestinatario(IdUsuario destinatario) {
    return notificacoes.values().stream()
        .filter(notificacao -> notificacao.getDestinatarios().contains(destinatario))
        .toList();
  }

  @Override
  public Optional<Motorista> findMotoristaById(IdMotorista idMotorista) {
    return Optional.ofNullable(motoristas.get(idMotorista));
  }

  @Override
  public Optional<Notificacao> findNotificacaoById(IdNotificacao id) {
    return Optional.ofNullable(notificacoes.get(id));
  }

  /*-----------------------------------------------------------------------*/

  private Map<IdEstacao, EstacaoDeRecarga> estacoes = new HashMap<>();

  @Override
  public EstacaoDeRecarga getEstacaoById(IdEstacao idEstacao) {
    return estacoes.get(idEstacao);
  }

  @Override
  public void salvarEstacao(EstacaoDeRecarga estacao) {
    estacoes.put(estacao.getId(), estacao);
  }

  @Override
  public void deletarEstacao(IdEstacao idEstacao) {
    estacoes.remove(idEstacao);
  }

  @Override
  public List<EstacaoDeRecarga> listarEstacoes() {
    return List.copyOf(estacoes.values());
  }
  /*-----------------------------------------------------------------------*/
}

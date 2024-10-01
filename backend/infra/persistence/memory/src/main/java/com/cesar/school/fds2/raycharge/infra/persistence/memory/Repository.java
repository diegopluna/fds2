package com.cesar.school.fds2.raycharge.infra.persistence.memory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

public class Repository implements UsuarioRepositorio, FornecedorRepositorio, MotoristaRepositorio, VeiculoRepositorio, AgendamentoRepositorio, NotificacaoRepositorio {
  // Implementar metodos do repositorio aqui
  private Map<IdFornecedor, Fornecedor> fornecedores = new HashMap<>();

  /*-----------------------------------------------------------------------*/
  private Map<IdUsuario, Usuario> usuarios = new HashMap<>();

  private Map<IdMotorista, Motorista> motoristas = new HashMap<>();

  private Map<IdVeiculo, Veiculo> veiculos = new HashMap<>();

  private Map<IdAgendamento, Agendamento> agendamentos = new HashMap<>();

  @Override
  public void saveUsuario(Usuario usuario) {
    usuarios.put(usuario.getId(), usuario);
  }

  @Override
  public void saveMotorista(Motorista motorista) {
    motoristas.put(motorista.getId(), motorista);
  }

  @Override
  public void saveVeiculo(Veiculo veiculo) {
    veiculos.put(veiculo.getId(), veiculo);
  }

  //usuario
  @Override
  public Optional<Usuario> findByLogin(String login) {
    return usuarios.values().stream()
        .filter(usuario -> usuario.getLogin().equals(login))
        .findFirst();
  }

  // motorista
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

  // veiculo

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

  // Implementar metodos do repositorio aqui

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

  // agendamento
  @Override
  public void saveAgendamento(Agendamento agendamento) {
    agendamentos.put(agendamento.getId(), agendamento);
  }

  @Override
  public Agendamento findById(IdAgendamento idAgendamento) {
    return null;
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

  public Optional<Notificacao> findById(IdNotificacao id) {
    // Implementação do método findById para NotificacaoRepositorio
    return null; // Substitua por lógica real
  }

  @Override
  public void deleteNotificacao(IdNotificacao id) {
    // Implementação do método deleteNotificacao
  }

  @Override
  public void saveNotificacao(Notificacao notificacao) {
    // Implementação do método saveNotificacao
  }

  @Override
  public void updateNotificacao(Notificacao notificacao) {
    // Implementação do método updateNotificacao
  }

  @Override
  public List<Notificacao> findByDestinatario(IdUsuario destinatario) {
      // Implementação do método findByDestinatario
      return List.of(); // Substitua por lógica real
  }

    @Override
    public Optional<Motorista> findMotoristaById(IdMotorista idMotorista) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Optional<Notificacao> findNotificacaoById(IdNotificacao id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
  /*-----------------------------------------------------------------------*/
}

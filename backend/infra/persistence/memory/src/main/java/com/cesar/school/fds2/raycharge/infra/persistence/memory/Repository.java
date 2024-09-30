package com.cesar.school.fds2.raycharge.infra.persistence.memory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cesar.school.fds2.raycharge.autenticacao.domain.usuario.UsuarioRepositorio;
import com.cesar.school.fds2.raycharge.autenticacao.domain.usuario.IdUsuario;
import com.cesar.school.fds2.raycharge.autenticacao.domain.usuario.Usuario;

import com.cesar.school.fds2.raycharge.motorista.domain.motorista.MotoristaRepositorio;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.IdMotorista;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.Motorista;

import com.cesar.school.fds2.raycharge.motorista.domain.veiculo.VeiculoRepositorio;
import com.cesar.school.fds2.raycharge.motorista.domain.veiculo.IdVeiculo;
import com.cesar.school.fds2.raycharge.motorista.domain.veiculo.*;

public class Repository implements UsuarioRepositorio, MotoristaRepositorio, VeiculoRepositorio {
  private Map<IdUsuario, Usuario> usuarios = new HashMap<>();

  private Map<IdMotorista, Motorista> motoristas = new HashMap<>();

  private Map<IdVeiculo, Veiculo> veiculos = new HashMap<>();

  @Override
  public Optional<Usuario> findByLogin(String login) {
    return usuarios.values().stream()
        .filter(usuario -> usuario.getLogin().equals(login))
        .findFirst();
  }

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

  // revisar
  @Override
  public Optional<Motorista> findById(IdMotorista idMotorista) {
    return Optional.empty();
  }

  @Override
  public Optional<Motorista> findByUsuarioMotorista(IdUsuario usuarioMotorista) {
    return Optional.empty();
  }

  @Override
  public Optional<Motorista> updateMotorista(Motorista motorista) {
    return Optional.empty();
  }

  @Override
  public Optional<Motorista> deleteMotorista(IdMotorista idMotorista) {
    return Optional.empty();
  }

  // veiculo

  @Override
  public void deleteVeiculo(IdVeiculo idVeiculo) {

  }

  @Override
  public Veiculo buscarPorId(IdVeiculo idVeiculo) {
    return null;
  }

  @Override
  public List<Veiculo> listarTodos() {
    return List.of();
  }

  // Implementar metodos do repositorio aqui
}

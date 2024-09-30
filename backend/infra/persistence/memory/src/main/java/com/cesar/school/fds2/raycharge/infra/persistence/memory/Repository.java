package com.cesar.school.fds2.raycharge.infra.persistence.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.cesar.school.fds2.raycharge.autenticacao.domain.usuario.UsuarioRepositorio;
import com.cesar.school.fds2.raycharge.autenticacao.domain.usuario.IdUsuario;
import com.cesar.school.fds2.raycharge.autenticacao.domain.usuario.Usuario;

import com.cesar.school.fds2.raycharge.motorista.domain.motorista.MotoristaRepositorio;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.IdMotorista;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.Motorista;

public class Repository implements UsuarioRepositorio, MotoristaRepositorio {
  private Map<IdUsuario, Usuario> usuarios = new HashMap<>();

  private Map<IdMotorista, Motorista> motoristas = new HashMap<>();

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

  // Implementar metodos do repositorio aqui
}

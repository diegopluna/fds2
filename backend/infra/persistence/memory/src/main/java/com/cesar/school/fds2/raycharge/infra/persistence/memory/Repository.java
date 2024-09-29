package com.cesar.school.fds2.raycharge.infra.persistence.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.cesar.school.fds2.raycharge.autenticacao.domain.usuario.UsuarioRepositorio;
import com.cesar.school.fds2.raycharge.autenticacao.domain.usuario.IdUsuario;
import com.cesar.school.fds2.raycharge.autenticacao.domain.usuario.Usuario;

public class Repository implements UsuarioRepositorio {
  private Map<IdUsuario, Usuario> usuarios = new HashMap<>();

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

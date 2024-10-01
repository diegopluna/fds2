package com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao;

import java.util.Optional;

public interface UsuarioRepositorio {
  void saveUsuario(Usuario usuario);
  Optional<Usuario> findByLogin(String login);
}

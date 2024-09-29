package com.cesar.school.fds2.raycharge.autenticacao.domain.usuario;

import java.util.Optional;

public interface UsuarioRepositorio {
  //Colocar metodos do Repositorio aqui
  void saveUsuario(Usuario usuario);
  Optional<Usuario> findByLogin(String login);
}

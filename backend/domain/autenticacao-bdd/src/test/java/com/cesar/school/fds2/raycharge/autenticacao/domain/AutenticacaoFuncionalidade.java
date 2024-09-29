package com.cesar.school.fds2.raycharge.autenticacao.domain;

import com.cesar.school.fds2.raycharge.autenticacao.domain.usuario.*;
import com.cesar.school.fds2.raycharge.infra.persistence.memory.Repository;

public class AutenticacaoFuncionalidade {
  private UsuarioService usuarioService;
  private UsuarioRepositorio usuarioRepositorio;

  public AutenticacaoFuncionalidade() {
    this.usuarioRepositorio = new Repository();
    this.usuarioService = new UsuarioService(usuarioRepositorio);
  }
}

package com.cesar.school.fds2.raycharge.autenticacao.domain;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.*;
import com.cesar.school.fds2.raycharge.infra.persistence.memory.Repository;

public class AutenticacaoFuncionalidade {
  private NovosUsuarios novosUsuarios;
  private UsuarioRepositorio usuarioRepositorio;

  public AutenticacaoFuncionalidade() {
    this.usuarioRepositorio = new Repository();
    this.novosUsuarios = new NovosUsuarios(usuarioRepositorio);
  }
}

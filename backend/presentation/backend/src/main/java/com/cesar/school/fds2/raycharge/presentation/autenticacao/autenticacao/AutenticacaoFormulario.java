package com.cesar.school.fds2.raycharge.presentation.autenticacao.autenticacao;


import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.TipoUsuario;

public class AutenticacaoFormulario {
  public UsuarioDto usuario;

  public AutenticacaoFormulario(UsuarioDto usuario) {
    this.usuario = usuario;
  }

  public static class UsuarioDto {
    public String login;
    public String senha;
    public TipoUsuario tipoUsuario;
  }
}

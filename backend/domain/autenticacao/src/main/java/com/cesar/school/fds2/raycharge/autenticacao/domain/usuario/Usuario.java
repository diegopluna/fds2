package com.cesar.school.fds2.raycharge.autenticacao.domain.usuario;

import static org.apache.commons.lang3.Validate.notBlank;
import java.util.Objects;

import org.jmolecules.ddd.types.AggregateRoot;

public class Usuario implements Cloneable, AggregateRoot<Usuario, IdUsuario> {
  private final IdUsuario id;
  private String login;
  private String senha;
  private TipoUsuario tipoUsuario;

  public Usuario(IdUsuario id, String login, String senha, TipoUsuario tipoUsuario) {
      this.id = Objects.requireNonNull(id);
      this.login = notBlank(login);
      this.senha = notBlank(senha);
      this.tipoUsuario = Objects.requireNonNull(tipoUsuario);
  }

  public IdUsuario getId() {
      return id;
  }

  public String getLogin() {
      return login;
  }

  public void setLogin(String login) {
      this.login = notBlank(login);
  }

  public String getSenha() {
      return senha;
  }

  public void setSenha(String senha) {
      this.senha = notBlank(senha);
  }

  public TipoUsuario getTipoUsuario() {
      return tipoUsuario;
  }

  public void setTipoUsuario(TipoUsuario tipoUsuario) {
      this.tipoUsuario = Objects.requireNonNull(tipoUsuario);
  }

  @Override
  public Usuario clone() {
      try {
          return (Usuario) super.clone();
      } catch (CloneNotSupportedException e) {
          throw new AssertionError();
      }
  }
}

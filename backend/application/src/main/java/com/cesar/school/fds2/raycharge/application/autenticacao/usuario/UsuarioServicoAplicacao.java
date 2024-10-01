package com.cesar.school.fds2.raycharge.application.autenticacao.usuario;

import java.util.Objects;

public class UsuarioServicoAplicacao {
  private UsuarioRepositorioAplicacao repositorio;

  public UsuarioServicoAplicacao(UsuarioRepositorioAplicacao repositorio) {
		Objects.requireNonNull(repositorio, "O repositório não pode ser nulo");

		this.repositorio = repositorio;
	}

  // Definir Metodos do Servico
}

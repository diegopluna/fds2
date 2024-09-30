package com.cesar.school.fds2.raycharge.infra.persistence.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.UsuarioRepositorio;
import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;
import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.Usuario;
import com.cesar.school.fds2.raycharge.fornecedor.domain.fornecedor.Fornecedor;
import com.cesar.school.fds2.raycharge.fornecedor.domain.fornecedor.FornecedorRepositorio;
import com.cesar.school.fds2.raycharge.fornecedor.domain.fornecedor.IdFornecedor;

public class Repository implements UsuarioRepositorio, FornecedorRepositorio {
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
  private Map<IdFornecedor, Fornecedor> fornecedores = new HashMap<>();

  @Override
  public Optional<Fornecedor> findByUsuarioFornecedor(IdUsuario usuarioFornecedor) {
    return fornecedores.values().stream()
        .filter(fornecedor -> fornecedor.getUsuarioFornecedor().equals(usuarioFornecedor))
        .findFirst();
  }
  @Override
  public void deleteFornecedor(IdUsuario usuarioFornecedor) {
    fornecedores.values().removeIf(fornecedor -> fornecedor.getUsuarioFornecedor().equals(usuarioFornecedor));
    usuarios.values().removeIf(usuario -> usuario.getId().equals(usuarioFornecedor));
  }

  @Override
  public void updateFornecedor(Fornecedor fornecedor) {
    fornecedores.put(fornecedor.getId(), fornecedor);
  }
}

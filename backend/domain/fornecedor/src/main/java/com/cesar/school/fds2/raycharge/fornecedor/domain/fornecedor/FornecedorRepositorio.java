package com.cesar.school.fds2.raycharge.fornecedor.domain.fornecedor;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;

import java.util.Optional;

public interface FornecedorRepositorio {
  Optional<Fornecedor> findByUsuarioFornecedor(IdUsuario usuarioFornecedor);
  void deleteFornecedor(IdUsuario usuarioFornecedor);
  void updateFornecedor(Fornecedor fornecedor);
}

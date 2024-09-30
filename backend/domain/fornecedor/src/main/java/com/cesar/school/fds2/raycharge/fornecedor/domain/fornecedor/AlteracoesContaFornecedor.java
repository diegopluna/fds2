package com.cesar.school.fds2.raycharge.fornecedor.domain.fornecedor;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;
import org.jmolecules.ddd.annotation.Service;

import java.util.Objects;

@Service
public class AlteracoesContaFornecedor {
  private final FornecedorRepositorio fornecedorRepositorio;

  public AlteracoesContaFornecedor(FornecedorRepositorio fornecedorRepositorio) {
    Objects.requireNonNull(fornecedorRepositorio, "O repositório de fornecedores não pode ser nulo");
    this.fornecedorRepositorio = fornecedorRepositorio;
  }

  public int deletarConta(IdUsuario usuarioFornecedor) {
    if (fornecedorRepositorio.findByUsuarioFornecedor(usuarioFornecedor).isEmpty()) {
      return -1;
    }
    fornecedorRepositorio.deleteFornecedor(usuarioFornecedor);

    return 0;
  }

  public int alterarNomeFornecedor(IdUsuario usuarioFornecedor, String novoNome) {
    if (fornecedorRepositorio.findByUsuarioFornecedor(usuarioFornecedor).isEmpty()) {
      return -1;
    }
    Fornecedor fornecedor = fornecedorRepositorio.findByUsuarioFornecedor(usuarioFornecedor).get();
    fornecedor.setNomeFornecedor(novoNome);
    fornecedorRepositorio.updateFornecedor(fornecedor);
    return 0;
  }
}

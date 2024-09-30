package com.cesar.school.fds2.raycharge.fornecedor.domain.fornecedor;

import org.jmolecules.ddd.types.Identifier;
import org.jmolecules.ddd.types.ValueObject;

import static org.apache.commons.lang3.Validate.isTrue;

public class IdFornecedor implements ValueObject, Identifier {
  private final int id;

  public IdFornecedor(int id) {
    isTrue(id > 0, "O id deve ser positivo");

    this.id = id;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj instanceof IdFornecedor) {
      var idFornecedor = (IdFornecedor) obj;
      return id == idFornecedor.id;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Integer.hashCode(id);
  }

  @Override
  public String toString() {
    return Integer.toString(id);
  }
}

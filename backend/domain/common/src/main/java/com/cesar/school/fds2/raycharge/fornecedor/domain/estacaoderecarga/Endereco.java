package com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga;

import org.jmolecules.ddd.types.ValueObject;

public class Endereco implements ValueObject {
  private final String cep;
  private final String rua;
  private final String bairro;
  private final String cidade;
  private final int numero;

  public Endereco(String cep, String rua, String bairro, String cidade, int numero) {
    this.cep = cep;
    this.rua = rua;
    this.bairro = bairro;
    this.cidade = cidade;
    this.numero = numero;
  }

  public String getCep() {
    return cep;
  }

  public String getRua() {
    return rua;
  }

  public String getBairro() {
    return bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public int getNumero() {
    return numero;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj instanceof Endereco) {
      var endereco = (Endereco) obj;
      return cep.equals(endereco.cep) && rua.equals(endereco.rua) && bairro.equals(endereco.bairro) && cidade.equals(endereco.cidade) && numero == endereco.numero;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return cep.hashCode() + rua.hashCode() + bairro.hashCode() + cidade.hashCode() + Integer.hashCode(numero);
  }

  @Override
  public String toString() {
    return cep + ", " + rua + ", " + bairro + ", " + cidade + ", " + numero;
  }

}

package com.cesar.school.fds2.raycharge.application.fornecedor.fornecedor;

import java.util.Objects;

public class FornecedorServicoAplicacao {
    private FornecedorRepositorioAplicacao repositorio;

    public FornecedorServicoAplicacao(FornecedorRepositorioAplicacao repositorio) {
        Objects.requireNonNull(repositorio, "O repositório não pode ser nulo");

        this.repositorio = repositorio;
    }

    // Definir Metodos do Servico
}

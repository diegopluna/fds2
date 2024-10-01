package com.cesar.school.fds2.raycharge.application.fornecedor.estacaoDeRecarga;

import java.util.Objects;

public class EstacaoDeRecargaServicoAplicacao {

    private EstacaoDeRecargaRepositorioAplicacao repositorio;

    public EstacaoDeRecargaServicoAplicacao(EstacaoDeRecargaRepositorioAplicacao repositorio) {
        Objects.requireNonNull(repositorio, "O repositório não pode ser nulo");

        this.repositorio = repositorio;
    }

    // Definir Metodos do Servico
}

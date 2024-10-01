package com.cesar.school.fds2.raycharge.application.motorista.veiculo;

import java.util.Objects;

public class VeiculoServicoAplicacao {
    private VeiculoRepositorioAplicacao repositorio;

    public VeiculoServicoAplicacao(VeiculoRepositorioAplicacao repositorio) {
        Objects.requireNonNull(repositorio, "O repositório não pode ser nulo");

        this.repositorio = repositorio;
    }

    // Definir Metodos do Servico
}

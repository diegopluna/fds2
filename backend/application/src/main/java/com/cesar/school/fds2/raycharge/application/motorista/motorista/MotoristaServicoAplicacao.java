package com.cesar.school.fds2.raycharge.application.motorista.motorista;

import java.util.Objects;

public class MotoristaServicoAplicacao {
    private MotoristaRepositorioAplicacao repositorio;

    public MotoristaServicoAplicacao(MotoristaRepositorioAplicacao repositorio) {
        Objects.requireNonNull(repositorio, "O repositório não pode ser nulo");

        this.repositorio = repositorio;
    }

    // Definir Metodos do Servico
}

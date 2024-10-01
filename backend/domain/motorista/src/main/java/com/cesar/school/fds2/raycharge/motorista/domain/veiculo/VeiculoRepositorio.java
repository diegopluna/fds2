package com.cesar.school.fds2.raycharge.motorista.domain.veiculo;

import java.util.List;
public interface VeiculoRepositorio {
    void saveVeiculo(Veiculo veiculo);
    void deleteVeiculo(IdVeiculo idVeiculo);
    Veiculo buscarPorId(IdVeiculo idVeiculo);
    List<Veiculo> listarTodos();
}

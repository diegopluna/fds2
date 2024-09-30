package com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga;

import java.util.List;

public interface EstacaoDeRecargaRepositorio {
    EstacaoDeRecarga getEstacaoById(IdEstacao idEstacao);
    void salvarEstacao(EstacaoDeRecarga estacao);
    void deletarEstacao(IdEstacao idEstacao);
    List<EstacaoDeRecarga> listarEstacoes();
}

package com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.jmolecules.ddd.annotation.Service;

@Service
public class EstacaoDeRecargaService {
    private EstacaoDeRecargaRepositorio estacaoRepositorio;

    public EstacaoDeRecargaService(EstacaoDeRecargaRepositorio estacaoRepositorio) {
    Objects.requireNonNull(estacaoRepositorio, "O repositório de estações de recarga não pode ser nulo");
    this.estacaoRepositorio = estacaoRepositorio;
  }

    public EstacaoDeRecarga adicionarEstacao(EstacaoDeRecarga estacao) {
        EstacaoDeRecarga novaEstacao = new EstacaoDeRecarga(estacao.getId(), estacao.getIdFornecedor(), estacao.getNomeDaEstacao(), estacao.getQuantidadeDeCarregadores(), estacao.getHorarioFuncionamento(), estacao.getEnderecoEstacao(), estacao.getStatusEstacao(), estacao.getPrecoMinimo(), estacao.getPrecoPKwH(), estacao.getDistancia(), estacao.getTempoPorAgendamento(), estacao.getHorarioDisponiveis(), estacao.getHistoricoDeUso());
        estacaoRepositorio.salvarEstacao(novaEstacao);
        return novaEstacao;
    }

    public Optional<EstacaoDeRecarga> alterarQuantidadeCarregadores(IdEstacao id, int novaQuantidade) {
        EstacaoDeRecarga estacao = estacaoRepositorio.getEstacaoById(id);

        if (estacao != null)
        {
            estacao.setQuantidadeDeCarregadores(novaQuantidade);
            estacaoRepositorio.salvarEstacao(estacao);
        }
        return Optional.ofNullable(estacao);
    }

    public Optional<EstacaoDeRecarga> alterarHorarioFuncionamento(IdEstacao id, HorarioDisponivel novoHorario) {
        EstacaoDeRecarga estacao = estacaoRepositorio.getEstacaoById(id);
        
        if (estacao != null)
        {
            estacao.setHorarioFuncionamento(novoHorario);
            estacaoRepositorio.salvarEstacao(estacao);
        }
        return Optional.ofNullable(estacao);
    }

    public Optional<EstacaoDeRecarga> alterarNomeEstacao(IdEstacao id, String novoNome) {
        EstacaoDeRecarga estacao = estacaoRepositorio.getEstacaoById(id);

        if (estacao != null)
        {
            estacao.setNomeDaEstacao(novoNome);
            estacaoRepositorio.salvarEstacao(estacao);
        }
        return Optional.ofNullable(estacao);
    }

    public Optional<EstacaoDeRecarga> alterarPrecoMinimo(IdEstacao id, int novoPreco) {
        EstacaoDeRecarga estacao = estacaoRepositorio.getEstacaoById(id);
       
        if (estacao != null)
        {
            estacao.setPrecoMinimo(novoPreco);
            estacaoRepositorio.salvarEstacao(estacao);
        }
        return Optional.ofNullable(estacao);
    }

    public Optional<EstacaoDeRecarga> alterarPrecoPKwH(IdEstacao id, int novoPreco) {
        EstacaoDeRecarga estacao = estacaoRepositorio.getEstacaoById(id);
        
        if (estacao != null)
        {
            estacao.setPrecoPKwH(novoPreco);
            estacaoRepositorio.salvarEstacao(estacao);
        }
        return Optional.ofNullable(estacao);
    }

    public Optional<EstacaoDeRecarga> alterarTempoPorAgendamento(IdEstacao id, int novoTempo) {
        EstacaoDeRecarga estacao = estacaoRepositorio.getEstacaoById(id);

        if (estacao != null)
        {
            estacao.setTempoPorAgendamento(novoTempo);
            estacaoRepositorio.salvarEstacao(estacao);
        }
        return Optional.ofNullable(estacao);
    }

    public void deletarEstacao(IdEstacao id) {
        // falta implementar a logica
        estacaoRepositorio.deletarEstacao(id);
    }

    public List<EstacaoDeRecarga> listarEstacoes() {
        return estacaoRepositorio.listarEstacoes();
    }
}

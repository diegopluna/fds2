package com.cesar.school.fds2.raycharge.motorista.domain.veiculo;

import java.util.Objects;
import java.util.Random;

import org.jmolecules.ddd.annotation.Service;

import com.cesar.school.fds2.raycharge.motorista.domain.motorista.IdMotorista;

@Service
public class VeiculoService {
    private final VeiculoRepositorio veiculoRepositorio;

    public VeiculoService(VeiculoRepositorio veiculoRepositorio) {
        Objects.requireNonNull(veiculoRepositorio, "O repositório de veículos não pode ser nulo");
        this.veiculoRepositorio = veiculoRepositorio;
    }

    public int adicionarVeiculo(IdMotorista motorista, String placaVeiculo, String nomeVeiculo) {
        // revisar kk
        Random random = new Random();
        int valorId = random.nextInt();
        IdVeiculo idVeiculo = new IdVeiculo(valorId);
        Veiculo veiculo = new Veiculo(motorista, nomeVeiculo, idVeiculo, placaVeiculo);
        veiculoRepositorio.saveVeiculo(veiculo);
        return 1; // Retornar um código de sucesso
    }

    public int deletarVeiculo(IdVeiculo idVeiculo) {
        veiculoRepositorio.deleteVeiculo(idVeiculo);
        return 1; // Retornar um código de sucesso
    }

    public IdVeiculo alterarNomeVeiculo(IdVeiculo idVeiculo, String novoNome) {
        Veiculo veiculo = veiculoRepositorio.buscarPorId(idVeiculo);
        if (veiculo != null) {
            veiculo.setNomeVeiculo(novoNome);
            return veiculo.getId(); // Retorna o ID do veiculo atualizado
        }
        return null; // Retorna nulo se veiculo não existe
    }

    public int alterarPlacaVeiculo(IdVeiculo idVeiculo, String novaPlaca) {
        Veiculo veiculo = veiculoRepositorio.buscarPorId(idVeiculo);
        if (veiculo != null) {
            veiculo.setPlacaVeiculo(novaPlaca);
            veiculoRepositorio.saveVeiculo(veiculo);
            return 1; // Retornar um código de sucesso
        }
        return 0; // Retornar um código de erro
    }
}

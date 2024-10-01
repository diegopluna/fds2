package com.cesar.school.fds2.raycharge.motorista.domain.motorista;

import java.util.List; 
import java.util.Objects;

import com.cesar.school.fds2.raycharge.agendamento.domain.agendamento.IdAgendamento;
import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;
import com.cesar.school.fds2.raycharge.motorista.domain.veiculo.IdVeiculo;

public class MotoristaService {
    private final MotoristaRepositorio motoristaRepositorio;

    public MotoristaService(MotoristaRepositorio motoristaRepositorio) {
        Objects.requireNonNull(motoristaRepositorio, "O repositório de motoristas não pode ser nulo");
        this.motoristaRepositorio = motoristaRepositorio;
    }
    public int criarMotorista(IdUsuario usuarioMotorista, IdMotorista idMotorista, String nomeMotorista, List<IdVeiculo> veiculos, List<IdAgendamento> historicoDeUso) {
        Motorista novoMotorista = new Motorista(usuarioMotorista, idMotorista, nomeMotorista, veiculos, historicoDeUso);
        motoristaRepositorio.saveMotorista(novoMotorista);
        return novoMotorista.getIdMotorista().getId();
    }

    public Motorista buscarMotoristaPorId(IdMotorista idMotorista) {
        return motoristaRepositorio.findMotoristaById(idMotorista).orElse(null);
    }

    public void atualizarMotorista(Motorista motorista) {
        motoristaRepositorio.updateMotorista(motorista);
    }

    public void deletarMotorista(IdMotorista idMotorista) {
        motoristaRepositorio.deleteMotorista(idMotorista);
    }

    public int deletarConta(IdUsuario usuarioMotorista) {
        Motorista motorista = motoristaRepositorio.findByUsuarioMotorista(usuarioMotorista).orElse(null);
        if (motorista != null) {
            motoristaRepositorio.deleteMotorista(motorista.getIdMotorista());
            return 1;
        }
        return -1;
    }

    public int alterarNomeMotorista(IdMotorista idMotorista, String novoNome) {
        Motorista motorista = motoristaRepositorio.findMotoristaById(idMotorista).orElse(null);
        if (motorista != null) {
            motorista.setNomeMotorista(novoNome);
            motoristaRepositorio.updateMotorista(motorista);
            return 1;
        }
        return -1;
    }
}

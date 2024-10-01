package com.cesar.school.fds2.raycharge.motorista.domain.veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.apache.commons.lang3.Validate.notBlank;
import org.jmolecules.ddd.types.AggregateRoot;

import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.IdAgendamento;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.IdMotorista;

public class Veiculo implements Cloneable, AggregateRoot<Veiculo, IdVeiculo> {

    private IdMotorista motorista;
    private String nomeVeiculo;
    private IdVeiculo idVeiculo;
    private String placaVeiculo;
    private List<IdAgendamento> historicoDeUso; // idAgendamento

    public Veiculo(IdMotorista motorista, String nomeVeiculo, IdVeiculo idVeiculo, String placaVeiculo) {
        this.motorista = Objects.requireNonNull(motorista);
        this.nomeVeiculo = notBlank(nomeVeiculo);
        this.idVeiculo = Objects.requireNonNull(idVeiculo);
        this.placaVeiculo = notBlank(placaVeiculo);
        this.historicoDeUso = new ArrayList<>(historicoDeUso);
    }

    public IdMotorista getMotorista() {
        return motorista;
    }

    public void setMotorista(IdMotorista motorista) {
        this.motorista = Objects.requireNonNull(motorista);
    }

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = notBlank(nomeVeiculo);
    }

    public IdVeiculo getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(IdVeiculo idVeiculo) {
        this.idVeiculo = Objects.requireNonNull(idVeiculo);
        // revisar
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = notBlank(placaVeiculo);
    }

    public List<IdAgendamento> getHistoricoDeUso() {
        return new ArrayList<>(historicoDeUso);
    }

    @Override
    public IdVeiculo getId() {
        return null;
    }

    @Override
    public Veiculo clone() {
        try {
            Veiculo clone = (Veiculo) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

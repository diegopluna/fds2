package com.cesar.school.fds2.raycharge.recarga.domain.agendamento;

import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.HorarioDisponivel;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.IdEstacao;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.IdMotorista;
import com.cesar.school.fds2.raycharge.motorista.domain.veiculo.IdVeiculo;
import org.jmolecules.ddd.types.AggregateRoot;

import java.util.List;

public class Agendamento implements Cloneable, AggregateRoot<Agendamento, IdAgendamento> {
    private final IdAgendamento idAgendamento;
    private int codigoLiberacaoCarregador;
    private HorarioDisponivel horarioAgendamento;
    private StatusAgendamento statusAgendamento;
    private float valorTotalRecarga;
    private float valorMinimo;
    private List<Avaliacoes> avaliacao;
    private IdEstacao estacaoDeRecarga;
    private IdMotorista motorista;
    private IdVeiculo veiculo;

    public Agendamento(IdAgendamento idAgendamento, int codigoLiberacaoCarregador, HorarioDisponivel horarioAgendamento,
                       StatusAgendamento statusAgendamento, int valorTotalRecarga, List<Avaliacoes> avaliacao,
                       IdEstacao estacaoDeRecarga, IdMotorista motorista, IdVeiculo veiculo) {
        this.idAgendamento = idAgendamento;
        this.codigoLiberacaoCarregador = codigoLiberacaoCarregador;
        this.horarioAgendamento = horarioAgendamento;
        this.statusAgendamento = statusAgendamento;
        this.valorTotalRecarga = valorTotalRecarga;
        this.avaliacao = avaliacao;
        this.estacaoDeRecarga = estacaoDeRecarga;
        this.motorista = motorista;
        this.veiculo = veiculo;
    }

    @Override
    public IdAgendamento getId() {
        return idAgendamento;
    }

    public int getCodigoLiberacaoCarregador() {
        return codigoLiberacaoCarregador;
    }

    public void setCodigoLiberacaoCarregador(int codigoLiberacaoCarregador) {
        this.codigoLiberacaoCarregador = codigoLiberacaoCarregador;
    }

    public HorarioDisponivel getHorarioAgendamento() {
        return horarioAgendamento;
    }

    public void setHorarioAgendamento(HorarioDisponivel horarioAgendamento) {
        this.horarioAgendamento = horarioAgendamento;
    }

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public float getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(float valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public float getValorTotalRecarga() {
        return valorTotalRecarga;
    }

    public void setValorTotalRecarga(float valorTotalRecarga) {
        this.valorTotalRecarga = valorTotalRecarga;
    }

    public List<Avaliacoes> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(List<Avaliacoes> avaliacao) {
        this.avaliacao = avaliacao;
    }

    public IdEstacao getEstacaoDeRecarga() {
        return estacaoDeRecarga;
    }

    public void setEstacaoDeRecarga(IdEstacao estacaoDeRecarga) {
        this.estacaoDeRecarga = estacaoDeRecarga;
    }

    public IdMotorista getMotorista() {
        return motorista;
    }

    public void setMotorista(IdMotorista motorista) {
        this.motorista = motorista;
    }

    public IdVeiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(IdVeiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public Agendamento clone() {
        try {
            return (Agendamento) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
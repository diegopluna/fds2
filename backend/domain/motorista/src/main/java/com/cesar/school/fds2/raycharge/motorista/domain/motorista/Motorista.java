package com.cesar.school.fds2.raycharge.motorista.domain.motorista;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.apache.commons.lang3.Validate.notBlank;
import org.jmolecules.ddd.types.AggregateRoot;

import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.IdAgendamento;
import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;
import com.cesar.school.fds2.raycharge.motorista.domain.veiculo.IdVeiculo;

public class Motorista implements Cloneable, AggregateRoot<Motorista, IdMotorista> {

    private final IdMotorista idMotorista;
    private IdUsuario usuarioMotorista;
    private String nomeMotorista;
    private List<IdVeiculo> veiculos;
    private List<IdAgendamento> historicoDeUso;

    public Motorista(IdUsuario usuarioMotorista, IdMotorista idMotorista, String nomeMotorista, List<IdVeiculo> veiculos, List<IdAgendamento> historicoDeUso) {
        this.usuarioMotorista = Objects.requireNonNull(usuarioMotorista);
        this.idMotorista = Objects.requireNonNull(idMotorista);
        this.nomeMotorista = notBlank(nomeMotorista);
        this.veiculos = new ArrayList<>(veiculos);
        this.historicoDeUso = new ArrayList<>(historicoDeUso);
    }

    public IdMotorista getIdMotorista() {
        return idMotorista;
    }

    public IdUsuario getUsuarioMotorista() {
        return usuarioMotorista;
    }

    public void setUsuarioMotorista(IdUsuario usuarioMotorista) {
        this.usuarioMotorista = Objects.requireNonNull(usuarioMotorista);
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = notBlank(nomeMotorista);
    }

    public List<IdVeiculo> getVeiculos() {
        return new ArrayList<>(veiculos);
    }

    public void setVeiculos(List<IdVeiculo> veiculos) {
        this.veiculos = new ArrayList<>(Objects.requireNonNull(veiculos));
    }

    public List<IdAgendamento> getHistoricoDeUso() {
        return new ArrayList<>(historicoDeUso);
    }

    public void setHistoricoDeUso(List<IdAgendamento> historicoDeUso) {
        this.historicoDeUso = new ArrayList<>(Objects.requireNonNull(historicoDeUso));
    }

    @Override
    public Motorista clone() {
      try {
          return (Motorista) super.clone();
      } catch (CloneNotSupportedException e) {
          throw new AssertionError();
      }
    }

    @Override
    public IdMotorista getId() {
        return null;
    }
}

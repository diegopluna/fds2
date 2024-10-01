package com.cesar.school.fds2.raycharge.recarga.domain.agendamento;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.*;
import com.cesar.school.fds2.raycharge.infra.persistence.memory.Repository;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.IdMotorista;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.Motorista;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.MotoristaRepositorio;
import com.cesar.school.fds2.raycharge.motorista.domain.veiculo.IdVeiculo;
import com.cesar.school.fds2.raycharge.notificacao.domain.notificacao.Notificacao;
import com.cesar.school.fds2.raycharge.notificacao.domain.notificacao.NotificacaoRepositorio;
import com.cesar.school.fds2.raycharge.recarga.domain.RecargaFuncionalidade;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RealizarAgendamentoFuncionalidade extends RecargaFuncionalidade {

    private EstacaoDeRecarga estacao;
    private IdMotorista idMotorista;
    private Motorista motorista;
    private IdVeiculo idVeiculo;
    private IdUsuario idUsuario;
    private HorarioDisponivel horarioSelecionado;
    private IdAgendamento resultadoAgendamento;
    private EstacaoDeRecargaRepositorio estacaoDeRecargaRepositorio;
    private AgendamentoRepositorio agendamentoRepositorio;
    private NotificacaoRepositorio notificacaoRepositorio;
    private ServicoAgendamento servicoAgendamento;
    private MotoristaRepositorio motoristaRepositorio;

    public RealizarAgendamentoFuncionalidade() {
        super();
        estacaoDeRecargaRepositorio = new Repository();
        agendamentoRepositorio = new Repository();
        notificacaoRepositorio = new Repository();
        motoristaRepositorio = new Repository();
        servicoAgendamento = new ServicoAgendamento(
            agendamentoRepositorio,
            notificacaoRepositorio,
            estacaoDeRecargaRepositorio,
            motoristaRepositorio
        );
    }


    @Given("que existe uma estação com horários disponíveis e um motorista que não possui agendamentos com status ativo")
    public void existeEstacaoEMotorista() {
        HorarioDisponivel horarioFuncionamento = new HorarioDisponivel(LocalDateTime.now(), LocalDateTime.now().plusHours(24));
        List<HorarioDisponivel> horariosDisponiveis = List.of(
            new HorarioDisponivel(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)),
            new HorarioDisponivel(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3)),
            new HorarioDisponivel(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4))
        );
        estacao = new EstacaoDeRecarga(new IdEstacao(1), null, "Estação Teste", 5, horarioFuncionamento, null, StatusEstacao.ATIVA, 10, 2, 0, 30, horariosDisponiveis, null);
        estacaoDeRecargaRepositorio.salvarEstacao(estacao);

        idMotorista = new IdMotorista(1);
        idUsuario = new IdUsuario(1);
        idVeiculo = new IdVeiculo(1);

        motorista = new Motorista(idUsuario, idMotorista, "Wolminho", List.of(idVeiculo), null);
        motoristaRepositorio.saveMotorista(motorista);
    }

    @When("o motorista selecionar para agendamento esta estação e um horário específico entre os disponíveis desta mesma estação")
    public void motoristaAgendaHorarioDisponivel() {
        horarioSelecionado = new HorarioDisponivel(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2));
        resultadoAgendamento = servicoAgendamento.realizarAgendamento(idMotorista, horarioSelecionado, idVeiculo, estacao.getId());
    }

    @Then("o agendamento deve ser instanciado e persistido no sistema")
    public void agendamentoDeveSerPersistido() {
        assertNotNull(resultadoAgendamento);
        assertTrue(agendamentoRepositorio.findById(resultadoAgendamento).isPresent());
    }

    @Then("deve ser criada e persistida uma notificação de confirmação: {string}")
    public void notificacaoDeConfirmacaoDeveSercriada(String mensagemEsperada) {
        List<Notificacao> notificacoes = notificacaoRepositorio.findByDestinatario(idUsuario);
        boolean notificacaoEncontrada = notificacoes.stream()
            .anyMatch(notificacao -> notificacao.getMensagem().contains(mensagemEsperada));
        assertTrue(notificacaoEncontrada, "Notificação de confirmação não encontrada");
    }

    @When("o motorista selecionar para agendamento esta estação e um horário que não estiver entre os disponíveis desta mesma estação")
    public void motoristaAgendaHorarioIndisponivel() {
        horarioSelecionado = new HorarioDisponivel(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(1));
        resultadoAgendamento = servicoAgendamento.realizarAgendamento(idMotorista, horarioSelecionado, idVeiculo, estacao.getId());
    }

    @Then("o agendamento não deve ser criado ou persistido no sistema")
    public void agendamentoNaoDeveSerPersistido() {
        assertNull(resultadoAgendamento);
    }

    @And("deve ser criada e persistida uma notificação de erro: {string}")
    public void notificacaoDeErroDeveSercriada(String mensagemEsperada) {
        List<Notificacao> notificacoes = notificacaoRepositorio.findByDestinatario(idUsuario);
        boolean notificacaoEncontrada = notificacoes.stream()
            .anyMatch(notificacao -> notificacao.getMensagem().contains(mensagemEsperada));
        assertTrue(notificacaoEncontrada, "Notificação de erro não encontrada");
    }

    @Given("que exista uma estação com horários disponíveis e um motorista que possui um agendamento com status ativo")
    public void existeEstacaoEMotoristaComAgendamentoAtivo() {
        existeEstacaoEMotorista();

        Agendamento agendamentoAtivo = new Agendamento(
            new IdAgendamento(1),
            123456,
            new HorarioDisponivel(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4)),
            StatusAgendamento.ATIVO,
            0,
            null,
            estacao.getId(),
            idMotorista,
            idVeiculo,
            estacao.getPrecoMinimo()
        );
        agendamentoRepositorio.saveAgendamento(agendamentoAtivo);
    }
}
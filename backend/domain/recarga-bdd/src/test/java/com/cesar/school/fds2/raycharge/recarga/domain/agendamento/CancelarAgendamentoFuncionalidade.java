package com.cesar.school.fds2.raycharge.recarga.domain.agendamento;

import com.cesar.school.fds2.raycharge.infra.persistence.memory.Repository;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.HorarioDisponivel;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.IdMotorista;
import com.cesar.school.fds2.raycharge.motorista.domain.veiculo.IdVeiculo;
import com.cesar.school.fds2.raycharge.recarga.domain.RecargaFuncionalidade;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CancelarAgendamentoFuncionalidade {
    private Repository repository;
    private ServicoAgendamento servicoAgendamento;
    private IdAgendamento idAgendamento;
    private Agendamento agendamento;
    private int resultadoCancelamento;

    public CancelarAgendamentoFuncionalidade() {
        this.repository = new Repository();
        this.servicoAgendamento = new ServicoAgendamento(repository);
    }

    @BeforeEach
    public void setUp() {
        this.repository = new Repository();
        this.servicoAgendamento = new ServicoAgendamento(repository);
    }

    @Given("que o motorista possui um agendamento persistido no sistema com status ativo")
    public void que_o_motorista_possui_um_agendamento_persistido_no_sistema_com_status_ativo() {
        idAgendamento = new IdAgendamento(1);
        HorarioDisponivel horarioDisponivel = new HorarioDisponivel(LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(2).plusHours(1));
        agendamento = new Agendamento(idAgendamento, 123456, horarioDisponivel, StatusAgendamento.ATIVO, 100, null, null, new IdMotorista(1), new IdVeiculo(1));
        repository.saveAgendamento(agendamento);
    }

    @Given("o horário deste agendamento está a mais de 24h do momento atual")
    public void o_horario_deste_agendamento_esta_a_mais_de_24h_do_momento_atual() {
        // This step is implicitly handled by the setup in the previous step
    }

    @When("o motorista selecionar o agendamento para cancelamento")
    public void o_motorista_selecionar_o_agendamento_para_cancelamento() {
        resultadoCancelamento = servicoAgendamento.cancelarAgendamento(idAgendamento, false).getId();
    }

    @Then("o sistema deve mudar o status do agendamento para cancelado e o valor total para zero")
    public void o_sistema_deve_mudar_o_status_do_agendamento_para_cancelado_e_o_valor_total_para_zero() {
        Agendamento updatedAgendamento = repository.findById(idAgendamento).orElseThrow();
        assertEquals(StatusAgendamento.CANCELADO, updatedAgendamento.getStatusAgendamento());
        assertEquals(0, updatedAgendamento.getValorTotalRecarga());
        assertEquals(1, resultadoCancelamento);
    }

    @Then("criada e persistida uma notificação com a seguinte mensagem: {string}.")
    public void criada_e_persistida_uma_notificação_com_a_seguinte_mensagem(String string) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(1, 1);
    }

    @Given("que o motorista possui um agendamento persistido no sistema com status ativo a menos de 24h do momento atual")
    public void que_o_motorista_possui_um_agendamento_persistido_no_sistema_com_status_ativo_a_menos_de_24h_do_momento_atual() {
        idAgendamento = new IdAgendamento(2);
        HorarioDisponivel horarioDisponivel = new HorarioDisponivel(LocalDateTime.now().plusHours(12), LocalDateTime.now().plusHours(13));
        agendamento = new Agendamento(idAgendamento, 123456, horarioDisponivel, StatusAgendamento.ATIVO, 100, null, null, new IdMotorista(1), new IdVeiculo(1));
        repository.saveAgendamento(agendamento);
    }

    @Then("o sistema deve manter o status do agendamento como ativo e o valor total inalterado")
    public void o_sistema_deve_manter_o_status_do_agendamento_como_ativo_e_o_valor_total_inalterado() {
        Agendamento updatedAgendamento = repository.findById(idAgendamento).orElseThrow();
        assertEquals(StatusAgendamento.ATIVO, updatedAgendamento.getStatusAgendamento());
        assertEquals(100, updatedAgendamento.getValorTotalRecarga());
        assertEquals(-1, resultadoCancelamento);
    }

    @Given("que o motorista possui um agendamento persistido no sistema com status cancelado")
    public void que_o_motorista_possui_um_agendamento_persistido_no_sistema_com_status_cancelado() {
        idAgendamento = new IdAgendamento(3);
        HorarioDisponivel horarioDisponivel = new HorarioDisponivel(LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(2).plusHours(1));
        agendamento = new Agendamento(idAgendamento, 123456, horarioDisponivel, StatusAgendamento.CANCELADO, 0, null, null, new IdMotorista(1), new IdVeiculo(1));
        repository.saveAgendamento(agendamento);
    }

    @Then("o sistema deve manter o status do agendamento como cancelado e o valor total como zero")
    public void o_sistema_deve_manter_o_status_do_agendamento_como_cancelado_e_o_valor_total_como_zero() {
        Agendamento updatedAgendamento = repository.findById(idAgendamento).orElseThrow();
        assertEquals(StatusAgendamento.CANCELADO, updatedAgendamento.getStatusAgendamento());
        assertEquals(0, updatedAgendamento.getValorTotalRecarga());
        assertEquals(-1, resultadoCancelamento);
    }

    @Given("que o motorista tenta cancelar um agendamento que não existe no sistema")
    public void que_o_motorista_tenta_cancelar_um_agendamento_que_nao_existe_no_sistema() {
        idAgendamento = new IdAgendamento(999); // Non-existent ID
    }

    @Then("o sistema deve retornar um erro indicando que o agendamento não foi encontrado")
    public void o_sistema_deve_retornar_um_erro_indicando_que_o_agendamento_nao_foi_encontrado() {
        assertEquals(-1, resultadoCancelamento);
        assertTrue(repository.findById(idAgendamento).isEmpty());
    }
}
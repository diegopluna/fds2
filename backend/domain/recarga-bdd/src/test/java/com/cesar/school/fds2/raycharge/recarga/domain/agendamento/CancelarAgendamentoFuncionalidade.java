package com.cesar.school.fds2.raycharge.recarga.domain.agendamento;

import com.cesar.school.fds2.raycharge.infra.persistence.memory.Repository;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.AgendamentoRepositorio;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.ServicoAgendamento;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.Agendamento;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.IdAgendamento;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.StatusAgendamento;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.HorarioDisponivel;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.IdMotorista;
import com.cesar.school.fds2.raycharge.recarga.domain.agendamento.IdVeiculo;
import org.mockito.Mockito;
import com.cesar.school.fds2.raycharge.recarga.domain.RecargaFuncionalidade;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.cesar.school.fds2.raycharge.infra.persistence.memory.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CancelarAgendamentoFuncionalidade extends RecargaFuncionalidade {
    

    public CancelarAgendamentoFuncionalidade() {
        super();
    }

    @Given("que o motorista possui um agendamento persistido no sistema com status ativo")
    public void que_o_motorista_possui_um_agendamento_persistido_no_sistema_com_status_ativo() {
        agendamentoRepositorio = Mockito.mock(AgendamentoRepositorio.class);
        servicoAgendamento = new ServicoAgendamento(agendamentoRepositorio);

        idAgendamento = new IdAgendamento(1);
        HorarioDisponivel horarioDisponivel = new HorarioDisponivel(LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(2).plusHours(1));
        agendamento = new Agendamento(idAgendamento, 123456, horarioDisponivel, StatusAgendamento.ATIVO, 0, null, null, new IdMotorista(1), new IdVeiculo(1));

        Mockito.when(agendamentoRepositorio.findById(idAgendamento)).thenReturn(agendamento);
    }

    @Given("o horário deste agendamento está a mais de 24h do momento atual")
    public void o_horario_deste_agendamento_esta_a_mais_de_24h_do_momento_atual() {
        // This step is implicitly handled by the setup in the previous step
    }

    @When("o motorista selecionar o agendamento para cancelamento")
    public void o_motorista_selecionar_o_agendamento_para_cancelamento() {
        servicoAgendamento.cancelarAgendamento(idAgendamento, false);
    }

    @Then("o sistema deve mudar o status do agendamento para cancelado e o valor total para zero")
    public void o_sistema_deve_mudar_o_status_do_agendamento_para_cancelado_e_o_valor_total_para_zero() {
        assertEquals(StatusAgendamento.CANCELADO, agendamento.getStatusAgendamento());
        assertEquals(0, agendamento.getValorTotalRecarga());
    }

    @Then("criada e persistida uma notificação com a seguinte mensagem: {string}")
    public void criada_e_persistida_uma_notificacao_com_a_seguinte_mensagem(String mensagemEsperada) {
        // Verifique se a notificação foi criada e persistida
        // Isso pode envolver a verificação de chamadas de método no repositório de notificações
    }
}

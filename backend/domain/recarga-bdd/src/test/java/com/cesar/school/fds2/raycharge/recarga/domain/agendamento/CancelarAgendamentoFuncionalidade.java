package com.cesar.school.fds2.raycharge.recarga.domain.agendamento;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.EstacaoDeRecarga;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.IdEstacao;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.StatusEstacao;
import com.cesar.school.fds2.raycharge.infra.persistence.memory.Repository;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.HorarioDisponivel;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.IdMotorista;
import com.cesar.school.fds2.raycharge.motorista.domain.veiculo.IdVeiculo;
import com.cesar.school.fds2.raycharge.notificacao.domain.notificacao.Notificacao;
import com.cesar.school.fds2.raycharge.notificacao.domain.notificacao.NotificacaoRepositorio;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CancelarAgendamentoFuncionalidade {
    private Repository repository;
    private ServicoAgendamento servicoAgendamento;
    private NotificacaoRepositorio notificacaoRepositorio;
    private IdAgendamento idAgendamento;
    private Agendamento agendamento;
    private int resultadoCancelamento;
    private EstacaoDeRecarga estacaoDeRecarga;

    public CancelarAgendamentoFuncionalidade() {
        this.repository = new Repository();
        this.notificacaoRepositorio = new Repository();
        this.servicoAgendamento = new ServicoAgendamento(
            this.repository,
            this.notificacaoRepositorio,
            new Repository(),
            new Repository()
        );
    }

    @BeforeEach
    public void setUp() {
        this.repository = new Repository();
        this.notificacaoRepositorio = new Repository();
        this.servicoAgendamento = new ServicoAgendamento(
            this.repository,
            this.notificacaoRepositorio,
            new Repository(),
            new Repository()
        );
    }

    @Given("que o motorista possui um agendamento persistido no sistema com status ativo")
    public void que_o_motorista_possui_um_agendamento_persistido_no_sistema_com_status_ativo() {
        idAgendamento = new IdAgendamento(1);
        HorarioDisponivel horarioDisponivel = new HorarioDisponivel(LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(2).plusHours(1));
        HorarioDisponivel horarioFuncionamento = new HorarioDisponivel(LocalDateTime.now(), LocalDateTime.now().plusDays(2).plusHours(1));
        estacaoDeRecarga = new EstacaoDeRecarga(new IdEstacao(1), null, "Estacao1", 10, horarioFuncionamento , null, StatusEstacao.ATIVA, 10, 10, 10, 10, null, null);
        agendamento = new Agendamento(idAgendamento, 123456, horarioDisponivel, StatusAgendamento.ATIVO, 100, null, null, new IdMotorista(1), new IdVeiculo(1), estacaoDeRecarga.getPrecoMinimo());
        repository.saveAgendamento(agendamento);
    }

    @Given("o horário deste agendamento está a mais de 24h do momento atual")
    public void o_horario_deste_agendamento_esta_a_mais_de_24h_do_momento_atual() {
        // This step is implicitly handled by the setup in the previous step
    }

    @Given("o horário do agendamento está a menos de 24h do momento atual")
    public void o_horario_do_agendamento_esta_a_menos_de_24h_do_momento_atual() {
        idAgendamento = new IdAgendamento(2);
        HorarioDisponivel horarioDisponivel = new HorarioDisponivel(LocalDateTime.now().plusHours(12), LocalDateTime.now().plusHours(13));
        HorarioDisponivel horarioFuncionamento = new HorarioDisponivel(LocalDateTime.now(), LocalDateTime.now().plusDays(2).plusHours(1));
        estacaoDeRecarga = new EstacaoDeRecarga(new IdEstacao(1), null, "Estacao1", 10, horarioFuncionamento , null, StatusEstacao.ATIVA, 10, 10, 10, 10, null, null);
        agendamento = new Agendamento(idAgendamento, 123456, horarioDisponivel, StatusAgendamento.ATIVO, 100, null, estacaoDeRecarga.getId(), new IdMotorista(1), new IdVeiculo(1), estacaoDeRecarga.getPrecoMinimo());
        repository.saveAgendamento(agendamento);
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

    @Then("o sistema deve mudar o status do agendamento para cancelado e o valor total para o valor mínimo da estação respectiva")
    public void o_sistema_deve_mudar_o_status_do_agendamento_para_cancelado_e_o_valor_total_para_o_valor_minimo() {
        Agendamento updatedAgendamento = repository.findById(idAgendamento).orElseThrow();
        assertEquals(StatusAgendamento.CANCELADO, updatedAgendamento.getStatusAgendamento());
        assertEquals(updatedAgendamento.getValorTotalRecarga(), estacaoDeRecarga.getPrecoMinimo());
        assertEquals(2, resultadoCancelamento);
    }

    @Then("criada e persistida uma notificação com a seguinte mensagem: {string}.")
    public void criada_e_persistida_uma_notificação_com_a_seguinte_mensagem(String mensagemEsperada) {
        // Retrieve all notifications for the motorista
        List<Notificacao> notificacoes = notificacaoRepositorio.findByDestinatario(new IdUsuario(agendamento.getMotorista().getId()));
        
        // Check if there's a notification with the expected message
        boolean notificacaoEncontrada = notificacoes.stream()
            .anyMatch(notificacao -> notificacao.getMensagem().trim().equalsIgnoreCase(mensagemEsperada.trim()));
        
        assertTrue(notificacaoEncontrada, "Notificação com a mensagem esperada não foi encontrada. Notificações encontradas: " + notificacoes.stream(
            ).map(Notificacao::getMensagem).reduce("", (acc, mensagem) -> acc + mensagem + ", "
        ));
    }

    @Given("que o motorista possui um agendamento persistido no sistema com status ativo a menos de 24h do momento atual")
    public void que_o_motorista_possui_um_agendamento_persistido_no_sistema_com_status_ativo_a_menos_de_24h_do_momento_atual() {
        idAgendamento = new IdAgendamento(2);
        HorarioDisponivel horarioDisponivel = new HorarioDisponivel(LocalDateTime.now().plusHours(12), LocalDateTime.now().plusHours(13));
        agendamento = new Agendamento(idAgendamento, 123456, horarioDisponivel, StatusAgendamento.ATIVO, 100, null, estacaoDeRecarga.getId(), new IdMotorista(1), new IdVeiculo(1),estacaoDeRecarga.getPrecoMinimo());
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
        agendamento = new Agendamento(idAgendamento, 123456, horarioDisponivel, StatusAgendamento.CANCELADO, 0, null, estacaoDeRecarga.getId(), new IdMotorista(1), new IdVeiculo(1), estacaoDeRecarga.getPrecoMinimo());
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
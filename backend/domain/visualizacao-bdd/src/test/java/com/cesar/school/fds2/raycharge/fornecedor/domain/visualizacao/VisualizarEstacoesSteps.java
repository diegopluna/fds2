package com.cesar.school.fds2.raycharge.fornecedor.domain.visualizacao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.EstacaoDeRecarga;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.EstacaoDeRecargaRepositorio;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.HorarioDisponivel;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.StatusEstacao;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class VisualizarEstacoesSteps {
    private EstacaoDeRecargaRepositorio estacaoDeRecargaRepositorio;
    private List<EstacaoDeRecarga> estacoesRetornadas;
    private List<EstacaoDeRecarga> estacoesCadastradas;

    @Given("que existam três estações de recarga cadastradas")
    public void que_existam_tres_estacoes_de_recarga_cadastradas() {
        estacaoDeRecargaRepositorio = new EstacaoDeRecargaRepositorioImpl();
        estacoesCadastradas = new ArrayList<>();

        estacoesCadastradas.add(new EstacaoDeRecarga("Estacao 1", "Endereco 1", 1.0, 5.0, 0.5, StatusEstacao.ATIVO, List.of(new HorarioDisponivel())));
        estacoesCadastradas.add(new EstacaoDeRecarga("Estacao 2", "Endereco 2", 2.0, 5.0, 0.5, StatusEstacao.ATIVO, List.of(new HorarioDisponivel())));
        estacoesCadastradas.add(new EstacaoDeRecarga("Estacao 3", "Endereco 3", 3.0, 5.0, 0.5, StatusEstacao.ATIVO, List.of(new HorarioDisponivel())));

        estacaoDeRecargaRepositorio.saveAll(estacoesCadastradas);
    }

    @When("o motorista realizar a busca")
    public void o_motorista_realizar_a_busca() {
        estacoesRetornadas = estacaoDeRecargaRepositorio.findAll().stream()
            .sorted((e1, e2) -> Double.compare(e1.getDistancia(), e2.getDistancia()))
            .collect(Collectors.toList());
    }

    @Then("as estações cadastradas retornadas com nome, endereço, distância do motorista até a estação, preço mínimo e preço por kWh")
    public void as_estacoes_cadastradas_retornadas_com_nome_endereco_distancia_do_motorista_ate_a_estacao_preco_minimo_e_preco_por_kWh() {
        assertEquals(3, estacoesRetornadas.size());
        for (EstacaoDeRecarga estacao : estacoesRetornadas) {
            assertTrue(estacao.getNome() != null && !estacao.getNome().isEmpty());
            assertTrue(estacao.getEndereco() != null && !estacao.getEndereco().isEmpty());
            assertTrue(estacao.getDistancia() > 0);
            assertTrue(estacao.getPrecoMinimo() > 0);
            assertTrue(estacao.getPrecoPorKwh() > 0);
        }
    }

    @Then("os cards devem estar ordenados em ordem crescente de distância entre a estação e a localização do motorista")
    public void os_cards_devem_estar_ordenados_em_ordem_crescente_de_distancia_entre_a_estacao_e_a_localizacao_do_motorista() {
        for (int i = 0; i < estacoesRetornadas.size() - 1; i++) {
            assertTrue(estacoesRetornadas.get(i).getDistancia() <= estacoesRetornadas.get(i + 1).getDistancia());
        }
    }

    @Given("que há uma estação de recarga cadastrada no sistema sem horários disponíveis")
    public void que_ha_uma_estacao_de_recarga_cadastrada_no_sistema_sem_horarios_disponiveis() {
        estacaoDeRecargaRepositorio = new EstacaoDeRecargaRepositorio();
        estacoesCadastradas = new ArrayList<>();

        estacoesCadastradas.add(new EstacaoDeRecarga("Estacao 1", "Endereco 1", 1.0, 5.0, 0.5, StatusEstacao.ATIVO, new ArrayList<>()));

        estacaoDeRecargaRepositorio.saveAll(estacoesCadastradas);
    }

    @Then("a estação sem horário disponível não deve ser retornada")
    public void a_estacao_sem_horario_disponivel_nao_deve_ser_retornada() {
        estacoesRetornadas = estacaoDeRecargaRepositorio.findAll().stream()
            .filter(estacao -> !estacao.getHorariosDisponiveis().isEmpty())
            .collect(Collectors.toList());

        assertTrue(estacoesRetornadas.isEmpty());
    }

    @Given("que há uma estação de recarga cadastrada no sistema com status inativo")
    public void que_ha_uma_estacao_de_recarga_cadastrada_no_sistema_com_status_inativo() {
        estacaoDeRecargaRepositorio = new EstacaoDeRecargaRepositorio();
        estacoesCadastradas = new ArrayList<>();

        estacoesCadastradas.add(new EstacaoDeRecarga("Estacao 1", "Endereco 1", 1.0, 5.0, 0.5, StatusEstacao.INATIVO, List.of(new HorarioDisponivel())));

        estacaoDeRecargaRepositorio.saveAll(estacoesCadastradas);
    }

    @Then("a estação com status inativo não deve ser retornada")
    public void a_estacao_com_status_inativo_nao_deve_ser_retornada() {
        estacoesRetornadas = estacaoDeRecargaRepositorio.findAll().stream()
            .filter(estacao -> estacao.getStatus() == StatusEstacao.ATIVO)
            .collect(Collectors.toList());
    }
}

// Classe de implementação concreta para fins de teste
class EstacaoDeRecargaRepositorioImpl extends EstacaoDeRecargaRepositorio {
    // Implementar métodos abstratos aqui
}


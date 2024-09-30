package com.cesar.school.fds2.raycharge.recarga.domain.agendamento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

import org.jmolecules.ddd.annotation.Service;

import com.cesar.school.fds2.raycharge.agendamento.domain.agendamento.Avaliacao;
import com.cesar.school.fds2.raycharge.agendamento.domain.agendamento.Avaliacoes;
import com.cesar.school.fds2.raycharge.agendamento.domain.agendamento.IdAgendamento;
import com.cesar.school.fds2.raycharge.agendamento.domain.agendamento.StatusAgendamento;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.EstacaoDeRecarga;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.HorarioDisponivel;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.IdEstacao;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.IdMotorista;
import com.cesar.school.fds2.raycharge.motorista.domain.veiculo.IdVeiculo;

@Service
public class ServicoAgendamento {

    private final AgendamentoRepositorio agendamentoRepositorio;

    public ServicoAgendamento(AgendamentoRepositorio agendamentoRepositorio) {
        Objects.requireNonNull(agendamentoRepositorio, "O repositório de agendamentos não pode ser nulo");
        this.agendamentoRepositorio = agendamentoRepositorio;
    }

    public IdAgendamento realizarAgendamento(IdMotorista idMotorista, HorarioDisponivel horarioAgendamento, IdVeiculo veiculo, IdEstacao estacao) {

        IdAgendamento idAgendamento = new IdAgendamento(UUID.randomUUID().toString().hashCode());

        Agendamento agendamento = new Agendamento(
                idAgendamento,
                generateCodigoLiberacao(),
                horarioAgendamento,
                StatusAgendamento.ATIVO,
                0,
                new ArrayList<>(),
                estacao,
                idMotorista,
                veiculo
        );
        agendamentoRepositorio.saveAgendamento(agendamento);

        return idAgendamento;
    }

    // HISTÓRIA 3
    public IdAgendamento cancelarAgendamento(IdAgendamento idAgendamento, boolean forcarReembolso) {
        Agendamento agendamento = agendamentoRepositorio.findById(idAgendamento);

        if (agendamento != null && agendamento.getStatusAgendamento() == StatusAgendamento.ATIVO) {
            agendamento.setStatusAgendamento(StatusAgendamento.CANCELADO);

            HorarioDisponivel horarioAgendamento = agendamento.getHorarioAgendamento();
            LocalDateTime inicioAgendamento = horarioAgendamento.getInicioAgendamento();
            LocalDateTime agora = LocalDateTime.now();

            if (inicioAgendamento.isBefore(agora.plusHours(24)) || forcarReembolso) {
                // Se faltar menos de 24h, aplicar o preço mínimo
                agendamento.setValorTotalRecarga(agendamento.getValorMinimo());
            } else {
                // Se faltar mais de 24h, valor total da recarga é 0
                agendamento.setValorTotalRecarga(0);
            }

            // Save the updated Agendamento
            agendamentoRepositorio.saveAgendamento(agendamento);

            return idAgendamento;
        } else {
            // Handle the case where the Agendamento doesn't exist or is not active
            throw new IllegalArgumentException("Agendamento não encontrado ou já concluído/cancelado.");
        }
    }

    /**
     * Obtém o código de liberação do carregador para um agendamento ativo.
     *
     * @param idAgendamento Id do agendamento.
     * @return Código de liberação.
     */
    public int getCodigoLiberacao(IdAgendamento idAgendamento) {
        // Retrieve the Agendamento from the repository
        Agendamento agendamento = agendamentoRepositorio.findById(idAgendamento);

        if (agendamento != null && agendamento.getStatusAgendamento() == StatusAgendamento.ATIVO) {
            // Return the release code
            return agendamento.getCodigoLiberacaoCarregador();
        } else {
            // Handle the case where the Agendamento is not found or not active
            throw new IllegalArgumentException("Agendamento não encontrado ou não está ativo.");
        }
    }

    /**
     * Conclui um agendamento ativo.
     *
     * @param idAgendamento Id do agendamento a ser concluído.
     */
    public void concluirAgendamento(IdAgendamento idAgendamento) {
        // Retrieve the Agendamento from the repository
        Agendamento agendamento = agendamentoRepositorio.findById(idAgendamento);

        if (agendamento != null && agendamento.getStatusAgendamento() == StatusAgendamento.ATIVO) {
            // Update the status to CONCLUIDO
            agendamento.setStatusAgendamento(StatusAgendamento.CONCLUIDO);

            // Calculate the valorTotalRecarga based on business rules
            int valorTotal = calculateValorTotal(agendamento);
            agendamento.setValorTotalRecarga(valorTotal);

            // Save the updated Agendamento
            agendamentoRepositorio.saveAgendamento(agendamento);
        } else {
            // Handle the case where the Agendamento is not found or not active
            throw new IllegalArgumentException("Agendamento não encontrado ou já concluído/cancelado.");
        }
    }
    // DAQUI PRA BAIXO
    
    /**
     * Avalia um agendamento concluído.
     *
     * @param idAgendamento       Id do agendamento a ser avaliado.
     * @param avaliacao           Avaliação dada.
     * @param descricaoExperiencia Descrição opcional da experiência.
     */
    public void avaliarAgendamento(IdAgendamento idAgendamento, Avaliacoes avaliacao, String descricaoExperiencia) {
        // Retrieve the Agendamento from the repository
        Agendamento agendamento = agendamentoRepositorio.findById(idAgendamento);

        if (agendamento != null && agendamento.getStatusAgendamento() == StatusAgendamento.CONCLUIDO) {
            // Create a new Avaliacao
            Avaliacao novaAvaliacao = new Avaliacao (
                generateIdAvaliacao(), // Generate a new ID for the Avaliacao
                avaliacao,
                descricaoExperiencia
            );

            // Add the Avaliacao to the Agendamento
            agendamentoRepositorio.saveAvaliacao(idAgendamento, novaAvaliacao);

            // Save the updated Agendamento
            agendamentoRepositorio.saveAgendamento(agendamento);
        } else {
            // Handle the case where the Agendamento is not found or not concluded
            throw new IllegalArgumentException("Agendamento não encontrado ou não está concluído.");
        }
    }

    // Helper methods

    private int generateCodigoLiberacao() {
        // Logic to generate a release code (e.g., a random 6-digit number)
        return (int) (Math.random() * 900000) + 100000;
    }

    private int calculateValorTotal(Agendamento agendamento) {
        // Logic to calculate the total charge value based on business rules
        // For example, based on the duration and station pricing

        HorarioDisponivel horario = agendamento.getHorarioAgendamento();

        int tempo = horario.getDurationInMinutes(horario);
        IdEstacao estacao = agendamento.getEstacaoDeRecarga();
        EstacaoDeRecarga estacaoDeRecarga = getEstacaoById(estacao);
        int precoPorMinuto = estacaoDeRecarga.getPrecoPKwH();

        return Math.max(tempo * precoPorMinuto, estacaoDeRecarga.getPrecoMinimo());
    }

    private EstacaoDeRecarga getEstacaoById(IdEstacao idEstacao) {
        // Implement logic to retrieve EstacaoDeRecarga by Id
        // This might involve calling a repository or service
        return null; // Placeholder implementation
    }

    private int generateIdAvaliacao() {
        // Logic to generate a unique ID for Avaliacao
        return (int) (Math.random() * Integer.MAX_VALUE);
    }
}
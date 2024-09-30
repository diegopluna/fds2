package com.cesar.school.fds2.raycharge.recarga.domain.agendamento;

import com.cesar.school.fds2.raycharge.agendamento.domain.agendamento.Avaliacoes;
import com.cesar.school.fds2.raycharge.agendamento.domain.agendamento.IdAgendamento;
import com.cesar.school.fds2.raycharge.agendamento.domain.agendamento.StatusAgendamento;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.IdMotorista;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.MotoristaRepositorio;
import org.jmolecules.ddd.annotation.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.HorarioDisponivel;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.IdEstacao;
import com.cesar.school.fds2.raycharge.motorista.domain.veiculo.IdVeiculo;

@Service
public class AgendamentoService {

    private final AgendamentoRepositorio agendamentoRepositorio;

    public AgendamentoService(AgendamentoRepositorio agendamentoRepositorio) {
        Objects.requireNonNull(agendamentoRepositorio, "O repositório de agendamentos não pode ser nulo");
        this.agendamentoRepositorio = agendamentoRepositorio;
    }

    /**
     * Realiza um novo agendamento.
     *
     * @param horarioAgendamento Horário do agendamento.
     * @param veiculo            Veículo do motorista.
     * @param estacao            Estação de recarga selecionada.
     * @return Id do novo agendamento.
     */
    public IdAgendamento realizarAgendamento(IdMotorista idMotorista, HorarioDisponivel horarioAgendamento, IdVeiculo veiculo, IdEstacao estacao) {
        // Generate a new unique ID for the Agendamento
        IdAgendamento idAgendamento = new IdAgendamento(UUID.randomUUID().toString().hashCode()); // Changed to hashCode to match expected type

        // Create a new Agendamento instance
        Agendamento agendamento = new Agendamento(
                idAgendamento,
                generateCodigoLiberacao(), // Generate a release code
                horarioAgendamento,
                StatusAgendamento.ATIVO,
                0, // valorTotalRecarga will be calculated upon completion
                new ArrayList<>(), // Empty list of Avaliacoes
                estacao,
                idMotorista, // Using the method from MotoristaRepositorio
                veiculo
        );
        //comentario.
        // Save the Agendamento to the repository
        agendamentoRepositorio.saveAgendamento(agendamento);

        // Return the IdAgendamento
        return idAgendamento;
    }

    /**
     * Cancela um agendamento existente.
     *
     * @param idAgendamento Id do agendamento a ser cancelado.
     * @return Id do agendamento cancelado.
     */
    public IdAgendamento cancelarAgendamento(IdAgendamento idAgendamento) {
        // Retrieve the Agendamento from the repository
        Agendamento agendamento = agendamentoRepositorio.findById(idAgendamento);

        if (agendamento != null && agendamento.getStatusAgendamento() == StatusAgendamento.ATIVO) {
            // Update the status to CANCELADO
            agendamento.setStatusAgendamento(StatusAgendamento.CANCELADO);

            // Save the updated Agendamento
            agendamentoRepositorio.saveAgendamento(agendamento);

            // Return the IdAgendamento
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
            agendamento.getAvaliacoes().add(novaAvaliacao);

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
        int tempo = agendamento.getHorarioAgendamento().getDurationInMinutes();
        EstacaoDeRecarga estacao = // Retrieve EstacaoDeRecarga based on agendamento.getEstacaoDeRecarga()
                getEstacaoById(agendamento.getEstacaoDeRecarga());
        int precoPorMinuto = estacao.getPrecoPKwH();

        return Math.max(tempo * precoPorMinuto, estacao.getPrecoMinimo());
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
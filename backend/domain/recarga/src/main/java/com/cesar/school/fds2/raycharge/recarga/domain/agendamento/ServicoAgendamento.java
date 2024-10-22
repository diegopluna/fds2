package com.cesar.school.fds2.raycharge.recarga.domain.agendamento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.jmolecules.ddd.annotation.Service;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.EstacaoDeRecarga;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.EstacaoDeRecargaRepositorio;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.HorarioDisponivel;
import com.cesar.school.fds2.raycharge.fornecedor.domain.estacaoderecarga.IdEstacao;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.IdMotorista;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.Motorista;
import com.cesar.school.fds2.raycharge.motorista.domain.motorista.MotoristaRepositorio;
import com.cesar.school.fds2.raycharge.motorista.domain.veiculo.IdVeiculo;
import com.cesar.school.fds2.raycharge.notificacao.domain.notificacao.IdNotificacao;
import com.cesar.school.fds2.raycharge.notificacao.domain.notificacao.Notificacao;
import com.cesar.school.fds2.raycharge.notificacao.domain.notificacao.NotificacaoRepositorio;

@Service
public class ServicoAgendamento {

    private final AgendamentoRepositorio agendamentoRepositorio;
    private final EstacaoDeRecargaRepositorio estacaoDeRecargaRepositorio;
    private final NotificacaoRepositorio notificacaoRepositorio;
    private final MotoristaRepositorio motoristaRepositorio;

    public ServicoAgendamento(AgendamentoRepositorio agendamentoRepositorio, NotificacaoRepositorio notificacaoRepositorio, EstacaoDeRecargaRepositorio estacaoDeRecargaRepositorio, MotoristaRepositorio motoristaRepositorio) {
        Objects.requireNonNull(agendamentoRepositorio, "O repositório de agendamentos não pode ser nulo");
        Objects.requireNonNull(notificacaoRepositorio, "O repositório de notificações não pode ser nulo");
        Objects.requireNonNull(estacaoDeRecargaRepositorio, "O repositório de estações de recarga não pode ser nulo");
        Objects.requireNonNull(motoristaRepositorio, "O repositório de motoristas não pode ser nulo");
        this.agendamentoRepositorio = agendamentoRepositorio;
        this.notificacaoRepositorio = notificacaoRepositorio;
        this.estacaoDeRecargaRepositorio = estacaoDeRecargaRepositorio;
        this.motoristaRepositorio = motoristaRepositorio;
    }

    // HISÓRIA 2
    public IdAgendamento realizarAgendamento(IdMotorista idMotorista, HorarioDisponivel horarioAgendamento, IdVeiculo veiculo, IdEstacao estacao) {
        
        List<Agendamento> todosAgendamentosDoMotorista = agendamentoRepositorio.buscarMotoristaPorId(idMotorista);
        
        List<Agendamento> agendamentosAtivos = todosAgendamentosDoMotorista.stream()
        .filter(agendamento -> agendamento.getStatusAgendamento() == StatusAgendamento.ATIVO)
        .toList();
        
        Motorista motorista = motoristaRepositorio.findMotoristaById(idMotorista).orElse(null);

        List<IdUsuario> usuariosMotoristas = new ArrayList<>();
      assert motorista != null;
      usuariosMotoristas.add(motorista.getUsuarioMotorista());
        
        if (!agendamentosAtivos.isEmpty()) {
            Notificacao notificacaoErro = new Notificacao(
                new IdNotificacao(),
                usuariosMotoristas,
                "Você já possui um agendamento ativo. Para criar um novo agendamento, finalize o atual ou cancele-o."
            );
            notificacaoRepositorio.saveNotificacao(notificacaoErro);
            return null;
        }
        
        EstacaoDeRecarga estacaoDeRecarga = estacaoDeRecargaRepositorio.getEstacaoById(estacao);

        if (!estacaoDeRecarga.getHorarioDisponiveis().contains(horarioAgendamento)) {
            Notificacao notificacaoErro = new Notificacao(
                new IdNotificacao(),
                usuariosMotoristas,
                "Não foi possível agendar para a estação " + estacaoDeRecarga.getNomeDaEstacao() +
                    " no horário " + horarioAgendamento + ", pois ele está indisponível. Por favor selecione um horário disponível."
            );
            notificacaoRepositorio.saveNotificacao(notificacaoErro);
            return null;
        }

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
            veiculo,
            estacaoDeRecarga.getPrecoMinimo()
        );

        agendamentoRepositorio.saveAgendamento(agendamento);

        Notificacao notificacaoSucesso = new Notificacao(
            new IdNotificacao(),
            usuariosMotoristas,
            "Agendamento realizado com sucesso para a estação " + estacaoDeRecarga.getNomeDaEstacao() +
                " no dia e horário " + horarioAgendamento + "."
        );
        notificacaoRepositorio.saveNotificacao(notificacaoSucesso);

        return idAgendamento;
    }

    // HISTÓRIA 3
    public IdAgendamento cancelarAgendamento(IdAgendamento idAgendamento, boolean forcarReembolso) {
        Agendamento agendamento = agendamentoRepositorio.findById(idAgendamento).orElse(null);

        if (agendamento != null && agendamento.getStatusAgendamento() == StatusAgendamento.ATIVO) {
            agendamento.setStatusAgendamento(StatusAgendamento.CANCELADO);

            HorarioDisponivel horarioAgendamento = agendamento.getHorarioAgendamento();
            LocalDateTime inicioAgendamento = horarioAgendamento.getInicioAgendamento();
            LocalDateTime agora = LocalDateTime.now();

            boolean canceladoComMaisDe24h = inicioAgendamento.isAfter(agora.plusHours(24));
            String mensagem;
            if (canceladoComMaisDe24h || forcarReembolso) {
                agendamento.setValorTotalRecarga(0);
                mensagem = "Cancelamento processado com sucesso. Por ter sido solicitado a mais de 24h do horário agendado, o preço mínimo será reembolsado";

            } else {
                agendamento.setValorTotalRecarga(agendamento.getValorMinimo());
                mensagem = "Cancelamento processado com sucesso. Por ter sido solicitado a menos de 24h do horário agendado, o preço mínimo será cobrado";
            }

            agendamentoRepositorio.saveAgendamento(agendamento);

            List<IdUsuario> destinatarios = new ArrayList<>();
            destinatarios.add(new IdUsuario(agendamento.getMotorista().getId()));
            Notificacao notificacao = new Notificacao(new IdNotificacao(), destinatarios, mensagem);
            notificacaoRepositorio.saveNotificacao(notificacao);

            return idAgendamento;
        } else {
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
        Agendamento agendamento = agendamentoRepositorio.findById(idAgendamento).orElse(null);

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
        Agendamento agendamento = agendamentoRepositorio.findById(idAgendamento).orElse(null);

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
        Agendamento agendamento = agendamentoRepositorio.findById(idAgendamento).orElse(null);

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
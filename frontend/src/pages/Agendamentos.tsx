import { useState } from 'react';
import AgendamentoBox from '@/components/agendamento-box';
import ConfirmacaoCancelamentoMotoristaModal from '@/components/popup-confirmacao-cancelamento';
import CancelamentoConcluidoMotoristaModal from '@/components/popup-cancelamento-concluido';
import { mockSchedules } from '@/mocks/agendamentosMock';
import { Schedule } from '@/models/agendamentosModel';


function Agendamentos() {
  const [mostrarModalConfirmacao, setMostrarModalConfirmacao] = useState(false);
  const [mostrarModalConcluido, setMostrarModalConcluido] = useState(false);
  const [selectedSchedule, setSelectedSchedule] = useState<Schedule | null>(null);

  const handleCancelSchedule = (schedule: Schedule) => {
    setSelectedSchedule(schedule);
   setMostrarModalConfirmacao(true);
  };

  const handleProsseguirCancelamento = () => {
    setMostrarModalConfirmacao(false);
    setMostrarModalConcluido(true);
  };

  const handleFecharModalConcluido = () => {
    setMostrarModalConcluido(false);
  };

  return (
    <div className="container mx-auto px-32 relative">
      <h1 className="text-[#2D3648] font-inter font-bold text-center text-2xl mb-9 mt-4">
        Agendamentos
      </h1>

      {/* Renderiza os agendamentos do mock */}
      {mockSchedules.map((schedule) => (
        <AgendamentoBox
          key={schedule.id.id}
          estacao={schedule.station.id}
          endereco={`Station ${schedule.station.id}`}
          numero={schedule.id.id}
          data={new Date(schedule.date.scheduleStart).toLocaleDateString('pt-BR')}
          hora={new Date(schedule.date.scheduleStart).toLocaleTimeString('pt-BR', {
            hour: '2-digit',
            minute: '2-digit',
          })}
          status={schedule.status}
          onCancel={
            schedule.status === 'ACTIVE'
              ? () => handleCancelSchedule(schedule)
              : undefined
          }
        />
      ))}

      {/* Modal de Confirmação */}
      {mostrarModalConfirmacao && selectedSchedule && (
        <ConfirmacaoCancelamentoMotoristaModal
          estacao={selectedSchedule.station.id}
          data={new Date(selectedSchedule.date.scheduleStart).toLocaleDateString('pt-BR')}
          hora={new Date(selectedSchedule.date.scheduleStart).toLocaleTimeString('pt-BR', {
            hour: '2-digit',
            minute: '2-digit',
          })}
         reembolsoDisponivel={true}
          onCancelar={() => setMostrarModalConfirmacao(false)}
          onProsseguir={handleProsseguirCancelamento} />
      )}
      {mostrarModalConcluido && (
        <CancelamentoConcluidoMotoristaModal onClose={handleFecharModalConcluido} />
      )}
      
    </div>
  );
}

export default Agendamentos;
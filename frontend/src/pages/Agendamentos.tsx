import React, { useState } from 'react';
import AgendamentoBox from '@/components/agendamento-box';
import ConfirmacaoCancelamentoMotoristaModal from '@/components/popup-confirmacao-cancelamento';
import CancelamentoConcluidoMotoristaModal from '@/components/popup-cancelamento-concluido';

const Agendamentos: React.FC = () => {
  const [mostrarModalConfirmacao, setMostrarModalConfirmacao] = useState(false);
  const [mostrarModalConcluido, setMostrarModalConcluido] = useState(false);

  const handleCancelarAgendamento = () => {
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
      <h1 className="text-[#2D3648] font-inter font-bold text-center text-2xl mb-9 mt-4">Agendamentos</h1>
      <AgendamentoBox 
        estacao="Agendamento 01" 
        endereco="Estação X" 
        numero="123" 
        data="20/10/2024" 
        hora="14:00" 
        status="Ativo" 
        onCancel={handleCancelarAgendamento}
      />
      {mostrarModalConfirmacao && (
        <ConfirmacaoCancelamentoMotoristaModal 
          estacao="Estação X"
          data="20/10/2024"
          hora="14:00"
          reembolsoDisponivel={true}
          onCancelar={() => setMostrarModalConfirmacao(false)}
          onProsseguir={handleProsseguirCancelamento}
        />
      )}
      {mostrarModalConcluido && (
        <CancelamentoConcluidoMotoristaModal onClose={handleFecharModalConcluido} />
      )}
      <AgendamentoBox 
        estacao="Agendamento 02" 
        endereco="Estação Y" 
        numero="456" 
        data="21/10/2024" 
        hora="10:00" 
        status="Concluído" 
      />
    </div>
  );
};

export default Agendamentos;
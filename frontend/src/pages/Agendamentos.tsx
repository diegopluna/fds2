import React from 'react';
import AgendamentoBox from '@/components/agendamento-box';

const Agendamentos: React.FC = () => {
  return (
    <div className="container mx-auto p-6">
      <h1 className="text-[#2D3648] font-inter font-bold text-4xl mb-9 mt-4">Agendamentos</h1>
      <AgendamentoBox 
        estacao="Agendamento 01" 
        endereco="Estação X" 
        numero="123" 
        data="20/10/2024" 
        hora="14:00" 
        status="Ativo" 
      />
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
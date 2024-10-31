import React from 'react';

interface AgendamentoProps {
  estacao: string;
  endereco: string;
  numero: string;
  data: string;
  hora: string;
  status: 'Ativo' | 'Concluído' | 'Cancelado';
}

const AgendamentoBox: React.FC<AgendamentoProps> = ({ estacao, endereco, numero, data, hora, status }) => {
  return (
    <div className="border border-gray-300 p-4 rounded-md mb-4 shadow-md">
      <div className="flex justify-between">
        <div>
          <h2 className="text-lg font-bold mb-2 text-[#2D3648]">{estacao}</h2>
          <p className="text-sm text-gray-600">{endereco}, Nº {numero}</p>
          <p className="text-sm text-gray-600">Data: {data} - Hora: {hora}</p>
          <p className={`text-sm font-semibold mt-2 ${status === 'Ativo' ? 'text-[#00BC12]' : status === 'Concluído' ? 'text-blue-500' : 'text-red-500'}`}>
            Status: {status}
          </p>
        </div>
        <div className="flex items-center space-x-4">
          <button className="bg-[#4A5468] text-white px-4 py-2 rounded-md hover:bg-[#2D3648]">
            Detalhes
          </button>
          {status === 'Ativo' && (
            <button className="bg-[#FF6A6A] text-white px-4 py-2 rounded-md hover:bg-[#EF4444]">
              Cancelar
            </button>
          )}
        </div>
      </div>
    </div>
  );
};

export default AgendamentoBox;

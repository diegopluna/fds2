import React from 'react';

interface AgendamentoProps {
  estacao: string;
  endereco: string;
  numero: string;
  data: string;
  hora: string;
  status: 'ACTIVE' | 'COMPLETED' | 'CANCELLED';
  onCancel?: () => void; // Tornando onCancel opcional
}

const AgendamentoBox: React.FC<AgendamentoProps> = ({ estacao, endereco, numero, data, hora, status, onCancel }) => {
  return (
    <div className="border border-gray-300 p-4 rounded-md mb-4 shadow-md">
      <div className="flex justify-between">
        <div>
          <h2 className="text-lg font-bold mb-2 text-[#2D3648]">{estacao}</h2>
          <p className="text-sm text-gray-600">{endereco}, Nº {numero}</p>
          <p className="text-sm text-gray-600">Data: {data}</p>
          <p className="text-sm text-gray-600">Hora: {hora}</p>
          <p className={`text-sm font-semibold mt-2 ${status === 'ACTIVE' ? 'text-[#00BC12]' : status === 'COMPLETED' ? 'text-blue-500' : 'text-red-500'}`}>
            Status: {status}
          </p>
        </div>
        <div className="flex items-center space-x-4">
          <button className="bg-green-500 text-white px-4 py-2 rounded-md hover:bg-green-600">
            Detalhes
          </button>
          {status === 'ACTIVE' && onCancel && (
            <button onClick={onCancel} className="bg-[#FF6A6A] text-white px-4 py-2 rounded-md hover:bg-[#EF4444]">
              Cancelar
            </button>
          )}
        </div>
      </div>
    </div>
  );
};

export default AgendamentoBox;

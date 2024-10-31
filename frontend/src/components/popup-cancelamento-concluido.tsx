import React from 'react';

interface CancelamentoConcluidoMotoristaModalProps {
  onClose: () => void;
}

const CancelamentoConcluidoMotoristaModal: React.FC<CancelamentoConcluidoMotoristaModalProps> = ({ onClose }) => {
  return (
    <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center">
      <div className="bg-white p-6 rounded-lg shadow-lg max-w-md w-full">
        <h2 className="text-xl font-bold text-center mb-4">Seu agendamento foi <span className="text-red-500">CANCELADO</span> com sucesso!</h2>
        <div className="flex justify-center mt-6">
          <button
            onClick={onClose}
            className="bg-green-500 text-white px-6 py-2 rounded-md hover:bg-green-600"
          >
            Concluir
          </button>
        </div>
      </div>
    </div>
  );
};

export default CancelamentoConcluidoMotoristaModal;

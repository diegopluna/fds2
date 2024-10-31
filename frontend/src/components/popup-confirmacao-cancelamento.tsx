import React from 'react';

interface ConfirmacaoCancelamentoMotoristaModalProps {
  estacao: string;
  data: string;
  hora: string;
  onCancelar: () => void;
  onProsseguir: () => void;
  reembolsoDisponivel: boolean;
}

const ConfirmacaoCancelamentoMotoristaModal: React.FC<ConfirmacaoCancelamentoMotoristaModalProps> = ({
  estacao,
  data,
  hora,
  onCancelar,
  onProsseguir,
  reembolsoDisponivel
}) => {
  return (
    <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center">
      <div className="bg-white p-6 rounded-lg shadow-lg max-w-md w-full">
        <h2 className="text-xl font-bold text-center mb-4">Cancelar Agendamento</h2>
        <p className="text-gray-700 mb-4">
          O reembolso acontecerá <span className="font-bold">APENAS</span> se o cancelamento for executado 24 horas antes do dia agendado.
        </p>
        <p className="text-gray-700 mb-4">
          Estação: <span className="font-bold">{estacao}</span>, Data: <span className="font-bold">{data}</span>, Hora: <span className="font-bold">{hora}</span>
        </p>
        <p className="text-gray-700 mb-6">
          Reembolso: <span className={`font-bold ${reembolsoDisponivel ? 'text-green-500' : 'text-red-500'}`}>
            {reembolsoDisponivel ? 'Disponível' : 'Indisponível'}
          </span>
        </p>
        <div className="flex justify-between">
          <button
            onClick={onCancelar}
            className="bg-green-500 text-white px-6 py-2 rounded-md hover:bg-green-600"
          >
            Voltar
          </button>
          <button
            onClick={onProsseguir}
            className="bg-[#FF6A6A] text-white px-4 py-2 rounded-md hover:bg-[#EF4444]"
          >
            Continuar
          </button>
        </div>
      </div>
    </div>
  );
};

export default ConfirmacaoCancelamentoMotoristaModal;

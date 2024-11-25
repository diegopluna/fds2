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
      <div className="bg-white p-6 rounded-lg shadow-lg max-w-md w-full relative">
        {/* Botão de Fechar */}
        <button
          onClick={onCancelar}
          className="absolute top-3 right-3 text-gray-400 hover:text-gray-600"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            className="h-6 w-6"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth={2}
              d="M6 18L18 6M6 6l12 12"
            />
          </svg>
        </button>

        <h2 className="text-2xl font-bold text-center mb-8 mt-2">Cancelar agendamento</h2>
        <p className="text-gray-700 mb-4 ml-2 mr-2">
          O reembolso acontecerá <span className="font-bold">APENAS</span> se o cancelamento for executado 24 horas antes do dia agendado.
        </p>
        <p className="text-gray-700 mb-1 ml-2 mr-2">
          Estação: <span className="font-bold">{estacao}</span>
        </p>
        <p className="text-gray-700 mb-1 ml-2 mr-2">
          Data: <span className="font-bold">{data}</span>
        </p>
        <p className="text-gray-700 mb-4 ml-2 mr-2">
          Hora: <span className="font-bold">{hora}</span>
        </p>
        <p className="text-gray-700 mb-8 ml-2 mr-2">
          Reembolso: <span className={`font-bold ${reembolsoDisponivel ? 'text-green-500' : 'text-red-500'}`}>
            {reembolsoDisponivel ? 'Disponível' : 'Indisponível'}
          </span>
        </p>
        <div className="flex justify-between">
          <button
            onClick={onCancelar}
            className="bg-green-500 text-white px-16 py-2 rounded-md hover:bg-green-600"
          >
            Voltar
          </button>
          <button
            onClick={onProsseguir}
            className="bg-[#FF6A6A] text-white px-16 py-2 rounded-md hover:bg-[#EF4444]"
          >
            Continuar
          </button>
        </div>
      </div>
    </div>
  );
};

export default ConfirmacaoCancelamentoMotoristaModal;

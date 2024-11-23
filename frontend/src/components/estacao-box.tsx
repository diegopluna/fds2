import React from 'react';

interface Address {
  cep: string;
  street: string;
  number: number;
  neighborhood: string;
  city: string;
  state: string;
}

interface EstacaoProps {
  nome: string;
  endereco: Address;
  precoMininimo: number;
  precoKwh: number;
  onDetalhes: () => void;
}

const EstacaoBox: React.FC<EstacaoProps> = ({
  nome,
  endereco,
  precoMininimo,
  precoKwh,
  onDetalhes,
}) => {
  return (
    <div className="flex justify-between items-center border border-gray-300 p-4 rounded-md mb-4 shadow-md">
      <div>
        <h2 className="text-lg font-bold mb-2 text-[#2D3648]">{nome}</h2>
        <p className="text-sm text-gray-600">
          {endereco.street}, Nº {endereco.number}, {endereco.neighborhood}, {endereco.city} - {endereco.state}
        </p>
        <p className="text-sm text-gray-600">314km</p>
        <p className="text-sm text-gray-600">
          R$ {precoMininimo}/min — R$ {precoKwh}/kWh
        </p>
      </div>
      <button
        onClick={onDetalhes}
        className="bg-[#00BC12] text-white px-4 py-2 rounded-md hover:bg-[#009c0f] transition"
      >
        Detalhes
      </button>
    </div>
  );
};

export default EstacaoBox;

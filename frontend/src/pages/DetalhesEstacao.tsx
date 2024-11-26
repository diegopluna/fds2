import { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import { DateTimePicker } from '@/components/datetime-picker';
import { Button } from '@/components/ui/button';
import { chargingStationsMock } from '@/mocks/chargingStationsMock';
import { Station } from '@/models/chargingStationsModel';
import { formatarHorario } from '@/utils/formatarHorario';

interface DetalhesEstacaoProps {
  stationId: string;
}

const DetalhesEstacao = ({ stationId }: DetalhesEstacaoProps) => {
  const [station, setStation] = useState<Station | null>(null);
  const [isLoading, setIsLoading] = useState(true);
  const [date, setDate] = useState<Date | undefined>(undefined);

  useEffect(() => {
    setIsLoading(true);
    const foundStation = chargingStationsMock.find((s) => s.stationId === stationId);
    console.log('Station ID:', stationId);
    setStation(foundStation || null);
    setIsLoading(false);
  }, [stationId]);

  if (isLoading) {
    return <p>Carregando...</p>;
  }

  if (!station) {
    return <p>Estação não encontrada!</p>;
  }

  return (
    <div className="container px-32 my-5">
      <div className="card row p-3 justify-content-center">
        <div className="card-body">
          < div className=' text-center'>
            <h2 className="text-[#2D3648] text-2xl font-bold mt-2">{station.name}</h2>
            <h3 className="text-[#2D3648] font-bold text-l mb-9 mt-2">
              <i>Detalhes da Estação</i>
            </h3>
          </div>
          <div className=" row ">
            <div className="col ">
              <h3 className="text-[#2D3648] font-bold text-l mb-2 mt-2">
                Informações gerais
              </h3>
              <p>Status: {station.status}</p>
              <p>
                Endereço: {station.stationAddress.street}, {station.stationAddress.number},{' '}
                {station.stationAddress.neighborhood}, {station.stationAddress.city} -{' '}
                {station.stationAddress.state}
              </p>
              <p>
                Horário de Funcionamento: {formatarHorario(station.workingHours.scheduleStart, station.workingHours.scheduleEnd)}
              </p>
              <p>Preço Mínimo: R$ {station.minimumPrice.toFixed(2)}</p>
              <p>Preço por KWh: R$ {station.pricePerKwh.toFixed(2)}</p>
              <p>Quantidade de Carregadores: {station.numberOfChargers}</p>
            </div>
            <div className="col d-flex flex-column">
              <div className="col flex ">
                <DateTimePicker value={date} onChange={setDate} min={new Date()} />          
              </div>
              <div className=" d-flex flex-column align-items-end">
              <Button variant="default" className="bg-green-500 text-white px-4 py-2 rounded-md hover:bg-green-600">
                 Agendar
                </Button>
                </div>
              </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default DetalhesEstacao;

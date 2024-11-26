import { useQuery } from '@tanstack/react-query';
import { StationsResponse} from  '@/models/chargingStationsModel';

const fetchStationsByDistance = async (): Promise<StationsResponse> => {
  const requestData = {
    latitude: -8.0602457,
    longitude: -34.8737749,
    distance: 5,
  };
  
  const authToken = localStorage.getItem('authToken'); 

  const response = await fetch('http://localhost:8081/supplier/station/fetch-by-distance', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      Authorization: `Bearer ${authToken}`, 
    },
    body: JSON.stringify(requestData),
  });

  if (!response.ok) {
    throw new Error('Erro ao buscar as estações');
  }

  return response.json();
};

export const useFetchStations = () => {
  return useQuery<StationsResponse>({
    queryKey: ['stations'],
    queryFn: fetchStationsByDistance,
    staleTime: 1000 * 60 * 5, // Dados são válidos por 5 minutos (evita requisições automáticas frequentes)
    refetchOnWindowFocus: false, // Não refaz requisição ao focar a janela
    refetchOnReconnect: false, // Não refaz requisição ao reconectar
    refetchOnMount: false, // Não refaz requisição ao montar o componente
  });
};

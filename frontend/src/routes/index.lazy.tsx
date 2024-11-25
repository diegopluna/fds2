import { useNavigate } from '@tanstack/react-router';
import { createLazyFileRoute } from '@tanstack/react-router';
import Card from '../components/card.tsx'; 
import openStreetMapImage from '../assets/open-street-map.png';

export const Route = createLazyFileRoute('/')({
  component: Index,
});

function Index() {
  const navigate = useNavigate();

  const handleMapClick = () => {
    navigate({ to: '/mapa' });
  };

  const handleAgendamentosClick = () => {
   navigate({ to: '/Agendamentos' });
  };

  return (
    <div  className='w-full'>
    <div className='pt-16 pb-16 pl-32 pr-32 grid grid-cols-1 md:grid-cols-2 gap-4'>
      <Card
        title='Acessar Mapa'
        description='Veja a localização no mapa.'
        onClick={handleMapClick}
        imageSrc={openStreetMapImage}
      />
      <Card
        title='Lista de Agendamentos'
        description='Gerencie seus agendamentos.'
        onClick={handleAgendamentosClick}
      />
    </div>
    </div>
  );
}

export default Index;

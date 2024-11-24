import { useNavigate } from '@tanstack/react-router';
import { createLazyFileRoute } from '@tanstack/react-router';
import Card from '../components/card.tsx'; 
import mapa from '../assets/mapa.png';
import agendamentos from '../assets/agendamentos.png';

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
      <h2 className="text-[#2D3648] text-2xl font-bold text-center mt-4">Bem vindo ao Ray Charge</h2>
    <div className='pt-8 pb-16 px-32 grid grid-cols-1 md:grid-cols-2 gap-4'>
      <Card
        title='Acessar Mapa'
        description='Veja a localização no mapa.'
        onClick={handleMapClick}
        imageSrc={mapa}
      />
      <Card
        title='Lista de Agendamentos'
        description='Gerencie seus agendamentos.'
        onClick={handleAgendamentosClick}
        imageSrc={agendamentos}
        
      />
    </div>
    </div>
  );
}

export default Index;

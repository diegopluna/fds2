import Card from '@/components/card'
import { createFileRoute, useNavigate } from '@tanstack/react-router'
import agendamentos from '../assets/agendamentos.png';
import mapa from '../assets/mapa.png';

export const Route = createFileRoute('/dashboard/')({
  component: Index,
})

function Index() {
  const navigate = useNavigate()

  const handleMapClick = () => {
    navigate({ to: '/dashboard/mapa' })
  }

  const handleAgendamentosClick = () => {
    navigate({ to: '/dashboard/schedules' })
  }

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

export default Index

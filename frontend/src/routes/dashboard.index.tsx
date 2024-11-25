import Card from '@/components/card'
import { createFileRoute, useNavigate } from '@tanstack/react-router'
import openStreetMapImage from '../assets/open-street-map.png'

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
    <div className="w-full">
      <div className="pt-16 pb-16 pl-32 pr-32 grid grid-cols-1 md:grid-cols-2 gap-4">
        <Card
          title="Acessar Mapa"
          description="Veja a localização no mapa."
          onClick={handleMapClick}
          imageSrc={openStreetMapImage}
        />
        <Card
          title="Lista de Agendamentos"
          description="Gerencie seus agendamentos."
          onClick={handleAgendamentosClick}
        />
      </div>
    </div>
  )
}

export default Index

import DetalhesEstacao from '@/pages/DetalhesEstacao'
import { createFileRoute } from '@tanstack/react-router'

export const Route = createFileRoute('/dashboard/station-details/$stationId')({
  component: ({ params }) => {
    const {stationId} = Route.useParams()
    console.log('Params:', params)
    return <DetalhesEstacao stationId={stationId} />
  },
  })
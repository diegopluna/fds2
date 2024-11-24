import DetalhesEstacao from '@/pages/DetalhesEstacao.tsx'
import { createFileRoute } from '@tanstack/react-router'

export const Route = createFileRoute('/detalhesEstacao/$stationId')({
  component: ({ params }) => {
    const {stationId} = Route.useParams()
    console.log('Params:', params)
    return <DetalhesEstacao stationId={stationId} />
  },
  })
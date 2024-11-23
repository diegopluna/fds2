import DetalhesEstacao from '@/pages/DetalhesEstacao'
import { createFileRoute } from '@tanstack/react-router'

export const Route = createFileRoute('/detalhesEstacao')({
  component: () => <DetalhesEstacao />,
})

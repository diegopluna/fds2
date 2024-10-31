import Agendamentos from '@/pages/Agendamentos'
import { createFileRoute } from '@tanstack/react-router'

export const Route = createFileRoute('/Agendamentos')({
  component: () => <Agendamentos/>,
})

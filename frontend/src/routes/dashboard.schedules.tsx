import Agendamentos from '@/pages/Agendamentos'
import { createFileRoute } from '@tanstack/react-router'

export const Route = createFileRoute('/dashboard/schedules')({
  component: () => <Agendamentos />,
})

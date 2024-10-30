import { createFileRoute } from '@tanstack/react-router'
import ListaDeAgendamento from '@/pages/pageListaDeAgendamento'

export const Route = createFileRoute('/listaDeAgendamento')({
  component: () => <ListaDeAgendamento />
});

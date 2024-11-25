import { Login } from '@/pages/Login'
import { createFileRoute, redirect } from '@tanstack/react-router'
import { z } from 'zod'

export const Route = createFileRoute('/login')({
  validateSearch: z.object({
    redirect: z.string().optional(),
  }),
  beforeLoad: ({ search }) => {
    if (localStorage.getItem('authToken') !== null) {
      throw redirect({to: search.redirect || '/dashboard' })
    }
  },
  component: () => <Login />,
})

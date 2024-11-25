import { createFileRoute, redirect } from '@tanstack/react-router'

export const Route = createFileRoute('/')({
  beforeLoad: () => {
    if (localStorage.getItem('authToken') !== null) {
      throw redirect({to: '/dashboard' })
    } else {
      throw redirect({to: '/login' })
    }
  },
})

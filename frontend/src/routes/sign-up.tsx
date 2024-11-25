import { SignUp } from '@/pages/SignUp'
import { createFileRoute, redirect } from '@tanstack/react-router'

export const Route = createFileRoute('/sign-up')({
  beforeLoad: () => {
    if (localStorage.getItem('authToken') !== null) {
      throw redirect({to: '/dashboard' })
    }
  },
  component: () => <SignUp />,
})

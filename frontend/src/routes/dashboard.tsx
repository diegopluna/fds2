import Footer from '@/components/footer'
import Navbar from '@/components/navbar'
import { createFileRoute, Outlet, redirect } from '@tanstack/react-router'

export const Route = createFileRoute('/dashboard')({
  beforeLoad: ({ location }) => {
    if (localStorage.getItem('authToken') === null) {
      throw redirect({
        to: '/login',
        search: {
          redirect: location.href
        }
      })
    }
  },
  component: DashboardLayout,
})

export function DashboardLayout() {
  return (
    <>
      <Navbar />
      <main className='flex flex-grow'>
        <Outlet />
      </main>
      <Footer />
    </>
  )
}
import Footer from '@/components/footer'
import Navbar from '@/components/navbar'
import { createRootRoute, Link, Outlet } from '@tanstack/react-router'
import { TanStackRouterDevtools } from '@tanstack/router-devtools'

export const Route = createRootRoute({
  component: () => (
    <>
      <div className="flex flex-col min-h-screen">

      <Navbar/>
      <main className='flex flex-grow'>
        <Outlet />
      </main>
      <Footer/>
      <TanStackRouterDevtools />
      </div>
    </>
  )
})



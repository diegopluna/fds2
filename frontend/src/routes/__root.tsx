import { Toaster } from '@/components/ui/sonner'
import { QueryClient } from '@tanstack/react-query'
import { createRootRouteWithContext, Outlet } from '@tanstack/react-router'
import { TanStackRouterDevtools } from '@tanstack/router-devtools'


interface RouterContext {
  queryClient: QueryClient
}

export const Route = createRootRouteWithContext<RouterContext>()({
  component: () => (
    <>
      <div className="flex flex-col min-h-screen">
        <Outlet />
        <TanStackRouterDevtools />
      </div>
      <Toaster />
    </>
  )
})



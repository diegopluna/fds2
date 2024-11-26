import { Button } from "@/components/ui/button"
import {
  Card,
  CardContent,
  CardHeader,
  CardTitle,
} from "@/components/ui/card"
import { Form, FormControl, FormField, FormItem, FormLabel } from "@/components/ui/form"
import { Input } from "@/components/ui/input"
import { auth } from "@/lib/auth"
import { zodResolver } from "@hookform/resolvers/zod"
import { Link, useNavigate } from '@tanstack/react-router'
import { useForm } from "react-hook-form"
import { toast } from "sonner"
import { z } from "zod"
import Footer from '@/components/footer'
import Navbar from '@/components/navbar-simple'

const formSchema = z.object({
    username: z.string(),
    password: z.string(),
})

export function SignUp() {
  const navigate = useNavigate()


  const form = useForm<z.infer<typeof formSchema>>({
    resolver: zodResolver(formSchema),
    defaultValues: {
        username: "",
        password: "",
    },
  })

  function onSubmit(values: z.infer<typeof formSchema>) {
    auth.signup(values.username, values.password, 'DRIVER')
    .then(() => {
        navigate({
          to: '/login',
        })
    })
    .catch(() => {
      toast.error('Error signing up')
      form.reset()
    })
  }

  return (
    <div className="flex flex-col h-screen">
    <Navbar />
      <div className="flex flex-grow justify-center items-center px-4 w-min-[500px] " >
          <Card className="mx-auto max-w-sm w-full">
          <CardHeader>
              <CardTitle className="text-2xl">Inscreva-se</CardTitle>
          </CardHeader>
          <CardContent>
            <Form {...form}>
              <form onSubmit={form.handleSubmit(onSubmit)}>
                <div className="grid gap-4">
                <FormField
                    control={form.control}
                    name="username"
                    render={({ field }) => (
                      <FormItem>
                        <FormLabel>Usuário</FormLabel>
                        <FormControl>
                          <Input {...field} />
                        </FormControl>
                      </FormItem>
                    )} 
                  />
                  <FormField
                    control={form.control}
                    name="password"
                    render={({ field }) => (
                      <FormItem>
                        <FormLabel>Senha</FormLabel>
                        <FormControl>
                          <Input type="password" {...field} />
                        </FormControl>
                      </FormItem>
                    )}
                  />
                  <Button type="submit" className="w-full bg-green-500 text-white rounded hover:bg-green-600">
                      Inscreva-se
                  </Button>
                </div>
                <div className="mt-4 text-center text-sm">
                  Já possui uma conta?{" "}
                  <Link to="/login" className="underline">
                      Login
                  </Link>
                </div>
              </form>
            </Form>
          </CardContent>
          </Card>
      </div>
      <Footer />
    </div>
  )
}

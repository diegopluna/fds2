import { toast } from "sonner"

interface Token {
    token: string
}

interface LoginRequest {
    login: string
    password: string
}

interface ErrorMessage {
    code: number
    message: string
}

type Role = 'DRIVER' | 'SUPPLIER'

interface SignUpRequest {
    login: string
    password: string
    role: Role
}



export const auth: Auth = {
    login: async (username, password) => {
        const body: LoginRequest = { login: username, password }
        try {
            const response = await fetch('http://localhost:8081/authentication/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(body)
                
            })
            if (response.ok) {
                const token: Token = await response.json()
                localStorage.setItem('authToken', token.token)
            } else {
                const error: ErrorMessage = await response.json()
                toast.error(error.message)
                throw new Error(error.message)
            }
        } catch (err ) {
            toast.error('Server not available')
            throw new Error('Server not available')
        }
    },
    logout: () => {
        localStorage.removeItem('authToken')
    },
    signup: async (username, password, role) => {
        const body: SignUpRequest = { login: username, password, role }
        try {
            const response = await fetch('http://localhost:8081/authentication/sign-up', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(body)
            })
            if (!response.ok) {
                const error: ErrorMessage = await response.json()
                toast.error(error.message)
                throw new Error()
            }

        } catch (error) {
            toast.error('Server not available')
            throw new Error()
        }
    }
}

export type Auth = {
    login: (username: string, password: string) => Promise<void>
    signup: (username: string, password: string, role: Role) => Promise<void>
    logout: () => void
}
package com.cesar.school.fds2.raycharge;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.NovosUsuarios;
import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.UsuarioRepositorio;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class Application {
		@Bean
		public NovosUsuarios novosUsuarios(UsuarioRepositorio repositorio) {
			return new NovosUsuarios(repositorio);
		}

    public static void main(String[] args) throws IOException {
		run(Application.class, args);
	}
}

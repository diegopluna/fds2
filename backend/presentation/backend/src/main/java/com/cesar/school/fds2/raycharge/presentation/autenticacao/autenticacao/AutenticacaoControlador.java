package com.cesar.school.fds2.raycharge.presentation.autenticacao.autenticacao;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.NovosUsuarios;
import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.Usuario;
import com.cesar.school.fds2.raycharge.presentation.BackendMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoControlador {

  private @Autowired NovosUsuarios novosUsuarios;
  private @Autowired BackendMapeador mapeador;

  @RequestMapping(method = POST, path = "registrar")
  public ResponseEntity<Void> registrar(@RequestBody AutenticacaoFormulario.UsuarioDto dto) {
    var novoUsuario = mapeador.map(dto, Usuario.class);
    int response = novosUsuarios.criarConta(novoUsuario.getLogin(), novoUsuario.getSenha(), novoUsuario.getTipoUsuario(), novoUsuario.getId());
    return response == -1 ? ResponseEntity.badRequest().build() : ResponseEntity.status(HttpStatus.CREATED).build();
  }
}

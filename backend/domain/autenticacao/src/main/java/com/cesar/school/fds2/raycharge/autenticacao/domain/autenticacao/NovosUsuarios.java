package com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao;

import org.jmolecules.ddd.annotation.Service;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Objects;


@Service
public class NovosUsuarios {
    private final UsuarioRepositorio usuarioRepositorio;

    public NovosUsuarios(UsuarioRepositorio usuarioRepositorio) {
        Objects.requireNonNull(usuarioRepositorio, "O repositório de usuários não pode ser nulo");
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public int criarConta(String login, String senha, TipoUsuario tipoUsuario, IdUsuario id) {
        if (usuarioRepositorio.findByLogin(login).isPresent()) {
            return -1;
        }
        String hashedPassword = BCrypt.hashpw(senha, BCrypt.gensalt());
        Usuario novoUsuario = new Usuario(id, login, hashedPassword, tipoUsuario);
        usuarioRepositorio.saveUsuario(novoUsuario);

        return novoUsuario.getId().getId();
    }
}
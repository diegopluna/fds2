package com.cesar.school.fds2.raycharge.infra.persistence.jpa;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.TipoUsuario;
import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.Usuario;
import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.UsuarioRepositorio;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Entity
@Table(name = "USUARIO")
public class UsuarioJpa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  @Column(unique = true)
  String login;

  String senha;

  @Enumerated(EnumType.STRING)
  TipoUsuario tipoUsuario;

}

interface UsuarioJpaRepository extends JpaRepository<UsuarioJpa, Integer> {
  Optional<UsuarioJpa> findUsuarioJpaByLogin(String login);
}

@Repository
class UsuarioRepositorioImpl implements UsuarioRepositorio {
  @Autowired
  UsuarioJpaRepository repositorio;

  @Autowired
  JpaMapeador mapeador;

  @Override
  public void saveUsuario(Usuario usuario) {
    var usuarioJpa = mapeador.map(usuario, UsuarioJpa.class);
    repositorio.save(usuarioJpa);
  }

  @Override
  public Optional<Usuario> findByLogin(String login) {
    var usuarioJpa = repositorio.findUsuarioJpaByLogin(login);
    return usuarioJpa.map(u -> mapeador.map(u, Usuario.class));
  }
}
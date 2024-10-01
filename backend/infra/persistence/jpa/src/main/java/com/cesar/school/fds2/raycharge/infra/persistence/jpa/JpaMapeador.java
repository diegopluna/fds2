package com.cesar.school.fds2.raycharge.infra.persistence.jpa;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;
import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.TipoUsuario;
import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.Usuario;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class JpaMapeador extends ModelMapper {
  JpaMapeador() {
    var configuracao = getConfiguration();
    configuracao.setFieldMatchingEnabled(true);
    configuracao.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    addConverter(new AbstractConverter<UsuarioJpa, Usuario>() {
      @Override
      protected Usuario convert(UsuarioJpa source) {
        var id = map(source.id, IdUsuario.class);
        var tipoUsuario = map(source.tipoUsuario, TipoUsuario.class);
        return new Usuario(id, source.login, source.senha, tipoUsuario);
      }
    });
  }
}

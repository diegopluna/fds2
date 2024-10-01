package com.cesar.school.fds2.raycharge.presentation;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;
import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.Usuario;
import com.cesar.school.fds2.raycharge.presentation.autenticacao.autenticacao.AutenticacaoFormulario;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class BackendMapeador extends ModelMapper {
  private final AtomicInteger idUsuarioGenerator = new AtomicInteger(1);

  BackendMapeador() {

    addConverter(new AbstractConverter<AutenticacaoFormulario.UsuarioDto, Usuario>() {
      @Override
      protected Usuario convert(AutenticacaoFormulario.UsuarioDto source) {
        return new Usuario(
            new IdUsuario(idUsuarioGenerator.getAndIncrement()),
            source.login,
            source.senha,
            source.tipoUsuario
        );
      }
    });
  }

  @Override
  public <D> D map(Object source, Class<D> destinationType) {
    return source != null ? super.map(source, destinationType) : null;
  }
}

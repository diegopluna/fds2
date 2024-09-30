package com.cesar.school.fds2.raycharge.motorista.domain.motorista;

import java.util.Optional;

import com.cesar.school.fds2.raycharge.autenticacao.domain.usuario.IdUsuario;

public interface MotoristaRepositorio {
    //Colocar metodos do Repositorio aqui
    void saveMotorista(Motorista motorista);
    Optional<Motorista> findById(IdMotorista idMotorista);
    Optional<Motorista> findByUsuarioMotorista(IdUsuario usuarioMotorista);
    void updateMotorista(Motorista motorista);
    void deleteMotorista(IdMotorista idMotorista);
}

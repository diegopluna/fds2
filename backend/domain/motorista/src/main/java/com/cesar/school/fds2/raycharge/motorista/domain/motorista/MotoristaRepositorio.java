package com.cesar.school.fds2.raycharge.motorista.domain.motorista;

import java.util.Optional;

import com.cesar.school.fds2.raycharge.autenticacao.domain.autenticacao.IdUsuario;
public interface MotoristaRepositorio {
    //Colocar metodos do Repositorio aqui
    void saveMotorista(Motorista motorista);
    Optional<Motorista> findMotoristaById(IdMotorista idMotorista);
    Optional<Motorista> findByUsuarioMotorista(IdUsuario usuarioMotorista);
    Optional<Motorista> updateMotorista(Motorista motorista);
    Optional<Motorista> deleteMotorista(IdMotorista idMotorista);
}

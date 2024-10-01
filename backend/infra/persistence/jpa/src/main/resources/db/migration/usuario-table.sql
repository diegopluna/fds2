CREATE TABLE USUARIO (
    ID int generated always as identity not null,
    login varchar not null unique,
    senha varchar not null,
    tipo_usuario varchar not null,
    primary key (ID)
)
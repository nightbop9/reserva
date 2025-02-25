package com.api.reserva.exception;

public class UsuarioDuplicadoException extends RuntimeException{
    public UsuarioDuplicadoException(){
        super("Email ou telefone já existentes.");
    }
}

package com.api.reserva.exception;

public class RegistroDuplicadoException extends RuntimeException{
    public RegistroDuplicadoException(){
        super("Email ou telefone já existentes.");
    }
}

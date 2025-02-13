package com.api.reserva.exception;

public class AmbienteDuplicadoException extends RuntimeException{
    public AmbienteDuplicadoException(){
        super("Nome ou identificacao já existentes.");
    }
}

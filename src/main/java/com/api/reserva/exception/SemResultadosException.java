package com.api.reserva.exception;

public class SemResultadosException extends RuntimeException{
    private String message;
    private String acao;

    public SemResultadosException(){
        super("Sem resultados.");
    }

    public SemResultadosException(String acao) {
        super("Entidade não encontrada para " + acao);
        this.acao = acao;
    }
}

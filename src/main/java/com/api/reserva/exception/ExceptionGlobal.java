package com.api.reserva.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
//Captura exceções globais com Status e Mensagem dedicada
public class ExceptionGlobal {

    //Trata requisicoes sem resultados
    @ExceptionHandler(SemResultadosException.class)
    public ResponseEntity<String> handler(SemResultadosException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    //Trata requisicoes com usuario duplicado
    @ExceptionHandler(UsuarioDuplicadoException.class)
    public ResponseEntity<String> handler(UsuarioDuplicadoException e){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

    //Trata campos invalidos


    //Trata erros internos no servidor
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro interno no servidor. Tente novamente mais tarde.");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handler(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Verifique o campo " + e.getMessage() + "e tente novamente.");
    }


    //Trata campos invalidos através de validação
    @ExceptionHandler(MethodArgumentNotValidException.class)
    //Trata campos invalidos através de validação com lista
    public ResponseEntity<List<String>> handler (MethodArgumentNotValidException e){
        //Pega os erros de validação
        List<String> erros = e.getBindingResult()
                //Pega a lista de erros
                .getFieldErrors()
                //Mapeia os erros
                .stream()
                //Para cada erro, formata a mensagem
                .map(erro -> String.format("O campo %s é obrigatório.", erro.getField()))
                //Transforma em lista
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(erros);
    }


}

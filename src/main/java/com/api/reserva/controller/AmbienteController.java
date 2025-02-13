package com.api.reserva.controller;

import com.api.reserva.dto.AmbienteCadastroDTO;
import com.api.reserva.exception.AmbienteDuplicadoException;
import com.api.reserva.service.AmbienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ambiente")
public class AmbienteController {

    @Autowired
    AmbienteService ambienteService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar (@RequestBody AmbienteCadastroDTO ambienteCadastro){
        try{
            ambienteService.cadastrar(ambienteCadastro.getAmbience(), ambienteCadastro.getGridDay());
            return new ResponseEntity<>("Ambiente cadastrado com sucesso!", HttpStatus.OK);
        } catch (AmbienteDuplicadoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar ambiente." + e.getMessage());
        }
    }
}

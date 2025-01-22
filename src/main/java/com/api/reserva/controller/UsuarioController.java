package com.api.reserva.controller;

import com.api.reserva.dto.UsuarioDTO;
import com.api.reserva.exception.SemResultadosException;
import com.api.reserva.exception.RegistroDuplicadoException;
import com.api.reserva.model.UsuarioModel;
import com.api.reserva.service.UsuarioService;
import com.api.reserva.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listarTudo() {
        try {
            List<UsuarioModel> pessoas = service.listarTudo();
            return ResponseEntity.ok(pessoas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Messages.erroGenerico("Erro ao buscar usuários.") + e.getMessage());
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listar(@PathVariable Long id) {
        try {
            UsuarioModel pessoa = service.listar(id);
            return ResponseEntity.ok(pessoa);
        } catch (SemResultadosException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Messages.erroGenerico("Erro ao buscar usuário.") + e.getMessage());
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioDTO user) {
        try {
            service.cadastrar(user);
            return new ResponseEntity<>("Usuário cadastrado com sucesso!", HttpStatus.OK);
        } catch (RegistroDuplicadoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Messages.erroGenerico("Erro ao cadastrar usuário.") + e.getMessage());
        }
    }

    @PutMapping("/atualizartudo/{id}")
    public ResponseEntity<?> atualizarTudo(@RequestBody UsuarioDTO user, @PathVariable Long id) {
        try {
            service.atualizarTudo(user, id);
            return new ResponseEntity<>("Usuário atualizado com sucesso!", HttpStatus.OK);
        } catch (SemResultadosException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (RegistroDuplicadoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Messages.erroGenerico("Erro ao atualizar usuário.") + e.getMessage());
        }
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar (@RequestBody UsuarioDTO user, @PathVariable Long id){
        try{
            service.atualizar(user, id);
            return new ResponseEntity<>("Usuário atualizado com sucesso!" + user, HttpStatus.OK);
        } catch (SemResultadosException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (RegistroDuplicadoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Messages.erroGenerico("Erro ao atualizar usuário.") + e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return new ResponseEntity<>("Usuário excluído com sucesso!", HttpStatus.OK);
        } catch (SemResultadosException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Messages.erroGenerico("Erro ao excluir ambiente.") + e.getMessage());
        }
    }
}
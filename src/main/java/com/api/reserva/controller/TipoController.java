package com.api.reserva.controller;

import com.api.reserva.dto.TipoDTO;
import com.api.reserva.service.TipoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador responsável por gerenciar as requisições relacionadas a entidade Tipo.
 */

@RestController
@RequestMapping("tipo")
public class TipoController {
    @Autowired
    TipoService service;

    @GetMapping("/listar")
    public ResponseEntity<List<TipoDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<TipoDTO> listar(@PathVariable Long id){
        return ResponseEntity.ok(service.listar(id));
    }

    @PostMapping("/salvar")
    public ResponseEntity<TipoDTO> salvar(@Valid @RequestBody TipoDTO tipoDTO){
        return ResponseEntity.ok(service.salvar(tipoDTO));
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<TipoDTO> atualizar(@Valid @PathVariable Long id, @RequestBody TipoDTO tipoDTO){
        return ResponseEntity.ok(service.atualizar(id, tipoDTO));
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}

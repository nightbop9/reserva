package com.api.reserva.controller;

import com.api.reserva.dto.PessoaDTO;
import com.api.reserva.model.PessoaModel;
import com.api.reserva.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
    @Autowired
    PessoaRepository repository;

    @GetMapping("/listar")
    public List<PessoaModel> listarPessoa(){
        return repository.findAll();
    }

    @PostMapping("/cadastrar")
    public void cadastrarPessoa(@RequestBody PessoaDTO person){
        PessoaModel pessoa = new PessoaModel(person);
        repository.save(pessoa);
    }


}

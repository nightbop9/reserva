package com.api.reserva.service;

import com.api.reserva.dto.UsuarioDTO;
import com.api.reserva.enums.UsuarioStatus;
import com.api.reserva.exception.RegistroDuplicadoException;
import com.api.reserva.exception.SemResultadosException;
import com.api.reserva.model.UsuarioModel;
import com.api.reserva.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    //Listar uma pessoa
    public UsuarioModel listar(Long id) {
        return repository.findById(id).orElseThrow(() -> new SemResultadosException());
    }

    //Listar todas as pessoas
    public List<UsuarioModel> listarTudo() {
        return repository.findAll();
    }

    //Cadastrar pessoa
    public void cadastrar(UsuarioDTO user) {
        //validação de duplicidade
        if (repository.existsByEmailOrTelefone(user.email(), user.telefone())) {
            throw new RegistroDuplicadoException();
        }
        //conversão do DTO para a entidade e definição do status
        UsuarioModel pessoa = new UsuarioModel(user);
        pessoa.setStatus(UsuarioStatus.ativo);
        repository.save(pessoa);
    }

    //Atualizar pessoa
    public void atualizarTudo(UsuarioDTO user, Long id) {
        //verificando existencia no banco
        UsuarioModel usuario = repository.findById(id).orElseThrow(() -> new SemResultadosException("atualização."));

        if (repository.existsByEmailOrTelefoneAndIdNot(user.email(), user.telefone(), id)) {
            throw new RegistroDuplicadoException();
        }
        usuario.setNome(user.nome());
        usuario.setEmail(user.email());
        usuario.setSenha(user.senha());
        usuario.setTelefone(user.telefone());
        usuario.setGenero(user.genero());
        usuario.setStatus(user.status());
        repository.save(usuario);


    }

    public void atualizar(UsuarioDTO user, Long id) {
        UsuarioModel usuario = repository.findById(id).orElseThrow(() -> new SemResultadosException("atualização."));

        if (user.email() != null || user.telefone() != null) {
            if (repository.existsByEmailOrTelefoneAndIdNot(user.email(), user.telefone(), id)) {
                throw new RegistroDuplicadoException();
            }
        }

        if (user.nome() != null) {
            usuario.setNome(user.nome());
        }

        if (user.email() != null) {
            usuario.setEmail(user.email());
        }

        if (user.senha() != null) {
            usuario.setSenha(user.senha());
        }

        if (user.telefone() != null) {
            usuario.setTelefone(user.telefone());
        }

        if (user.genero() != null) {
            usuario.setGenero(user.genero());
        }

        if (user.status() != null) {
            usuario.setStatus(user.status());
        }
        System.out.println(usuario);
        repository.save(usuario);
    }

    //Deletar pessoa
    public void deletar(Long id) {
        repository.findById(id).orElseThrow(() -> new SemResultadosException("exclusão."));
        repository.deleteById(id);
    }


}
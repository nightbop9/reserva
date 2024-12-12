package com.api.reserva.model;

import com.api.reserva.dto.PessoaDTO;
import com.api.reserva.service.PessoaGenero;
import com.api.reserva.service.PessoaStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "pessoa")
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String ddd;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private PessoaGenero genero;
    @Enumerated(EnumType.STRING)
    private PessoaStatus status;

    public PessoaModel() {}

    public PessoaModel(PessoaDTO person) {
        this.id = person.id();
        this.nome = person.nome();
        this.email = person.email();
        this.senha = person.senha();
        this.ddd = person.ddd();
        this.telefone = person.telefone();
        this.genero = person.genero();
        this.status = person.status();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public PessoaGenero getGenero() {
        return genero;
    }

    public void setGenero(PessoaGenero genero) {
        this.genero = genero;
    }

    public PessoaStatus getStatus() {
        return status;
    }

    public void setStatus(PessoaStatus status) {
        this.status = status;
    }

}

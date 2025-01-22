package com.api.reserva.model;

import com.api.reserva.dto.UsuarioDTO;
import com.api.reserva.enums.UsuarioGenero;
import com.api.reserva.enums.UsuarioStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private UsuarioGenero genero;
    @Enumerated(EnumType.STRING)
    private UsuarioStatus status;

    public UsuarioModel() {}

    public UsuarioModel(UsuarioDTO user) {
        this.id = user.id();
        this.nome = user.nome();
        this.email = user.email();
        this.senha = user.senha();
        this.telefone = user.telefone();
        this.genero = user.genero();
        this.status = user.status();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public UsuarioGenero getGenero() {
        return genero;
    }

    public void setGenero(UsuarioGenero genero) {
        this.genero = genero;
    }

    public UsuarioStatus getStatus() {
        return status;
    }

    public void setStatus(UsuarioStatus status) {
        this.status = status;
    }
}

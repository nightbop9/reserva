package com.api.reserva.dto;

import com.api.reserva.entity.Usuario;
import com.api.reserva.enums.UsuarioGenero;
import com.api.reserva.enums.UsuarioRole;
import com.api.reserva.enums.UsuarioStatus;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioDTO{
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String senha;
    private String telefone;
    @Column(nullable = false)
    private UsuarioGenero genero;
    @Column(nullable = false)
    private UsuarioStatus status;
    @Column(nullable = false)
    private UsuarioRole role;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String nome, String email, String senha, String telefone,
                      UsuarioGenero genero, UsuarioStatus status, UsuarioRole role) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.genero = genero;
        this.status = status;
        this.role = role;
    }

    public String tratarTelefone(String telefone) {
        return telefone.replaceAll("[^0-9]", "");
    }

    public UsuarioDTO(Usuario usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        email = usuario.getEmail();
        senha = usuario.getSenha();
        telefone = usuario.getTelefone();
        genero = usuario.getGenero();
        status = usuario.getStatus();
        role = usuario.getRole();
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

    public UsuarioRole getRole() {
        return role;
    }

    public void setRole(UsuarioRole role) {
        this.role = role;
    }
}

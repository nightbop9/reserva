package com.api.reserva.dto;

import com.api.reserva.entity.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TipoDTO {
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 20, message = "Nome deve ter entre 3 e 20 caracteres")
    private String nome;

    public TipoDTO() {
    }

    public TipoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoDTO(Tipo tipo) {
        id = tipo.getId();
        nome = tipo.getNome();
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

}

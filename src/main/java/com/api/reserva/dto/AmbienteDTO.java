package com.api.reserva.dto;

import com.api.reserva.entity.Ambiente;
import com.api.reserva.enums.Aprovacao;
import com.api.reserva.enums.Disponivel;
import com.api.reserva.enums.Tipo;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AmbienteDTO {
    private Long id;
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 20, message = "Nome deve ter entre 2 e 20 caracteres")
    private String nome;
    private String descricao;
    @NotBlank(message = "Identificação é obrigatória")
    @Column(unique = true)
    @Size(min = 3, max = 6, message = "Identificação deve ter entre 3 e 6 caracteres")
    private String identificacao;
    private Tipo tipo;
    @NotBlank(message = "Disponibilidade é obrigatória")
    private Disponivel disponivel;
    @NotBlank(message = "Tipo de aprovação é obrigatória")
    private Aprovacao aprovacao;

    public AmbienteDTO() {}

    public AmbienteDTO(Long id, String nome, String descricao, String identificacao, Tipo tipo, Disponivel disponivel, Aprovacao aprovacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.identificacao = identificacao;
        this.tipo = tipo;
        this.disponivel = disponivel;
        this.aprovacao = aprovacao;
    }

    public AmbienteDTO(Ambiente ambience) {
        nome = ambience.getNome();
        descricao = ambience.getDescricao();
        identificacao = ambience.getIdentificacao();
        tipo = ambience.getTipo();
        disponivel = ambience.getDisponivel();
        aprovacao = ambience.getAprovacao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Disponivel getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Disponivel disponivel) {
        this.disponivel = disponivel;
    }

    public Aprovacao getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(Aprovacao aprovacao) {
        this.aprovacao = aprovacao;
    }
}
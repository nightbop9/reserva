package com.api.reserva.model;

import com.api.reserva.dto.AmbienteDTO;
import com.api.reserva.enums.AmbienteAprovacao;
import com.api.reserva.enums.AmbienteDisponibilidade;
import jakarta.persistence.*;

@Entity
@Table(name = "ambiente")
public class AmbienteModel {

    //atributos da entidade
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ambiente")
    private Long id;
    private String nome;
    private String descricao;
    private String identificacao;
    @Enumerated(EnumType.STRING)
    AmbienteDisponibilidade disponibilidade;
    @Enumerated(EnumType.STRING)
    AmbienteAprovacao aprovacao;

    public AmbienteModel(){}

    //criando um novo ambiente a partir de um dto
    public AmbienteModel(AmbienteDTO ambience) {
        this.id = ambience.id();
        this.nome = ambience.nome();
        this.descricao = ambience.descricao();
        this.identificacao = ambience.identificacao();
        this.disponibilidade = ambience.disponibilidade();
        this.aprovacao = ambience.aprovacao();
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public AmbienteDisponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(AmbienteDisponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public AmbienteAprovacao getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(AmbienteAprovacao aprovacao) {
        this.aprovacao = aprovacao;
    }
}

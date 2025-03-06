package com.api.reserva.entity;

import com.api.reserva.dto.TipoDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_tipo")
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String nome;

    public Tipo() {
    }

    public Tipo(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Tipo(TipoDTO tag) {
        id = tag.id();
        nome = tag.nome();
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

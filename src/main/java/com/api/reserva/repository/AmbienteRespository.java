package com.api.reserva.repository;

import com.api.reserva.model.AmbienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmbienteRespository extends JpaRepository<AmbienteModel, Long> {
    //verificar se já existe um ambiente com os mesmos atributos
    boolean existsByNomeOrIdentificacao(String nome, String identificacao);
}

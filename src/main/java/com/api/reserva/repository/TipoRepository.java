package com.api.reserva.repository;

import com.api.reserva.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {
    //verifica se existe um tipo com o nome passado (usado para cadastro)
    boolean existsByNome(String name);
    //verifica se existe um tipo com o nome passado e id diferente do passado,
    //excluindo o tipo atual da verificação (usado para atualização)
    boolean existsByNomeAndIdNot(String nome, Long id);
}

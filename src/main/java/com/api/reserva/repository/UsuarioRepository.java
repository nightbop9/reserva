package com.api.reserva.repository;

import com.api.reserva.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //verificação de registros duplicados ao cadastrar
    boolean existsByEmailOrTelefone(String email, String telefone);

    //buscando registros duplicados para put/patch, suporta dados parciais e nulos
    @Query("SELECT COUNT(u) > 0 " +
            "FROM Usuario u " +
            "WHERE u.id <> :id " +
            "AND ((:email is not null AND u.email = :email) " +
            "     OR (:telefone is not null AND u.telefone = :telefone))")
    boolean existsByEmailOrTelefoneAndIdNot(@Param("email") String email,
                                                    @Param("telefone") String telefone,
                                                    @Param("id") Long id);


}

package com.api.reserva.dto;

import com.api.reserva.enums.UsuarioGenero;
import com.api.reserva.enums.UsuarioStatus;

public record UsuarioDTO(Long id, String nome, String email, String senha, String telefone, UsuarioGenero genero, UsuarioStatus status) {

}

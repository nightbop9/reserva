package com.api.reserva.dto;

import com.api.reserva.service.PessoaGenero;
import com.api.reserva.service.PessoaStatus;

public record PessoaDTO(Long id, String nome, String email, String senha, String ddd, String telefone, PessoaGenero genero, PessoaStatus status) {
}

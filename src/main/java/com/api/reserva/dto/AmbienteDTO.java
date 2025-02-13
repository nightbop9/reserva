package com.api.reserva.dto;

import com.api.reserva.enums.AmbienteAprovacao;
import com.api.reserva.enums.AmbienteDisponibilidade;

public record AmbienteDTO (Long id, String nome, String descricao, String identificacao, AmbienteDisponibilidade disponibilidade, AmbienteAprovacao aprovacao){
}

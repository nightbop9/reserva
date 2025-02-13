package com.api.reserva.dto;

import com.api.reserva.enums.GradeDiaSemana;
import com.api.reserva.model.AmbienteModel;
import com.api.reserva.model.GradeHorarioModel;

import java.util.List;

/**
 * Data Transfer Object (DTO) para GradeDia.
 *
 * @param id Identificador único da GradeDia.
 * @param ambiente Ambiente associado à GradeDia.
 * @param dias Lista de dias da semana associados à GradeDia.
 */
public record GradeDiaDTO (Long id, AmbienteModel ambiente, List<GradeDiaSemana> dias, List<GradeHorarioModel> horarios){
}
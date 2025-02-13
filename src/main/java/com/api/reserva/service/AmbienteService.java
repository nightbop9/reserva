package com.api.reserva.service;

import com.api.reserva.dto.AmbienteDTO;
import com.api.reserva.dto.GradeDiaDTO;
import com.api.reserva.enums.GradeDiaSemana;
import com.api.reserva.exception.AmbienteDuplicadoException;
import com.api.reserva.model.AmbienteModel;
import com.api.reserva.model.GradeDiaModel;
import com.api.reserva.model.GradeHorarioModel;
import com.api.reserva.repository.AmbienteRespository;
import com.api.reserva.repository.GradeDiaRepository;
import com.api.reserva.repository.GradeHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Serviço responsável pelas operações relacionadas ao Ambiente.
 */
@Service
public class AmbienteService {
    @Autowired
    AmbienteRespository ambienteRespository;
    @Autowired
    GradeDiaRepository gradeDiaRepository;
    @Autowired
    GradeHorarioRepository gradeHorarioRepository;

    /**
     * Cadastra um novo ambiente e sua grade de dias.
     *
     * @param ambience o DTO contendo as informações do ambiente.
     * @param gridDay  o DTO contendo as informações da grade de dias.
     * @throws AmbienteDuplicadoException se já existir um ambiente com o mesmo nome ou identificação.
     */
    public void cadastrar(AmbienteDTO ambience, GradeDiaDTO gridDay) {
        if (ambienteRespository.existsByNomeOrIdentificacao(ambience.nome(), ambience.identificacao())) {
            throw new AmbienteDuplicadoException();
        }

        // Cria uma nova instância de AmbienteModel com base no DTO fornecido
        AmbienteModel ambiente = new AmbienteModel(ambience);

        // Salva a instância de AmbienteModel no repositório
        ambienteRespository.save(ambiente);

        // Itera sobre a lista de dias em gridDay e cria uma nova instância de GradeDiaModel para cada dia
        for (GradeDiaSemana diaSemana : gridDay.dias()) {
            GradeDiaModel gradeDia = new GradeDiaModel();
            gradeDia.setAmbiente(ambiente);
            gradeDia.setDiaSemana(diaSemana);
            gradeDiaRepository.save(gradeDia);

            for (GradeHorarioModel horario : gridDay.horarios()) {
                
                GradeHorarioModel gradeHorario = new GradeHorarioModel();
                gradeHorario.setGradeDia(gradeDia);
                gradeHorario.setHorarioAbertura(horario.getHorarioAbertura());
                gradeHorario.setHorarioFechamento(horario.getHorarioFechamento());

                gradeHorarioRepository.save(gradeHorario);
            }
        }
    }
}
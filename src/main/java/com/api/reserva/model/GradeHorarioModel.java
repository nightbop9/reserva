package com.api.reserva.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Representa o modelo de GradeHorario.
 */
@Entity
@Table(name = "grade_horario")
public class GradeHorarioModel {

    /**
     * Identificador único da GradeHorario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grade_horario")
    private Long id;

    /**
     * GradeDia associada à GradeHorario.
     */
    @ManyToOne
    @JoinColumn(name = "id_grade_dia")
    private GradeDiaModel gradeDia;

    /**
     * Horário de abertura da GradeHorario.
     */
    private LocalTime horarioAbertura;

    /**
     * Horário de fechamento da GradeHorario.
     */
    private LocalTime horarioFechamento;

    /**
     * Construtor padrão.
     */
    public GradeHorarioModel() {
    }

    /**
     * Obtém o identificador da GradeHorario.
     *
     * @return o identificador da GradeHorario.
     */
    public Long getId() {
        return id;
    }


    /**
     * Obtém a GradeDia associada à GradeHorario.
     *
     * @return a GradeDia associada.
     */
    public GradeDiaModel getGradeDia() {
        return gradeDia;
    }

    /**
     * Define a GradeDia associada à GradeHorario.
     *
     * @param gradeDia a GradeDia a ser associada.
     */
    public void setGradeDia(GradeDiaModel gradeDia) {
        this.gradeDia = gradeDia;
    }

    /**
     * Obtém o horário de abertura da GradeHorario.
     *
     * @return o horário de abertura.
     */
    public LocalTime getHorarioAbertura() {
        return horarioAbertura;
    }

    /**
     * Define o horário de abertura da GradeHorario.
     *
     * @param horarioAbertura o horário de abertura a ser definido.
     */
    public void setHorarioAbertura(LocalTime horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    /**
     * Obtém o horário de fechamento da GradeHorario.
     *
     * @return o horário de fechamento.
     */
    public LocalTime getHorarioFechamento() {
        return horarioFechamento;
    }

    /**
     * Define o horário de fechamento da GradeHorario.
     *
     * @param horarioFechamento o horário de fechamento a ser definido.
     */
    public void setHorarioFechamento(LocalTime horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }
}
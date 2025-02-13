package com.api.reserva.model;

import com.api.reserva.enums.GradeDiaSemana;
import jakarta.persistence.*;

import java.util.List;

/**
 * Representa o modelo de GradeDia.
 */
@Entity
@Table(name = "grade_dia")
public class GradeDiaModel {

    /**
     * Identificador único da GradeDia.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grade_dia")
    private Long id;

    /**
     * Ambiente associado à GradeDia.
     */
    @ManyToOne
    @JoinColumn(name = "id_ambiente")
    private AmbienteModel ambiente;

    /**
     * Dia da semana associado à GradeDia.
     */
    @Enumerated(EnumType.STRING)
    private GradeDiaSemana diaSemana;

    @OneToMany(mappedBy = "gradeDia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GradeHorarioModel> horarios;


    /**
     * Construtor padrão.
     */
    public GradeDiaModel() {
    }

    /**
     * Construtor que inicializa a GradeDia com base no ambiente e no dia da semana fornecido.
     *
     * @param ambiente  o ambiente associado.
     * @param diaSemana o dia da semana associado.
     */
    public GradeDiaModel(AmbienteModel ambiente, GradeDiaSemana diaSemana) {
        this.ambiente = ambiente;
        this.diaSemana = diaSemana;
    }

    /**
     * Obtém o identificador da GradeDia.
     *
     * @return o identificador da GradeDia.
     */
    public Long getId() {
        return id;
    }

    /**
     * Obtém o ambiente associado à GradeDia.
     *
     * @return o ambiente associado.
     */
    public AmbienteModel getAmbiente() {
        return ambiente;
    }

    /**
     * Define o ambiente associado à GradeDia.
     *
     * @param ambiente o ambiente a ser associado.
     */
    public void setAmbiente(AmbienteModel ambiente) {
        this.ambiente = ambiente;
    }

    /**
     * Obtém o dia da semana associado à GradeDia.
     *
     * @return o dia da semana associado.
     */
    public GradeDiaSemana getDiaSemana() {
        return diaSemana;
    }

    /**
     * Define o dia da semana associado à GradeDia.
     *
     * @param diaSemana o dia da semana a ser associado.
     */
    public void setDiaSemana(GradeDiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }
}
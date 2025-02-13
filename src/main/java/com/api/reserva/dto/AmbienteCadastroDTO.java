package com.api.reserva.dto;

public class AmbienteCadastroDTO {
    AmbienteDTO ambience;
    GradeDiaDTO gridDay;

    public AmbienteDTO getAmbience() {
        return ambience;
    }

    public void setAmbience(AmbienteDTO ambience) {
        this.ambience = ambience;
    }

    public GradeDiaDTO getGridDay() {
        return gridDay;
    }

    public void setGridDay(GradeDiaDTO gridDay) {
        this.gridDay = gridDay;
    }

}

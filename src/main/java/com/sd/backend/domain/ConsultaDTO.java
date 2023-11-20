package com.sd.backend.domain;

import com.sd.backend.model.Consulta;
import com.sd.backend.model.Paciente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String pressaoArterial;

    private String frequenciaCardiaca;

    private String nivelOxigenio;

    private Paciente paciente;

    private String sintomas;

    private String diagnostico;

    public ConsultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.pressaoArterial = consulta.getPressaoArterial();
        this.frequenciaCardiaca = consulta.getFrequenciaCardiaca();
        this.nivelOxigenio = consulta.getNivelOxigenio();
        this.paciente = consulta.getPaciente();
        this.sintomas = consulta.getSintomas();
        this.diagnostico = consulta.getDiagnostico();
    }
}

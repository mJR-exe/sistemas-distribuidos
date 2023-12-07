package com.sd.backend.domain;

import com.sd.backend.model.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO implements Serializable {

    private Long id;

    private String nome;

    private String dataNascimento;

    private String sexo;

    private Boolean fuma;

    private Boolean bebe;

    private Boolean praticaExercicio;

    private Boolean infartou;

    private Boolean alimentacao;

    private String descricaoSintomas;

    public PacienteDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.dataNascimento = paciente.getDataNascimento();
        this.sexo = paciente.getSexo();
        this.fuma = paciente.getFuma();
        this.bebe = paciente.getBebe();
        this.praticaExercicio = paciente.getPraticaExercicio();
        this.infartou = paciente.getInfartou();
        this.alimentacao = paciente.getAlimentacao();
        this.descricaoSintomas = paciente.getDescricaoSintomas();
    }
}

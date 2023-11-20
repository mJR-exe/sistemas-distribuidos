package com.sd.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_consulta")
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pressaoArterial;

    private String frequenciaCardiaca;

    private String nivelOxigenio;

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private String sintomas;

    private String diagnostico;
}

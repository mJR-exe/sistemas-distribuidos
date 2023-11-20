package com.sd.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_category")
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;

    @NotBlank(message = "Campo Data de Nascimento é obrigatório")
    private OffsetDateTime dataNascimento;

    @NotBlank(message = "Campo sexo é obrigatório")
    private String sexo;

    private Boolean fuma;

    private Boolean bebe;

    private Boolean praticaExercicio;

    private Boolean infartou;

    private Boolean alimentacao;

    private String descricaoSintomas;

    @OneToOne(mappedBy = "paciente")
    private Consulta consulta;
}

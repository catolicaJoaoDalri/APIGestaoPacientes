package com.joaod.APIGestaoPacientes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "consultas")
public class ConsultaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomeConsulta;

    private int codigoUrgenciaConsulta;

    private Double precoConsulta;

    private Date dataConsulta = new Date();

    @ManyToOne
    private PacienteModel paciente;
}

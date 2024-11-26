package com.joaod.APIGestaoPacientes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "pacientes")
public class PacienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private Date dataCadastro = new Date();

    @ManyToOne
    private ConsultaModel consulta;
}

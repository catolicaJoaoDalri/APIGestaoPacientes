package com.joaod.APIGestaoPacientes.respository;

import com.joaod.APIGestaoPacientes.model.ConsultaModel;
import com.joaod.APIGestaoPacientes.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PacienteRepository extends JpaRepository<PacienteModel, Integer> {

}

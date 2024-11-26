package com.joaod.APIGestaoPacientes.respository;

import com.joaod.APIGestaoPacientes.model.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<ConsultaModel, Integer> {
    @Query("SELECT c FROM ConsultaModel c WHERE c.paciente.id = :idPaciente")
    public List<ConsultaModel> findByIdPaciente(@Param("idPaciente") int idPaciente);
}

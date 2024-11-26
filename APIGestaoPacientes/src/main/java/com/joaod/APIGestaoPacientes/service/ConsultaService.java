package com.joaod.APIGestaoPacientes.service;

import com.joaod.APIGestaoPacientes.model.ConsultaModel;
import com.joaod.APIGestaoPacientes.model.PacienteModel;
import com.joaod.APIGestaoPacientes.respository.ConsultaRepository;
import com.joaod.APIGestaoPacientes.respository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PacienteService pacienteService;

    public void criarConsulta(ConsultaModel consulta) {
        if (Objects.nonNull(consulta.getPaciente())) {
            PacienteModel paciente = pacienteRepository.findById(consulta.getPaciente().getId()).orElse(null);

            if (Objects.nonNull(paciente)) {
                consulta = consultaRepository.save(consulta);

                paciente.setConsulta(consulta);
                pacienteRepository.save(paciente);
            }
        } else {
            consultaRepository.save(consulta);
        }
    }

    public void deletarConsulta(Integer id){
        ConsultaModel consulta = consultaRepository.findById(id).get();

        if (Objects.nonNull(consulta.getPaciente())){
            pacienteRepository.deleteById(consulta.getPaciente().getId());
            consultaRepository.delete(consulta);
        }
    }

    public void editarConsulta(ConsultaModel consultaEditar, int id){
        ConsultaModel consultaBanco = consultaRepository.findById(id).get();

        consultaBanco.setDataConsulta(consultaEditar.getDataConsulta());
        consultaBanco.setPaciente(consultaEditar.getPaciente());
        consultaBanco.setPrecoConsulta(consultaEditar.getPrecoConsulta());
        consultaBanco.setNomeConsulta(consultaEditar.getNomeConsulta());

        consultaRepository.save(consultaBanco);
    }

    public List<ConsultaModel> listarConsultasPacientes(int idPaciente){
        try {
            return consultaRepository.findByIdPaciente(idPaciente);
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }

    }
}

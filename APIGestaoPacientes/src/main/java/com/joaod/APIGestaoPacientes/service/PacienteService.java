package com.joaod.APIGestaoPacientes.service;

import com.joaod.APIGestaoPacientes.model.ConsultaModel;
import com.joaod.APIGestaoPacientes.model.PacienteModel;
import com.joaod.APIGestaoPacientes.respository.ConsultaRepository;
import com.joaod.APIGestaoPacientes.respository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository ;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ConsultaRepository consultaRepository;

    public void criarPaciente(PacienteModel paciente) {
        try {
            pacienteRepository.save(paciente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editarPaciente(PacienteModel paciente, Integer idPaciente) {
        try {
            PacienteModel pacienteParaEditar = pacienteRepository.findById(idPaciente).get();

            pacienteParaEditar.setConsulta(paciente.getConsulta());
            pacienteParaEditar.setCpf(paciente.getCpf());
            pacienteParaEditar.setEmail(paciente.getEmail());
            pacienteParaEditar.setTelefone(paciente.getTelefone());

            repository.save(pacienteParaEditar);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void adicionarConsulta(Integer idPaciente, Integer idConsulta) {
        ConsultaModel consultaAdicionar = consultaRepository.findById(idConsulta).get();
        PacienteModel paciente = pacienteRepository.findById(idPaciente).get();

        paciente.setConsulta(consultaAdicionar);
        consultaAdicionar.setPaciente(paciente);

        consultaRepository.save(consultaAdicionar);
        pacienteRepository.save(paciente);

    }

    public void deletarPaciente(Integer idPaciente) {
        PacienteModel paciente = pacienteRepository.findById(idPaciente).get();

        if (Objects.nonNull(paciente.getConsulta())) {
            consultaRepository.deleteById(paciente.getConsulta().getId());
        }

        pacienteRepository.deleteById(paciente.getId());
    }

}

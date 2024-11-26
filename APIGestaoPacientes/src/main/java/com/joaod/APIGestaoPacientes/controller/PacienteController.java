package com.joaod.APIGestaoPacientes.controller;

import com.joaod.APIGestaoPacientes.model.PacienteModel;
import com.joaod.APIGestaoPacientes.respository.PacienteRepository;
import com.joaod.APIGestaoPacientes.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @Autowired
    private PacienteRepository repository;

    @PostMapping("/criar-Paciente")
    private ResponseEntity criarPaciente(@RequestBody PacienteModel paciente) {
        try {
            service.criarPaciente(paciente);

            return ResponseEntity.ok().build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/Deletar-Paciente/{idPaciente}")
    private ResponseEntity deletarPaciente(@PathVariable int idPaciente) {
        try {
            service.deletarPaciente(idPaciente);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/Listar-Pacientes")
    private List<PacienteModel> listarPacientes() {
        return repository.findAll();
    }

    @PutMapping("Editar-Paciente/{idPaciente}")
    private ResponseEntity editarPaciente(@RequestBody PacienteModel paciente, @PathVariable Integer idPaciente) {
        try {
            service.editarPaciente(paciente, idPaciente);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("Adicioanr-Consulta/{idPaciente}/{idConsulta}")
    private ResponseEntity adicionarConsulta(@PathVariable Integer idPaciente, @PathVariable Integer idConsulta) {
        try {
            service.adicionarConsulta(idPaciente, idConsulta);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}

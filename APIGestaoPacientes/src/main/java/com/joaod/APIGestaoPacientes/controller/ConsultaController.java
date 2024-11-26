package com.joaod.APIGestaoPacientes.controller;

import com.joaod.APIGestaoPacientes.model.ConsultaModel;
import com.joaod.APIGestaoPacientes.respository.ConsultaRepository;
import com.joaod.APIGestaoPacientes.respository.PacienteRepository;
import com.joaod.APIGestaoPacientes.service.ConsultaService;
import com.joaod.APIGestaoPacientes.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private ConsultaRepository repository;

    @PostMapping("/Criar-Consulta")
    private ResponseEntity criarConsulta(@RequestBody ConsultaModel consulta){
        try {
            consultaService.criarConsulta(consulta);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/Listar-Consultas")
    private List<ConsultaModel> listarConsultas(){
        try {
            return repository.findAll();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("Listar-Consultas/{idPaciente}")
    private List<ConsultaModel> listarConsultasPaciente(@PathVariable int idPaciente){
        return consultaService.listarConsultasPacientes(idPaciente);
    }

    @PutMapping("/Editar-Consulta/{idConsulta}")
    private ResponseEntity editarConsulta(@PathVariable int idConsulta, @RequestBody ConsultaModel informacoesAtualizadasConsulta){
        try {
            consultaService.editarConsulta(informacoesAtualizadasConsulta, idConsulta);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/Deletar-Consulta/{idConsulta}")
    private ResponseEntity deletarConsulta(@PathVariable int idConsulta){
        try {
            consultaService.deletarConsulta(idConsulta);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}

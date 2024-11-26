package com.joaod.APIGestaoPacientes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GestaoPacientesController {

    @GetMapping("/ping")
    public String ping() {
        return "Pong";
    }

}

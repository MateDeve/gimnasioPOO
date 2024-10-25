package com.example.gimnasio.controller;

import com.example.gimnasio.model.Cliente;
import com.example.gimnasio.model.Rutina;
import com.example.gimnasio.service.GeneradorRutinasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rutinas")
public class GeneradorRutinasController {

    @Autowired
    private GeneradorRutinasService generadorRutinasService;

    // Endpoint para generar una rutina para un cliente
    @PostMapping("/generar")
    public Rutina generarRutina(@RequestBody Cliente cliente) {
        return generadorRutinasService.generarRutinaParaCliente(cliente);
    }

}


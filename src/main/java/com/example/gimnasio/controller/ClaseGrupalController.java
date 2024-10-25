package com.example.gimnasio.controller;

import com.example.gimnasio.model.ClaseGrupal;
import com.example.gimnasio.model.Cliente;
import com.example.gimnasio.service.ClaseGrupalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases-grupales")
public class ClaseGrupalController {

    @Autowired
    private ClaseGrupalService claseGrupalService;

    // Endpoint para agregar una clase grupal
    @PostMapping("/agregar")
    public String agregarClaseGrupal(@RequestBody ClaseGrupal claseGrupal) {
        claseGrupalService.agregarClaseGrupal(claseGrupal);
        return "Clase grupal agregada exitosamente";
    }

    // Endpoint para inscribir un cliente en una clase grupal
    @PostMapping("/{nombreClase}/inscribir")
    public String inscribirCliente(@PathVariable String nombreClase, @RequestBody Cliente cliente) {
        claseGrupalService.inscribirCliente(nombreClase, cliente);
        return "Cliente inscrito en la clase " + nombreClase;
    }

    // Endpoint para mostrar los participantes de una clase grupal
    @GetMapping("/{nombreClase}/participantes")
    public List<Cliente> mostrarParticipantes(@PathVariable String nombreClase) {
        return claseGrupalService.mostrarParticipantes(nombreClase);
    }

    // Endpoint para consultar disponibilidad de una clase grupal
    @GetMapping("/{nombreClase}/disponibilidad")
    public boolean consultarDisponibilidad(@PathVariable String nombreClase) {
        return claseGrupalService.consultarDisponibilidad(nombreClase);
    }

    // Endpoint para obtener todas las clases grupales
    @GetMapping("/todas")
    public List<ClaseGrupal> obtenerClasesGrupales() {
        return claseGrupalService.obtenerClasesGrupales();
    }
}

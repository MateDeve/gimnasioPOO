package com.example.gimnasio.controller;

import com.example.gimnasio.model.Rutina;
import com.example.gimnasio.service.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutinas")
public class RutinaController {

    @Autowired
    private RutinaService rutinaService;

    // Agregar una nueva rutina
    @PostMapping("/agregar")
    public String agregarRutina(@RequestBody Rutina rutina) {
        rutinaService.agregarRutina(rutina);
        return "Rutina agregada: " + rutina.getNombre();
    }

    // Eliminar una rutina
    @DeleteMapping("/eliminar/{nombre}")
    public String eliminarRutina(@PathVariable String nombre) {
        Rutina rutina = rutinaService.obtenerRutinaPorNombre(nombre);
        if (rutina != null) {
            rutinaService.eliminarRutina(rutina);
            return "Rutina eliminada: " + nombre;
        } else {
            return "Rutina no encontrada: " + nombre;
        }
    }

    // Obtener todas las rutinas
    @GetMapping("/todas")
    public List<Rutina> obtenerRutinas() {
        return rutinaService.obtenerRutinas();
    }

    // Obtener rutina por nombre
    @GetMapping("/buscar/{nombre}")
    public Rutina obtenerRutinaPorNombre(@PathVariable String nombre) {
        Rutina rutina = rutinaService.obtenerRutinaPorNombre(nombre);
        if (rutina != null) {
            return rutina;
        } else {
            return null;
        }
    }
}

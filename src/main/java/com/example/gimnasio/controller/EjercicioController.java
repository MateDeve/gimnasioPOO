package com.example.gimnasio.controller;

import com.example.gimnasio.model.Ejercicio;
import com.example.gimnasio.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejercicios")
public class EjercicioController {

    @Autowired
    private EjercicioService ejercicioService;

    // Endpoint para agregar un ejercicio
    @PostMapping("/agregar")
    public String agregarEjercicio(@RequestBody Ejercicio ejercicio) {
        ejercicioService.agregarEjercicio(ejercicio);
        return "Ejercicio agregado: " + ejercicio.getNombre();
    }

    // Endpoint para obtener todos los ejercicios
    @GetMapping("/todos")
    public List<Ejercicio> obtenerTodosLosEjercicios() {
        return ejercicioService.obtenerTodosLosEjercicios();
    }

    // Endpoint para eliminar un ejercicio por su nombre
    @DeleteMapping("/eliminar/{nombre}")
    public String eliminarEjercicio(@PathVariable String nombre) {
        boolean eliminado = ejercicioService.eliminarEjercicioPorNombre(nombre);
        return eliminado ? "Ejercicio eliminado: " + nombre : "Ejercicio no encontrado: " + nombre;
    }

    // Endpoint para buscar un ejercicio por nombre
    @GetMapping("/buscar/{nombre}")
    public Ejercicio buscarEjercicioPorNombre(@PathVariable String nombre) {
        return ejercicioService.buscarEjercicioPorNombre(nombre);
    }
}

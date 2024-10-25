package com.example.gimnasio.controller;

import com.example.gimnasio.model.Cliente;
import com.example.gimnasio.model.Entrenador;
import com.example.gimnasio.model.Rutina;
import com.example.gimnasio.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;
    private final List<Cliente> clientes = new ArrayList<>();

    // Endpoint para agregar un entrenador
    @PostMapping("/agregar")
    public String agregarEntrenador(@RequestBody Entrenador entrenador) {
        entrenadorService.agregarEntrenador(entrenador);
        return "Entrenador agregado exitosamente";
    }

    // Endpoint para obtener todos los entrenadores
    @GetMapping("/todos")
    public List<Entrenador> obtenerEntrenadores() {
        return entrenadorService.obtenerEntrenadores();
    }

    // Endpoint para asignar un cliente a un entrenador
    @PostMapping("/{nombreEntrenador}/asignar-cliente")
    public String asignarCliente(@PathVariable String nombreEntrenador, @RequestBody Cliente cliente) {
        entrenadorService.asignarCliente(nombreEntrenador, cliente);
        return "Cliente asignado exitosamente";
    }

    @GetMapping("/{nombreEntrenador}/clientes-asignados")
    public List<Cliente> obtenerClientesAsignados(@PathVariable String nombreEntrenador) {
        return entrenadorService.obtenerClientesAsignados(nombreEntrenador);
    }

    // Endpoint para planificar el entrenamiento de un cliente
    @PostMapping("/{nombreEntrenador}/planificar-entrenamiento/{nombreCliente}")
    public String planificarEntrenamiento(@PathVariable String nombreEntrenador, @PathVariable String nombreCliente, @RequestBody Rutina rutina) {
        entrenadorService.planificarEntrenamiento(nombreEntrenador, nombreCliente, rutina);
        return "Entrenamiento planificado para " + nombreCliente + " exitosamente";
    }

    @GetMapping("/{nombre}")
    public Entrenador buscarEntrenadorPorNombre(@PathVariable String nombre) {
        return entrenadorService.buscarEntrenadorPorNombre(nombre);
    }
}

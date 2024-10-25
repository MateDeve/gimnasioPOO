package com.example.gimnasio.controller;

import com.example.gimnasio.model.Equipo;
import com.example.gimnasio.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    // Endpoint para agregar un equipo
    @PostMapping("/agregar")
    public String agregarEquipo(@RequestBody Equipo equipo) {
        equipoService.agregarEquipo(equipo);
        return "Equipo agregado exitosamente";
    }

    // Endpoint para obtener todos los equipos
    @GetMapping("/todos")
    public List<Equipo> obtenerEquipos() {
        return equipoService.obtenerEquipos();
    }

    // Endpoint para registrar el mantenimiento de un equipo
    @PutMapping("/registrar-mantenimiento/{nombre}")
    public String registrarMantenimiento(@PathVariable String nombre) {
        boolean actualizado = equipoService.registrarMantenimiento(nombre);
        if (actualizado) {
            return "Mantenimiento registrado para el equipo: " + nombre;
        } else {
            return "Equipo no encontrado.";
        }
    }

    // Endpoint para obtener un equipo por su nombrregistrar-mantenimiento
    @GetMapping("/{nombre}")
    public Equipo obtenerEquipoPorNombre(@PathVariable String nombre) {
        return equipoService.obtenerEquipoPorNombre(nombre);
    }

    // Endpoint para eliminar un equipo
    @DeleteMapping("/eliminar/{nombre}")
    public String eliminarEquipo(@PathVariable String nombre) {
        boolean eliminado = equipoService.eliminarEquipo(nombre);
        if (eliminado) {
            return "Equipo eliminado exitosamente";
        } else {
            return "Equipo no encontrado.";
        }
    }
}

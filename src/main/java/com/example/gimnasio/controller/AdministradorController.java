package com.example.gimnasio.controller;

import com.example.gimnasio.model.Administrador;
import com.example.gimnasio.model.Membresia;
import com.example.gimnasio.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    // Métodos CRUD básicos para el Administrador (agregar, obtener, eliminar)
    @PostMapping("/agregar")
    public String agregarAdministrador(@RequestBody Administrador administrador) {
        administradorService.agregarAdministrador(administrador);
        return "Administrador agregado exitosamente.";
    }

    @GetMapping("/todos")
    public List<Administrador> obtenerTodosLosAdministradores() {
        return administradorService.obtenerAdministradores();
    }

    @DeleteMapping("/eliminar/{nombre}")
    public String eliminarAdministrador(@PathVariable String nombre) {
        boolean eliminado = administradorService.eliminarAdministrador(nombre);
        if (eliminado) {
            return "Administrador eliminado exitosamente.";
        } else {
            return "Administrador no encontrado.";
        }
    }
    @GetMapping("/buscar/{nombre}")
    public Administrador obtenerAdministradorPorNombre(@PathVariable String nombre) {
        return administradorService.obtenerAdministradorPorNombre(nombre);
    }


    @PutMapping("/{nombreAdministrador}/asignar-membresia/{nombreCliente}")
    public String asignarMembresia(@PathVariable String nombreAdministrador, @PathVariable String nombreCliente, @RequestBody Membresia membresia) {
        administradorService.asignarMembresia(nombreAdministrador, nombreCliente, membresia);
        return "Membresía asignada correctamente";
    }

    @PostMapping("/{nombreAdministrador}/asignar-tarea")
    public String asignarTarea(@PathVariable String nombreAdministrador, @RequestBody String tarea) {
        Administrador administrador = administradorService.obtenerAdministradorPorNombre(nombreAdministrador);
        if (administrador != null) {
            administrador.asignarTarea(tarea);
            return "Tarea asignada: " + tarea;
        }
        return "Administrador no encontrado.";
    }

    @GetMapping("/{nombreAdministrador}/mostrar-detalles")
    public String mostrarDetalles(@PathVariable String nombreAdministrador) {
        Administrador administrador = administradorService.obtenerAdministradorPorNombre(nombreAdministrador);
        if (administrador != null) {
            administrador.mostrarDetalles();
            return "Detalles mostrados en consola.";
        }
        return "Administrador no encontrado.";
    }

}

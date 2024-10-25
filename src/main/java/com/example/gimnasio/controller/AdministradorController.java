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
    @GetMapping("/{nombre}")
    public Administrador obtenerAdministradorPorNombre(@PathVariable String nombre) {
        return administradorService.obtenerAdministradorPorNombre(nombre);
    }


    @PostMapping("/{nombreAdministrador}/asignar-membresia/{nombreCliente}")
    public void asignarMembresia(@PathVariable String nombreAdministrador, @PathVariable String nombreCliente, @RequestBody Membresia membresia) {
        administradorService.asignarMembresia(nombreAdministrador, nombreCliente, membresia);
    }

}

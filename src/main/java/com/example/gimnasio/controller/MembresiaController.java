package com.example.gimnasio.controller;

import com.example.gimnasio.model.Membresia;
import com.example.gimnasio.service.MembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membresias")
public class MembresiaController {

    @Autowired
    private MembresiaService membresiaService;

    // Endpoint para agregar una membresía
    @PostMapping("/agregar")
    public String agregarMembresia(@RequestBody Membresia membresia) {
        membresiaService.agregarMembresia(membresia);
        return "Membresía agregada exitosamente";
    }

    // Endpoint para obtener todas las membresías
    @GetMapping("/todas")
    public List<Membresia> obtenerMembresias() {
        return membresiaService.obtenerMembresias();
    }

    // Endpoint para obtener una membresía por tipo
    @GetMapping("/{tipo}")
    public Membresia obtenerMembresia(@PathVariable String tipo) {
        return membresiaService.obtenerMembresiaPorTipo(tipo);
    }

    // Endpoint para eliminar una membresía por tipo
    @DeleteMapping("/eliminar/{tipo}")
    public String eliminarMembresia(@PathVariable String tipo) {
        membresiaService.eliminarMembresia(tipo);
        return "Membresía eliminada exitosamente";
    }
}

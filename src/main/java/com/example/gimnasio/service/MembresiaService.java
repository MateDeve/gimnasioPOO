package com.example.gimnasio.service;

import com.example.gimnasio.exception.MembresiaNoEncontrada;
import com.example.gimnasio.model.Membresia;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembresiaService {
    private List<Membresia> membresias = new ArrayList<>();

    // Agregar una nueva membresía
    public void agregarMembresia(Membresia membresia) {
        membresias.add(membresia);
    }

    // Consultar todas las membresías
    public List<Membresia> obtenerMembresias() {
        return membresias;
    }

    // Consultar una membresía por tipo
    public Membresia obtenerMembresiaPorTipo(String tipo) {
        return membresias.stream()
                .filter(m -> m.getTipo().equalsIgnoreCase(tipo))
                .findFirst()
                .orElseThrow(() -> new MembresiaNoEncontrada(tipo));
    }

    // Eliminar una membresía
    public void eliminarMembresia(String tipo) {
        membresias.removeIf(m -> m.getTipo().equalsIgnoreCase(tipo));
    }
}
